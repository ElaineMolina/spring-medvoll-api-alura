package com.molina.med.voll.api.medico;

import com.molina.med.voll.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        @Valid DadosEndereco endereco
) {


}
