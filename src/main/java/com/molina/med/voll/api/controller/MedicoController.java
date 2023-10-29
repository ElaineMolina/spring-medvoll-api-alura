package com.molina.med.voll.api.controller;

import com.molina.med.voll.api.medico.DadosCadastroMedico;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PostMapping
    public void cadastrarMedico(@RequestBody DadosCadastroMedico dados) {
        System.out.println(dados);
    }

}
