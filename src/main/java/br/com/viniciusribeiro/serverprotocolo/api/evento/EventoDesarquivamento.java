package br.com.viniciusribeiro.serverprotocolo.api.evento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "evento_desarquivamento")
@NoArgsConstructor
@AllArgsConstructor
public class EventoDesarquivamento {

    @Id
    @Column(name = "id")
    private Long id;

    @MapsId
    @OneToOne(mappedBy = "desarquivamento")
    @JoinColumn(name = "id", foreignKey = @ForeignKey(name = "fk_eventodesarquivamento_evento"))
    private Evento evento;

}
