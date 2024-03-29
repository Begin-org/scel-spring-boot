package com.fatec.scel.controller;

import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.fatec.scel.model.Emprestimo;
import com.fatec.scel.model.EmprestimoRepository;
import com.fatec.scel.model.Livro;
import com.fatec.scel.servico.EmprestimoServico;

@RestController
@RequestMapping(path = "/emprestimos")
public class EmprestimoController {
	@Autowired
	private EmprestimoServico servico;
	Logger logger = LogManager.getLogger(EmprestimoController.class);

	@GetMapping("/cadastrar")
	public ModelAndView registrarEmprestimo(Emprestimo emprestimo) {
		ModelAndView mv = new ModelAndView("registrarEmprestimo");
		mv.addObject("emprestimo", emprestimo);
		return mv;
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Emprestimo emprestimo, BindingResult result) {
		logger.info("emprestimo ==> " + emprestimo.getRa());
		ModelAndView modelAndView = new ModelAndView("consultarEmprestimo");
		if (result.hasErrors()) {
			modelAndView.setViewName("registrarEmprestimo");
		}
		try {
			String message = servico.registraEmprestimo(emprestimo);
			modelAndView.addObject("emprestimos", servico.findAll());
			if (message.equals("fail")) {
				modelAndView.setViewName("registrarEmprestimo");
				modelAndView.addObject("fail", "Dados invalidos."); // fail nao eh nulo a msg aparece na tela
			}else if(message.equals("exist")) {
				modelAndView.setViewName("registrarEmprestimo");
				modelAndView.addObject("exist", "Este livro ja foi emprestado");
			}
		} catch (Exception e) {
			logger.error("========> Exceçao nao prevista - save() cadastra emprestimo");
			modelAndView.setViewName("registrarEmprestimo");
			modelAndView.addObject("fail", "Exceçao nao prevista - consulte o administrador =>" + e.getMessage());
		}
		return modelAndView;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		servico.deleteById(id);
		ModelAndView modelAndView = new ModelAndView("consultarEmprestimo");
		modelAndView.addObject("emprestimos", servico.findAll());
		return modelAndView;
	}
	
	@GetMapping("/consultar")
	public ModelAndView retornaFormDeConsultaTodosEmprestimos() {
		ModelAndView modelAndView = new ModelAndView("consultarEmprestimo");
		modelAndView.addObject("emprestimos", servico.findAll());
		return modelAndView;
	}
	
	@GetMapping("/update/{id}")
	public ModelAndView atualizaEmprestimo(@PathVariable("id") Long id) {
		
		Emprestimo emp = new Emprestimo();
		
		emp.setDataDevolucao();
		
		servico.updateDevolucao(id, emp.getDataDevolucao());
		
		
		ModelAndView modelAndView = new ModelAndView("consultarEmprestimo");
		modelAndView.addObject("emprestimos", servico.findAll());
		return modelAndView;
	}
}