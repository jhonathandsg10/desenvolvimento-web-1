/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aluno.servico;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;


/**
 *
 * @author 02709564173
 */
@Mapper
public interface ServicoMapper {

    public static final ServicoMapper INSTANCE = Mappers
            .getMapper(ServicoMapper.class);

    public ServicoDto toDto(Servico entity);

    public List<ServicoDto> map(List<Servico> items);

    @Mapping (target = "id", ignore = true)
    public void update(ServicoForm dto, @MappingTarget Servico entity);

    @Mapping (target = "id", ignore = true)
    public Servico toEntity(ServicoForm form);
}
