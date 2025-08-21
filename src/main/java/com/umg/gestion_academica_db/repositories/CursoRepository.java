package com.umg.gestion_academica_db.repositories;

import com.umg.gestion_academica_db.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    List<Curso> findBySemestre(Short semestre);
}
