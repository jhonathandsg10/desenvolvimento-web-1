/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aluno.cliente;

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
public class ClienteDto {
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String rua;
    private String numero;
}
