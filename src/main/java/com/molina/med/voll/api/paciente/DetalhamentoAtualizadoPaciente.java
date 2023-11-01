package com.molina.med.voll.api.paciente;

import com.molina.med.voll.api.endereco.Endereco;

public record DetalhamentoAtualizadoPaciente(Long id, String nome, String email, String telefone, String cpf,
                                             Endereco endereco) {

    public DetalhamentoAtualizadoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(),
                paciente.getEndereco());
    }
}
