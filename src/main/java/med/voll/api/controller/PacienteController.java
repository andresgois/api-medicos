package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import med.voll.api.domain.paciente.DadosListagemPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import med.voll.api.domain.paciente.DadosCadastroPaciente;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.repository.PacienteRepository;

@RestController
@RequestMapping("pacientes")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listar(
            @PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao
    ){
        var page = repository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemPaciente::new);
        return ResponseEntity.ok(page);
    }

}