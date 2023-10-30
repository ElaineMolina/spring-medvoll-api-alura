package com.molina.med.voll.api.controller;

import com.molina.med.voll.api.pacientes.DadosCadastroPaciente;
import com.molina.med.voll.api.pacientes.Paciente;
import com.molina.med.voll.api.pacientes.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastrarPacientes(@RequestBody  @Valid DadosCadastroPaciente dados) {
        pacienteRepository.save(new Paciente(dados));
    }
}
