/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aluno.servico;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 *
 * @author 02709564173
 */
@Getter
@EqualsAndHashCode
@Builder
public class ServicoDto {
    private Long id;
    private String descricao;
    private Float preco_hora;
    private Float tempo_servico;
}
