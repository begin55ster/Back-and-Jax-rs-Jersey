package br.com.jefferson.negocio;

import br.com.jefferson.dao.JogadorDao;
import br.com.jefferson.http.JogadorHttp;
import br.com.jefferson.model.Jogador;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class JogadorRN {

    @Inject
    private JogadorDao jogadorDao;

    public List<JogadorHttp> buscarJogadores() {
        List<JogadorHttp> jogadoresHttp = new ArrayList<>();
        List<Jogador> jogadores = jogadorDao.buscarJogadores();
        listJogadoresParaJogadoresHttp(jogadoresHttp, jogadores);
        return jogadoresHttp;
    }

    public JogadorHttp gravarJogador(JogadorHttp jogadorHttp) throws Exception {
        Jogador jogador = new Jogador(jogadorHttp);
        jogadorDao.gravarJogador(jogador);
        jogadorHttp = jogadorParaJogadorHttp(jogador, jogadorHttp);
        return jogadorHttp;
    }

    public void atualizarJogador(JogadorHttp jogadorHttp) throws Exception{
      Jogador jogador = new Jogador(jogadorHttp);
      jogadorDao.atualizarJogador(jogador);
    }

    public void excluirJogador(Long id) throws Exception {
        jogadorDao.excluirJogador(id);
    }

    public JogadorHttp buscarPorId(Long id) throws Exception {
        Jogador jogador = jogadorDao.buscarPorId(id);
        if(jogador != null) {
            JogadorHttp jogadorHttp = new JogadorHttp();
            jogadorHttp = jogadorParaJogadorHttp(jogador, jogadorHttp);
            return jogadorHttp;
        } else {
            throw new NullPointerException();
        }
    }

    private void listJogadoresParaJogadoresHttp(List<JogadorHttp> jogadoresHttp, List<Jogador> jogadores) {
        for(Jogador jogador : jogadores) {
            jogadoresHttp.add(new JogadorHttp(jogador));
        }
    }

    private JogadorHttp jogadorParaJogadorHttp(Jogador jogador, JogadorHttp jogadorHttp) {
        if(jogador != null) {
            jogadorHttp = new JogadorHttp(jogador);
        }
        return jogadorHttp;
    }

}
