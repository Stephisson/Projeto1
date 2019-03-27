package br.com.senac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.dominio.Categoria;
import br.com.senac.servico.CategoriaService;

@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/listarCategorias")
	public ModelAndView listaCategorias() {
		ModelAndView mv = new ModelAndView("/paginaCategorias");
		mv.addObject("categorias", categoriaService.listaCategorias());
		return mv;
	}
	
	@GetMapping("/adicionar")
	public ModelAndView add(Categoria categoria) {
		ModelAndView mv = new ModelAndView("/paginaAdicionar");
		mv.addObject("categoria", categoria);
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView inserir(Categoria categoria)  {
		categoriaService.inserir(categoria);
		return listaCategorias();
	}
}