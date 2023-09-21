package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.exception.ValidacaoException;
import med.voll.api.repository.MedicoRepository;

public class ValidadorMedicoComOutraConsultaNoMesmoHorario {

    private MedicoRepository medicoRepository;
    public void validar(DadosAgendamentoConsulta dados){
        var medicoPossuiOutraConsultaMesmoHorario = medicoRepository
                .existsByMedicoIdAndData(dados.idMedico(), dados.data());

        if(medicoPossuiOutraConsultaMesmoHorario){
            throw new ValidacaoException("Médico já possui outra consulta agendada nesse mesmo horaŕio");
        }
    }
}
