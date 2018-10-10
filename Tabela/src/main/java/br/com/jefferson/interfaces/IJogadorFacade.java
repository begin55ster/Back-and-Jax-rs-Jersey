package br.com.jefferson.interfaces;


import br.com.jefferson.http.JogadorHttp;

import java.util.List;

public interface IJogadorFacade {

    public List<JogadorHttp> buscarJogadores();

    public JogadorHttp gravarJogador(JogadorHttp jogadorHttp) throws Exception;

    public void atualizarJogador(JogadorHttp jogadorHttp) throws Exception;

    public void excluirJogador(Long id) throws Exception;

    public JogadorHttp buscarPorId(Long id) throws Exception;

}