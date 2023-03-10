package br.com.viniciusribeiro.serverprotocolo.api.interessado;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "interessado")
@NoArgsConstructor
@AllArgsConstructor
public class Interessado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", length = 255, nullable = false)
    @Size(min = 3, max = 255, message = "O nome do interessado deve ter entre 3 e 255 caracteres")
    @NotNull(message = "O nome do interessado deve ser informado")
    private String nome;

    @Column(name = "cpf_cnpj", length = 14, nullable = false)
    @NotNull(message = "CPF / CNPJ deve ser informado")
    private String cpfCnpj;

    @Column(name = "ativo", nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    @NotNull(message="Informe se o interessado está ou não ativo")
    private Boolean ativo;

}
