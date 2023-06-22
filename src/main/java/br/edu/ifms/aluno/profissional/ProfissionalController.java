/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aluno.profissional;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 02709564173
 */
@RestController
@RequestMapping("/api/Profissional")
public class ProfissionalController {
    @Autowired // faz o Spring criar uma instância de ProfissionalService
    private ProfissionalService service;

    @GetMapping
    public ResponseEntity<List<ProfissionalDto>> listar() {
        List<Profissional> listaEntity = service.listar();
        List<ProfissionalDto> listaDto = ProfissionalMapper.INSTANCE.map(listaEntity);
        return ResponseEntity.ok(listaDto);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProfissionalDto> cadastrar(
            @RequestBody @Valid ProfissionalForm form) {
        Profissional entity = ProfissionalMapper.INSTANCE.toEntity(form);
        service.salvar(entity);
        ProfissionalDto dto = ProfissionalMapper.INSTANCE.toDto(entity);
        return ResponseEntity.accepted().body(dto);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProfissionalDto> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid ProfissionalForm form) {
        Profissional entity = service.atualizar(id, form);
        ProfissionalDto dto = ProfissionalMapper.INSTANCE.toDto(entity);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }
}