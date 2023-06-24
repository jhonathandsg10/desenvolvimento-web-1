/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aluno.solicitacao;

import br.edu.ifms.aluno.cliente.ClienteMapper;
import br.edu.ifms.aluno.servico.ServicoMapper;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;


/**
 *
 * @author 02709564173
 */
@Mapper(
        uses={ClienteMapper.class,ServicoMapper.class}
)
public interface SolicitacaoMapper {

    public static final SolicitacaoMapper INSTANCE = Mappers
            .getMapper(SolicitacaoMapper.class);

    public SolicitacaoDto toDto(Solicitacao entity);

    public List<SolicitacaoDto> map(List<Solicitacao> items);

    @Mapping (target = "id", ignore = true)
    public void update(SolicitacaoForm dto, @MappingTarget Solicitacao entity);

    @Mapping (target = "id", ignore = true)
    @Mapping (target = "dataEmissao", expression = "java(LocalDateTime.now())")
    public Solicitacao toEntity(SolicitacaoForm form);
}