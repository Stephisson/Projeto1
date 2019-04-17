package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.dominio.Curso;
import br.com.senac.servico.CategoriaService;
import br.com.senac.servico.CursoService;
import br.com.senac.servico.exception.ObjectNotFoundException;

@Controller
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/listarCurso")
	public ModelAndView listaCursos() {
		ModelAndView mv = new ModelAndView("curso/paginaCursos");
		mv.addObject("cursos", cursoService.listaCursos());
		return mv;
	}
	
	@GetMapping("/adicionarCurso")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView("curso/paginaAdicionarCurso");
		mv.addObject("curso", new Curso());
		mv.addObject("categorias", categoriaService.listaCategorias());
		return mv;
	}
	
	@PostMapping("/salvarCurso")
	public ModelAndView inserir(Curso curso) {
		cursoService.inserir(curso);
		return listaCursos();
	}
	
	@GetMapping("/excluirCurso/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id ) {
						//("@PathVariable" ele passa a variável como "link")
		cursoService.excluir(id);
		return listaCursos();
	}
	
	@GetMapping("/alterarCurso/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id ) throws ObjectNotFoundException{
		ModelAndView mv = new ModelAndView("curso/paginaAlterar");
		mv.addObject("curso", cursoService.buscar(id));
		mv.addObject("categorias", categoriaService.listaCategorias());
		return mv;
	}
	
	@PostMapping("/alterarCurso")
	public ModelAndView alterar(Curso curso) throws ObjectNotFoundException{
		cursoService.alterar(curso);
		return listaCursos();
	}

}
