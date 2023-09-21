package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.exception.ValidacaoException;
import med.voll.api.repository.MedicoRepository;
import med.voll.api.repository.PacienteRepository;

public class ValidadorPacienteAtivo {

    private PacienteRepository pacienteRepository;
    public void validar(DadosAgendamentoConsulta dados){
        var pacienteEstaAtivo = pacienteRepository
                .findAtivoById(dados.idPaciente());

        if(!pacienteEstaAtivo){
            throw new ValidacaoException("Consulat não pode ser agendada com paciente excluído");
        }
    }
}
