package br.com.jefferson.jogador;

import br.com.jefferson.dao.JogadorDao;
import br.com.jefferson.http.JogadorHttp;
import br.com.jefferson.model.Jogador;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TesteJogador {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void main(String args[]) {

        emf = Persistence.createEntityManagerFactory("tabela");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Jogador> jogadores = buscaJogadores();
        for(Jogador jogadorRecuperado : jogadores) {
            System.out.println(jogadorRecuperado.getNome() + "\n");
            System.out.println(jogadorRecuperado.getCpf() + "\n");
            System.out.println(jogadorRecuperado.getEmail() + "\n");
        }
    }

    public static List<Jogador> buscaJogadores() {

        JogadorDao jogadorDao = new JogadorDao();
        List<Jogador> listaJogadores = buscarJogadores();

        return listaJogadores;
    }

    public static List<Jogador> buscarJogadores() {
        return getSession().createCriteria(Jogador.class).list();
    }

    protected static Session getSession() {
        return (Session) em.getDelegate();
    }

}
