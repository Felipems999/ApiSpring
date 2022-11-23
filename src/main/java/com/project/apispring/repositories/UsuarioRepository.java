package com.project.apispring.repositories;

import com.project.apispring.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
