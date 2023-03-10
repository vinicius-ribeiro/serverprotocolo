package br.com.viniciusribeiro.serverprotocolo.api.evento.arquivamento;

import br.com.viniciusribeiro.serverprotocolo.api.evento.Evento;
import br.com.viniciusribeiro.serverprotocolo.api.evento.TipoEvento;
import br.com.viniciusribeiro.serverprotocolo.api.protocolo.Protocolo;
import br.com.viniciusribeiro.serverprotocolo.api.protocolo.Situacao;
import br.com.viniciusribeiro.serverprotocolo.api.protocolo.crud.ProtocoloCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoArquivamentoService {

    @Autowired
    private ProtocoloCrudService protocoloCrudService;

    @Autowired
    private EventoArquivamentoRepository repository;

    public Evento arquivar(EventoArquivamento arquivamento) throws Exception {
        Protocolo prtc = arquivamento.getEvento().getProtocolo();

        if(prtc == null) {
            throw new Exception("Protocolo não encontrado para o evento " + arquivamento.getEvento().getId());
        }

        prtc = protocoloCrudService.findById(prtc.getId());
        arquivamento.setEvento(new Evento(prtc));
        arquivamento.getEvento().setTipoEvento(TipoEvento.ARQUIVAMENTO);

        prtc.setSituacao(Situacao.ARQUIVADO);
        arquivamento.getEvento().setProtocolo(protocoloCrudService.save(prtc));

        arquivamento = repository.save(arquivamento);
        arquivamento.getEvento().setArquivamento(arquivamento);

        return arquivamento.getEvento();
    }

}
