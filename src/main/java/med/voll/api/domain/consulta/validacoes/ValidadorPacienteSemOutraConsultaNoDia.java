package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.exception.ValidacaoException;
import med.voll.api.repository.ConsultaRepository;
import med.voll.api.repository.PacienteRepository;

public class ValidadorPacienteSemOutraConsultaNoDia {

    private ConsultaRepository consultaRepository;
    public void validar(DadosAgendamentoConsulta dados){
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);

        var pacientePossuiOutraCOnsultaNoDia = consultaRepository
                .existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);

        if(!pacientePossuiOutraCOnsultaNoDia){
            throw new ValidacaoException("Paciente já poossui consulta agendada nesse dia");
        }
    }
}
