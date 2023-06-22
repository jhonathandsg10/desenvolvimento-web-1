/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aluno.profissional;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 02709564173
 */
@Service
public class ProfissionalService {
    @Autowired
    private ProfissionalRepository repository;

    public List<Profissional> listar() {
        return repository.findAll();
    }

    public Profissional salvar(Profissional entity) {
        Profissional p = repository.save(entity);
        return p;
    }

    public Profissional atualizar(Long id, ProfissionalForm form) {
        Profissional entity = buscarPorId(id);
        ProfissionalMapper.INSTANCE.update(form, entity);
        return entity;
    }

    public Profissional buscarPorId(Long id) {
        Optional<Profissional> optional = repository.findById(id);
        if (optional.isEmpty()) {
            String msg = "Não existe Profissional para o código [%d] informado";
            throw new ProfissionalNotFoundException(String.format(msg, id));
        }
        return optional.get();
    }

    public void excluir(Long id) {
        Profissional entity = buscarPorId(id);
        repository.delete(entity);
    }
}
