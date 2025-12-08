package com.edifica.bioedifica.model;

import java.util.List;

import com.edifica.bioedifica.enums.usuario.RoleUsuario;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;
    @Enumerated(EnumType.STRING)
    private RoleUsuario perfil;
    @OneToMany(mappedBy = "usuario")
    private List<Projeto> projetos;

    // Construtores
    public Usuario() {}

    public Usuario(Long id) {
        this.id = id;
    }

    public Usuario(Long id, String nome, String email, String senha, RoleUsuario perfil, List<Projeto> projetos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
        this.projetos = projetos;
    }

    // Getters e Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public RoleUsuario getPerfil() {
        return perfil;
    }

    public void setPerfil(RoleUsuario perfil) {
        this.perfil = perfil;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
}
