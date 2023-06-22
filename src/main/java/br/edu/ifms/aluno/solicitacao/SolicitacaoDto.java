/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aluno.solicitacao;

import br.edu.ifms.aluno.cliente.ClienteDto;
import br.edu.ifms.aluno.servico.ServicoDto;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author 02709564173
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class SolicitacaoDto {
    private Long id;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEmissao;
    
    
    private ClienteDto cliente;
    
    private ServicoDto servico;
}
