package br.com.kyouma54.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;


@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "endereco", nullable = false, length = 100)
    private String endereco;

    @NotNull
    @Column(name = "cidade", nullable = false, length = 100)
    private String cidade;

    @NotNull
    @Column(name = "uf", nullable = false, length = 100)
    private String uf;

    @NotNull
    @Column(name = "genero", nullable = false, length = 8)
    private String genero;

    @NotNull
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @NotNull
    @Column(name = "sobre_nome", nullable = false, length = 100)
    private String sobreNome;

    @NotNull
    @Column(name = "num_cpf", nullable = false, length = 30)
    private String numCpf;

    @NotNull
    @Column(name = "dth_nascimento", nullable = false)
    private ZonedDateTime dthNascimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public Customer endereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public Customer cidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public Customer uf(String uf) {
        this.uf = uf;
        return this;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getGenero() {
        return genero;
    }

    public Customer genero(String genero) {
        this.genero = genero;
        return this;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public Customer nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public Customer sobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
        return this;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getNumCpf() {
        return numCpf;
    }

    public Customer numCpf(String numCpf) {
        this.numCpf = numCpf;
        return this;
    }

    public void setNumCpf(String numCpf) {
        this.numCpf = numCpf;
    }

    public ZonedDateTime getDthNascimento() {
        return dthNascimento;
    }

    public Customer dthNascimento(ZonedDateTime dthNascimento) {
        this.dthNascimento = dthNascimento;
        return this;
    }

    public void setDthNascimento(ZonedDateTime dthNascimento) {
        this.dthNascimento = dthNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Customer)) {
            return false;
        }
        return id != null && id.equals(((Customer) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Customer{" +
            "id=" + getId() +
            ", endereco='" + getEndereco() + "'" +
            ", cidade='" + getCidade() + "'" +
            ", uf='" + getUf() + "'" +
            ", genero='" + getGenero() + "'" +
            ", nome='" + getNome() + "'" +
            ", sobreNome='" + getSobreNome() + "'" +
            ", numCpf='" + getNumCpf() + "'" +
            ", dthNascimento='" + getDthNascimento() + "'" +
            "}";
    }
}
