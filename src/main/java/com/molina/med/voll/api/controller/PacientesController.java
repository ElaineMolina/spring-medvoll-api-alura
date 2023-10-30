package com.molina.med.voll.api.controller;

import com.molina.med.voll.api.paciente.DadosCadastroPaciente;
import com.molina.med.voll.api.paciente.DadosListagemPacientes;
import com.molina.med.voll.api.paciente.Paciente;
import com.molina.med.voll.api.paciente.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public Page<DadosListagemPacientes> listarPacientes(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return pacienteRepository.findAll(paginacao).map(DadosListagemPacientes::new);
    }
}
