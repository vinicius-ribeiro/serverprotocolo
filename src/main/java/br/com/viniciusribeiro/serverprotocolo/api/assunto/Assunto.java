package br.com.viniciusribeiro.serverprotocolo.api.assunto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "assunto")
public class Assunto {

    public Assunto(String titulo, String prefixoCodProtocolo) {
        this.titulo = titulo;
        this.prefixoCodProtocolo = prefixoCodProtocolo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @Column(name= "titulo", length= 150, nullable =  false)
    @NotNull(message = "O título do assunto deve ser informado")
    @Size(min= 1, max= 150, message= "O título do assunto deve ter de 1 à 150 caracteres")
    private String titulo;

    @Column(name = "prefixo_protocolo", length = 6, nullable = false)
    @Size(min = 3, max = 6, message="O prefixo do protocolo do assunto deve ter de 3 à 6 caracteres")
    @NotNull(message="O prefixo do código do protocolo no assunto deve ser informado")
    private String prefixoCodProtocolo;
}
