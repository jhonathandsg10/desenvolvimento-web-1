/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aluno.solicitacao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 02709564173
 */
@Service
public class SolicitacaoService {
    @Autowired
    private SolicitacaoRepository repository;

    public List<Solicitacao> listar() {
        return repository.findAll();
    }

    public Solicitacao salvar(Solicitacao entity) {
        Solicitacao p = repository.save(entity);
        return p;
    }

    public Solicitacao atualizar(Long id, SolicitacaoForm form) {
        Solicitacao entity = buscarPorId(id);
        SolicitacaoMapper.INSTANCE.update(form, entity);
        return entity;
    }

    public Solicitacao buscarPorId(Long id) {
        Optional<Solicitacao> optional = repository.findById(id);
        if (optional.isEmpty()) {
            String msg = "Não existe Solicitacao para o código [%d] informado";
            throw new SolicitacaoNotFoundException(String.format(msg, id));
        }
        return optional.get();
    }

    public void excluir(Long id) {
        Solicitacao entity = buscarPorId(id);
        repository.delete(entity);
    }
}
