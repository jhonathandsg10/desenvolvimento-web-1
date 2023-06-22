/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aluno.cliente;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 02709564173
 */
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public List<Cliente> listar() {
        return repository.findAll();
    }

    public Cliente salvar(Cliente entity) {
        Cliente p = repository.save(entity);
        return p;
    }

    public Cliente atualizar(Long id, ClienteForm form) {
        Cliente entity = buscarPorId(id);
        ClienteMapper.INSTANCE.update(form, entity);
        return entity;
    }

    public Cliente buscarPorId(Long id) {
        Optional<Cliente> optional = repository.findById(id);
        if (optional.isEmpty()) {
            String msg = "Não existe Cliente para o código [%d] informado";
            throw new ClienteNotFoundException(String.format(msg, id));
        }
        return optional.get();
    }

    public void excluir(Long id) {
        Cliente entity = buscarPorId(id);
        repository.delete(entity);
    }
}
