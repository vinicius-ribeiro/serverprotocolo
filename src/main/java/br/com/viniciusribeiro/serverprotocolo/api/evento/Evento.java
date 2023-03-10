package br.com.viniciusribeiro.serverprotocolo.api.evento;

import br.com.viniciusribeiro.serverprotocolo.api.evento.arquivamento.EventoArquivamento;
import br.com.viniciusribeiro.serverprotocolo.api.protocolo.Protocolo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "evento")
public class Evento {

    public Evento(Protocolo protocolo) {
        this.protocolo = protocolo;
        this.dataHora = Timestamp.valueOf(LocalDateTime.now());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "data_hora", nullable = false)
    @NotNull(message="Data e Hora do evento deve ser informada")
    private Timestamp dataHora;

    @Column(name = "tipo_evento", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message="Informe o tipo do evento")
    private TipoEvento tipoEvento;

    @ManyToOne
    @JoinColumn(name = "protocolo", nullable = false, foreignKey = @ForeignKey(name = "fk_evento_protocolo"))
    @NotNull(message="Informe o protocolo no evento")
    private Protocolo protocolo;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private EventoArquivamento arquivamento;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private EventoDesarquivamento desarquivamento;

}
