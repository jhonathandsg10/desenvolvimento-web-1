/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aluno.servico;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 02709564173
 */
@Service
public class ServicoService {
    @Autowired
    private ServicoRepository repository;

    public List<Servico> listar() {
        return repository.findAll();
    }

    public Servico salvar(Servico entity) {
        Servico p = repository.save(entity);
        return p;
    }

    public Servico atualizar(Long id, ServicoForm form) {
        Servico entity = buscarPorId(id);
        ServicoMapper.INSTANCE.update(form, entity);
        return entity;
    }

    public Servico buscarPorId(Long id) {
        Optional<Servico> optional = repository.findById(id);
        if (optional.isEmpty()) {
            String msg = "Não existe Servico para o código [%d] informado";
            throw new ServicoNotFoundException(String.format(msg, id));
        }
        return optional.get();
    }

    public void excluir(Long id) {
        Servico entity = buscarPorId(id);
        repository.delete(entity);
    }
}
