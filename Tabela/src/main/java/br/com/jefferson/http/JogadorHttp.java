package br.com.jefferson.http;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.jefferson.model.Jogador;
import com.google.gson.Gson;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class JogadorHttp {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    public JogadorHttp() {

    }

    public JogadorHttp(Jogador jogador) {
        this.id = jogador.getId();
        this.nome = jogador.getNome();
        this.cpf = jogador.getCpf();
        this.email = jogador.getEmail();
        this.telefone = jogador.getTelefone();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String toJson() {
        return new Gson().toJson(this);
    }

//	public String toXML() {
//	    return new XStream().toXML(this);
//	}
}
