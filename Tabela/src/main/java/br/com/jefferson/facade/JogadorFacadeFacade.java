package br.com.jefferson.facade;

import br.com.jefferson.http.JogadorHttp;
import br.com.jefferson.interfaces.IJogadorFacade;
import br.com.jefferson.negocio.JogadorRN;

import javax.ejb.EJB;
import java.util.List;

public class JogadorFacadeFacade implements IJogadorFacade {

    @EJB
    private JogadorRN jogadorRN;

    @Override
    public List<JogadorHttp> buscarJogadores() {
        return jogadorRN.buscarJogadores();
    }

    @Override
    public JogadorHttp gravarJogador(JogadorHttp jogadorHttp) throws Exception {
        return jogadorRN.gravarJogador(jogadorHttp);
    }

    @Override
    public void atualizarJogador(JogadorHttp jogadorHttp) throws Exception {
        jogadorRN.atualizarJogador(jogadorHttp);
    }

    @Override
    public void excluirJogador(Long id) throws Exception {
        jogadorRN.excluirJogador(id);
    }

    @Override
    public JogadorHttp buscarPorId(Long id) throws Exception {
        return jogadorRN.buscarPorId(id);
    }
}
