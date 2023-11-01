package com.molina.med.voll.api.controller;

import com.molina.med.voll.api.medico.DadosAtualizarMedico;
import com.molina.med.voll.api.medico.DetalhamentoAtualizadoMedico;
import com.molina.med.voll.api.paciente.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarPacientes(@RequestBody  @Valid DadosCadastroPaciente dados,
                                             UriComponentsBuilder uriComponentsBuilder) {
        var paciente = new Paciente(dados);
        pacienteRepository.save(paciente);

        var url = uriComponentsBuilder.path("/paciente/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhamentoAtualizadoPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPacientes>> listarPacientes(@PageableDefault
                                                                                    (size = 10, sort = {"nome"})  Pageable paginacao){
        var page =  pacienteRepository.findAllByAtivoTrue(paginacao).map(DadosListagemPacientes::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarPacientes (@RequestBody @Valid DadosAtualizarPaciente dados){
        var paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DetalhamentoAtualizadoPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity exlcuirPaciente(@PathVariable  Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluirPaciente();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharPaciente(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhamentoAtualizadoPaciente(paciente));
    }

}
