package br.com.kyouma54.service.dto;

import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * DTO para a {@link br.com.kyouma54.domain.Customer} entidade.
 */
public class CustomerDTO implements Serializable {
    
    private Long id;

    @NotNull
    private String endereco;

    @NotNull
    private String cidade;

    @NotNull
    private String uf;

    @NotNull
    private String genero;

    @NotNull
    private String nome;

    @NotNull
    private String sobreNome;

    @NotNull
    private String numCpf;

    @NotNull
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

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getNumCpf() {
        return numCpf;
    }

    public void setNumCpf(String numCpf) {
        this.numCpf = numCpf;
    }

    public ZonedDateTime getDthNascimento() {
        return dthNascimento;
    }

    public void setDthNascimento(ZonedDateTime dthNascimento) {
        this.dthNascimento = dthNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CustomerDTO)) {
            return false;
        }

        return id != null && id.equals(((CustomerDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CustomerDTO{" +
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
