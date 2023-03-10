package br.com.viniciusribeiro.serverprotocolo.api.evento.arquivamento;

import br.com.viniciusribeiro.serverprotocolo.api.evento.Evento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "evento_arquivamento")
@NoArgsConstructor
@AllArgsConstructor
public class EventoArquivamento {

    @Id
    @Column(name = "id")
    private Long id;

    @MapsId
    @OneToOne(mappedBy = "arquivamento")
    @JoinColumn(name = "id", foreignKey = @ForeignKey(name = "fk_evento_arquivamento"))
    private Evento evento;


    @Column(name = "motivo", length = 200, nullable = false)
    @Size(min = 5, max = 200, message = "Informe um motivo do arquivamento entre 5 e 200 caracteres")
    @NotNull(message = "Informe o motivo do arquivamento")
    private String motivo;

    @Column(name = "observacoes", length = 300)
    private String observacoes;

}
