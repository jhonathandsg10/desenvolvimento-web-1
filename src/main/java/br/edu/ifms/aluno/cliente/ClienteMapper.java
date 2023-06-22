/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aluno.cliente;

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
public interface ClienteMapper {

    public static final ClienteMapper INSTANCE = Mappers
            .getMapper(ClienteMapper.class);

    public ClienteDto toDto(Cliente entity);

    public List<ClienteDto> map(List<Cliente> items);

    @Mapping(target = "id", ignore = true)
    public void update(ClienteForm dto, @MappingTarget Cliente entity);

    @Mapping(target = "id", ignore = true)
    public Cliente toEntity(ClienteForm form);
}
