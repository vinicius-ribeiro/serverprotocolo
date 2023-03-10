package br.com.viniciusribeiro.serverprotocolo.api.protocolo;

import br.com.viniciusribeiro.serverprotocolo.api.assunto.Assunto;
import br.com.viniciusribeiro.serverprotocolo.api.evento.Evento;
import br.com.viniciusribeiro.serverprotocolo.api.interessado.Interessado;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "protocolo")
public class Protocolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo", length = 80)
    private String titulo;

    @Column(name = "descricao", nullable = false, length = 4096)
    @NotNull(message="O descrição do protocolo deve ser informado")
    @Size(min = 5, max = 4096, message = "A descrição do protocolo deve ter de 5 a 4096 caracteres")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "assunto", nullable = false, foreignKey = @ForeignKey(name = "fk_protocolo_assunto"))
    @NotNull(message="O assunto deve ser informado")
    private Assunto assunto;

    @Column(name = "situacao", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message="A situação do protocolo deve ser informada")
    private Situacao situacao;

    @ManyToOne
    @JoinColumn(name = "interessado", nullable = false, foreignKey = @ForeignKey(name = "fk_protocolo_interessado"))
    @NotNull(message = "O interessado deve ser informado")
    private Interessado interessado;

    @OneToMany(mappedBy = "protocolo")
    @JsonIgnore
    private Set<Evento> eventos;

}
