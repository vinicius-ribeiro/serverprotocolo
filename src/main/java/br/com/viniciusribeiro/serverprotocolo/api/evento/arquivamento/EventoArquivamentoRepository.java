package br.com.viniciusribeiro.serverprotocolo.api.evento.arquivamento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoArquivamentoRepository extends JpaRepository<EventoArquivamento, Long> {
}
