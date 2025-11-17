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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    public Usuario(Long id) {
        this.id = id;
    }
}
