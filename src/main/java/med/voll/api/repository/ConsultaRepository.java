package med.voll.api.repository;

import med.voll.api.domain.consulta.Consulta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    boolean existsByMedicoIdAndData(Long idMedico, LocalDateTime data);

    Page<Consulta> findAll(Pageable pageable);


    boolean existsByPacienteIdAndDataBetween(Long idPaciente
            , LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);


    boolean existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(Long idMedico, LocalDateTime data);
}
