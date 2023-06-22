/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aluno.cliente;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author 02709564173
 */
@Data
@EqualsAndHashCode
@Builder
public class ClienteForm {
    private String nome;
    private String cpf;
    private String telefone;
    private String rua;
    private String numero;
}
