package com.fatec.scel.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	List<Usuario> findByNome(String nome);
	@Query("SELECT u FROM Usuario u WHERE u.ra = :ra")
	public Usuario findByRa(@Param("ra") String ra);

}