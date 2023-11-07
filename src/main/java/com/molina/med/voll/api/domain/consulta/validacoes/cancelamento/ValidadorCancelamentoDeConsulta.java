package com.molina.med.voll.api.domain.consulta.validacoes.cancelamento;

import com.molina.med.voll.api.domain.consulta.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {
    void validar(DadosCancelamentoConsulta dados);
}
