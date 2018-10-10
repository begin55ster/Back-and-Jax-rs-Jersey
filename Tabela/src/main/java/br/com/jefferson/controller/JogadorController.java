package br.com.jefferson.controller;

import br.com.jefferson.http.JogadorHttp;
import br.com.jefferson.interfaces.IJogadorFacade;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("jogador")
public class JogadorController {

    @Inject
    private IJogadorFacade jogadorFacade;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<JogadorHttp> buscarJogadores()    {
        return jogadorFacade.buscarJogadores();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscaJogadorPorId(@PathParam("id") long id) {
        try {
            JogadorHttp jogadorHttp = jogadorFacade.buscarPorId(id);
            return Response.ok(jogadorHttp).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.noContent().build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrarJogador(JogadorHttp jogadorHttp){
        try {
            jogadorHttp = jogadorFacade.gravarJogador(jogadorHttp);
            URI uri = URI.create("/jogador/" + jogadorHttp.getId());
            return Response.created(uri).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarJogador(JogadorHttp jogadorHttp) {
        try {
            jogadorFacade.atualizarJogador(jogadorHttp);
            return Response.ok(jogadorHttp).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.notModified().build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response excluirJogador(@PathParam("id") long id){
        try {
            jogadorFacade.excluirJogador(id);
            return Response.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.notModified().build();
        }
    }

}
