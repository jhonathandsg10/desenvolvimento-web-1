/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.aluno.solicitacao;

import br.edu.ifms.aluno.cliente.Cliente;
import br.edu.ifms.aluno.servico.Servico;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author 02709564173
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Solicitacao {
    @Id
    @GeneratedValue
    private Long id; 
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataEmissao ;
         @ManyToOne 
         private Cliente cliente;
         @ManyToOne
         private Servico servico;
}
