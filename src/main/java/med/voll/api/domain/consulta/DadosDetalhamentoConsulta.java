package med.voll.api.domain.consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta (Long id,  Long idMedico, Long idPaciente, LocalDateTime data) {

    public  DadosDetalhamentoConsulta(Consulta consuta){
        this(consuta.getId(), consuta.getMedico().getId(), consuta.getPaciente().getId(), consuta.getData());
    }
}
