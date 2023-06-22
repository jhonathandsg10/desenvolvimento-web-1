/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aluno.solicitacao;

import br.edu.ifms.aluno.cliente.ClienteDto;
import br.edu.ifms.aluno.servico.ServicoDto;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author 02709564173
 */
@Data
@EqualsAndHashCode
@Builder
public class SolicitacaoForm {
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEmissao;
    
    private ClienteDto cliente;
    
    private ServicoDto servico;
}
