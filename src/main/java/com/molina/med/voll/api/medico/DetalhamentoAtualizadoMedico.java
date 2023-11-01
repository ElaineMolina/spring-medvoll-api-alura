package com.molina.med.voll.api.medico;

import com.molina.med.voll.api.endereco.Endereco;

public record DetalhamentoAtualizadoMedico(Long id, String nome, String email, String crm,
                                           String telefone, Especialidade especialidade, Endereco endereco) {

    public DetalhamentoAtualizadoMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(),
                medico.getEspecialidade(), medico.getEndereco());
    }
}
