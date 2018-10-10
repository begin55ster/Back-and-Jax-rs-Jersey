package br.com.jefferson.dao;

import br.com.jefferson.model.Jogador;

import java.util.List;

public class JogadorDao extends GenericDao {

    public List<Jogador> buscarJogadores() {
        return findAll(Jogador.class);
    }

    public Jogador gravarJogador(Jogador jogador) throws Exception {
        save(jogador);
        return jogador;
    }

    public Jogador buscarPorId(Long id) {
        return find(Jogador.class, id);
    }

    public void atualizarJogador(Jogador jogador) {
        merge(jogador);
    }

    public void excluirJogador(Long id) {
        delete(Jogador.class, id);
    }





}
