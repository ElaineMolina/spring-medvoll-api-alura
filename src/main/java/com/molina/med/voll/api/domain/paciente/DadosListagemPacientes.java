package com.molina.med.voll.api.domain.paciente;

import jakarta.validation.constraints.NotNull;

public record DadosListagemPacientes(

        @NotNull
        Long id,
        String nome,
        String email,
        String cpf
) {

    public DadosListagemPacientes(Paciente paciente){
        this(paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getCpf());
    }
}
