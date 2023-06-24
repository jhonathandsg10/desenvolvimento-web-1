/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aluno.solicitacao;

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
@RequestMapping("/api/solicitacao")
public class SolicitacaoController {
    @Autowired // faz o Spring criar uma instância de SolicitacaoService
    private SolicitacaoService service;

    @GetMapping
    public ResponseEntity<List<SolicitacaoDto>> listar() {
        List<Solicitacao> listaEntity = service.listar();
        List<SolicitacaoDto> listaDto = SolicitacaoMapper.INSTANCE.map(listaEntity);
        return ResponseEntity.ok(listaDto);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<SolicitacaoDto> cadastrar(
            @RequestBody @Valid SolicitacaoForm form) {
        Solicitacao entity = SolicitacaoMapper.INSTANCE.toEntity(form);
        service.salvar(entity);
        SolicitacaoDto dto = SolicitacaoMapper.INSTANCE.toDto(entity);
        return ResponseEntity.accepted().body(dto);
    }
    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<SolicitacaoDto> obterPorId(@PathVariable Long id) {
        Solicitacao entity = service.buscarPorId(id);

        if (entity != null) {
            SolicitacaoDto dto = SolicitacaoMapper.INSTANCE.toDto(entity);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<SolicitacaoDto> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid SolicitacaoForm form) {
        Solicitacao entity = service.atualizar(id, form);
        SolicitacaoDto dto = SolicitacaoMapper.INSTANCE.toDto(entity);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }
}