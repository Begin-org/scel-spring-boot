package com.fatec.scel.servico;

import com.fatec.scel.model.Emprestimo;
import com.fatec.scel.model.Livro;

public interface EmprestimoServico {
	public Iterable<Emprestimo> findAll();

	public String registraEmprestimo(Emprestimo emprestimo);

	public String registraDevolucao(String isbn); // supoe que isbn refere-se ao tombo

	public void deleteById(Long id);
	
	public void updateDevolucao(Long id, String dataDevolucao);
	
	public Boolean verificaISBNEmprestado(Livro livro);
	
}