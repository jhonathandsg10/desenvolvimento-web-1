/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aluno.profissional;

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
public interface ProfissionalMapper {

    public static final ProfissionalMapper INSTANCE = Mappers
            .getMapper(ProfissionalMapper.class);

    public ProfissionalDto toDto(Profissional entity);

    public List<ProfissionalDto> map(List<Profissional> items);

    @Mapping(target = "id", ignore = true)
    public void update(ProfissionalForm dto, @MappingTarget Profissional entity);

    @Mapping(target = "id", ignore = true)
    public Profissional toEntity(ProfissionalForm form);
}
