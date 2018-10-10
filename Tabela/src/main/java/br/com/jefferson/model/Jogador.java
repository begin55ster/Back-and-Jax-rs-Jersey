package br.com.jefferson.model;

import br.com.jefferson.http.JogadorHttp;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="jogador")
public class Jogador extends BaseEntity<Serializable> implements Serializable{

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    public Jogador() {
    }

    public Jogador(JogadorHttp jogadorHttp) {
        this.id = jogadorHttp.getId();
        this.nome = jogadorHttp.getNome();
        this.cpf = jogadorHttp.getCpf();
        this.email = jogadorHttp.getEmail();
        this.telefone = jogadorHttp.getTelefone();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() { return id; }

    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    @Column(name = "cpf")
    public String getCpf() {
        return cpf;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    @Column(name = "telefone")
    public String getTelefone() {
        return telefone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    @Transient
    public Serializable getSeq() {
        return id;
    }

    @Override
    @Transient
    public void setSeq(Serializable seq) {

    }

    public boolean equals(Object object) {
        if (this.equals(object)) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }

        Jogador jogador = (Jogador) object;

        return id.equals(jogador.id);
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id.hashCode();
        return result;
    }
}
