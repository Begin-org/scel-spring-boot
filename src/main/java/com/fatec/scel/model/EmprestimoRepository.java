package com.fatec.scel.model;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmprestimoRepository extends CrudRepository<Emprestimo, Long> {
	
	@Modifying
	@Transactional
	@Query("UPDATE Emprestimo e SET e.dataDevolucao = :dataDevolucao WHERE e.id = :id")
	public int updateDevolucao(@Param("id") Long id, @Param("dataDevolucao") String dataDevolucao);
	
	@Query("SELECT e FROM Emprestimo e WHERE e.isbn = :isbn AND e.dataDevolucao IS NULL")
	public Livro findByIsbn(@Param("isbn") String isbn);
}