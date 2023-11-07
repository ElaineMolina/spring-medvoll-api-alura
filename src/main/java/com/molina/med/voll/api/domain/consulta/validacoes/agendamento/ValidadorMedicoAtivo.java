package com.molina.med.voll.api.domain.consulta.validacoes.agendamento;

import com.molina.med.voll.api.domain.ValidacaoException;
import com.molina.med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import com.molina.med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = medicoRepository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com médico escolhido");
        }
    }
}