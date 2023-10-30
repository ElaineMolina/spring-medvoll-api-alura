package com.molina.med.voll.api.paciente;

import com.molina.med.voll.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        @Valid DadosEndereco endereco
) {
}
