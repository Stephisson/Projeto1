package br.com.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.dominio.Curso;

@Repository
public interface CursoRepositorio extends JpaRepository<Curso, Integer> {

}