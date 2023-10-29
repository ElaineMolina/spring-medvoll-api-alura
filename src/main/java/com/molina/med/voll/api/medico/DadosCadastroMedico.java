package com.molina.med.voll.api.medico;

import com.molina.med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        DadosEndereco endereco) {
}
