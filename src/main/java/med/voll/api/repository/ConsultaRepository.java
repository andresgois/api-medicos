package med.voll.api.repository;

import med.voll.api.domain.consulta.Consuta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consuta, Long> {
    boolean existsByPacienteIdAndDataBetween(Long idPaciente
            , LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
}
