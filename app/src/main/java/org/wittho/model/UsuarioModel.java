package org.wittho.model;

import org.wittho.entity.EventoEntity;

import java.util.List;
import java.util.Objects;

public class UsuarioModel {

  public Integer idUsuario;
  public String nome;
  public String cpf;
  public Integer idade;
  public String telefone;
  public List<EventoEntity> eventosCadastrados;

  public UsuarioModel() {}

  public UsuarioModel(Integer idUsuario, String nome, String cpf, Integer idade, String telefone, List<EventoEntity> eventosCadastrados) {
    this.idUsuario = idUsuario;
    this.nome = nome;
    this.cpf = cpf;
    this.idade = idade;
    this.telefone = telefone;
    this.eventosCadastrados = eventosCadastrados;
  }

  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
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

  public Integer getIdade() {
    return idade;
  }

  public void setIdade(Integer idade) {
    this.idade = idade;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public List<EventoEntity> getEventosCadastrados() {
    return eventosCadastrados;
  }

  public void setEventosCadastrados(List<EventoEntity> eventosCadastrados) {
    this.eventosCadastrados = eventosCadastrados;
  }

  @Override
  public String toString() {
    return "UsuarioModel{" +
        "idUsuario=" + idUsuario +
        ", nome='" + nome + '\'' +
        ", cpf='" + cpf + '\'' +
        ", idade=" + idade +
        ", telefone='" + telefone + '\'' +
        ", eventosCadastrados=" + eventosCadastrados +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof UsuarioModel that)) return false;
    return Objects.equals(getIdUsuario(), that.getIdUsuario())
        && Objects.equals(getNome(), that.getNome())
        && Objects.equals(getCpf(), that.getCpf())
        && Objects.equals(getIdade(), that.getIdade())
        && Objects.equals(getTelefone(), that.getTelefone())
        && Objects.equals(getEventosCadastrados(), that.getEventosCadastrados());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getIdUsuario(), getNome(), getCpf(), getIdade(), getTelefone(), getEventosCadastrados());
  }
}
