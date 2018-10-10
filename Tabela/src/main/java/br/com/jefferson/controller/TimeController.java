package br.com.jefferson.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("time")
public class TimeController {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getNome() {
        return "Testando ";
    }

}
