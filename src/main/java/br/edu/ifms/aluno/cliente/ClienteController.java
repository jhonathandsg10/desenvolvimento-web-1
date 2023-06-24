/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aluno.cliente;

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
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired // faz o Spring criar uma instância de ClienteService
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<ClienteDto>> listar() {
        List<Cliente> listaEntity = service.listar();
        List<ClienteDto> listaDto = ClienteMapper.INSTANCE.map(listaEntity);
        return ResponseEntity.ok(listaDto);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteDto> cadastrar(
            @RequestBody @Valid ClienteForm form) {
        Cliente entity = ClienteMapper.INSTANCE.toEntity(form);
        service.salvar(entity);
        ClienteDto dto = ClienteMapper.INSTANCE.toDto(entity);
        return ResponseEntity.accepted().body(dto);
    }
    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<ClienteDto> obterPorId(@PathVariable Long id) {
        Cliente entity = service.buscarPorId(id);

        if (entity != null) {
            ClienteDto dto = ClienteMapper.INSTANCE.toDto(entity);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ClienteDto> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid ClienteForm form) {
        Cliente entity = service.atualizar(id, form);
        ClienteDto dto = ClienteMapper.INSTANCE.toDto(entity);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }
}