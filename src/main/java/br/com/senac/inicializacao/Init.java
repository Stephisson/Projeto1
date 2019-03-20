package br.com.senac.inicializacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.dominio.Aluno;
import br.com.senac.dominio.Categoria;
import br.com.senac.dominio.Cidade;
import br.com.senac.dominio.Curso;
import br.com.senac.dominio.Endereco;
import br.com.senac.dominio.Estado;
import br.com.senac.dominio.Usuario;
import br.com.senac.repositorio.AlunoRepositorio;
import br.com.senac.repositorio.CategoriaRepositorio;
import br.com.senac.repositorio.CidadeRepositorio;
import br.com.senac.repositorio.CursoRepositorio;
import br.com.senac.repositorio.EnderecoRepositorio;
import br.com.senac.repositorio.EstadoRepositorio;
import br.com.senac.repositorio.UsuarioRepositorio;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	AlunoRepositorio alunoRepositorio;
	
	@Autowired
	EstadoRepositorio estadoRepositorio;
	
	@Autowired
	CidadeRepositorio cidadeRepositorio;
	
	@Autowired
	EnderecoRepositorio enderecoRepositorio;
	
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	CategoriaRepositorio categoriaRepositorio;
	
	@Autowired
	CursoRepositorio cursoRepositorio;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Stephisson");
		aluno1.setEmail("stephisson@gmail.com");
		
		alunoRepositorio.save(aluno1);
		
		Aluno alunoGravado = alunoRepositorio.findByEmail("stephisson@gmail.com");
		
		Estado estado1 = new Estado();
		estado1.setNome("Rio de Janeiro");
		
		Estado estado2 = new Estado();
		estado2.setNome("São Paulo");
		
		Cidade cidade1 = new Cidade();
		cidade1.setNome("Angra dos Reis");
		cidade1.setEstado(estado1);
		
		Cidade cidade2 = new Cidade();
		cidade2.setNome("Cabo Frio");
		cidade2.setEstado(estado1);
		
		Cidade cidade3 = new Cidade();
		cidade3.setNome("Mogi das Cruzes");
		cidade3.setEstado(estado2);
		
		estadoRepositorio.saveAll(Arrays.asList(estado1,estado2));
		
		cidadeRepositorio.saveAll(Arrays.asList(cidade1,cidade2,cidade3));
		
		Usuario usuario = new Usuario();
		usuario.setNome("user");
		usuario.setSobrenome("lastName");
		usuario.setEmail("user@example.com");
		usuario.setSenha("123456");
		
		alunoRepositorio.save(aluno1);
		usuarioRepositorio.save(usuario);
		
		Endereco end1 = new Endereco();
		end1.setRua("Rua dos Andradas");
		end1.setNumero("20");
		end1.setBairro("Centro");
		end1.setComplemento("Bloco B");
		end1.setCep("22341-175");
		end1.setCidade(cidade1);
		end1.setAluno(aluno1);
		end1.setUsuario(usuario);
		
		aluno1.getTelefones().addAll(Arrays.asList("21212121","23232323"));
		
		enderecoRepositorio.saveAll(Arrays.asList(end1));
		
		// Criando Categoria
		
		Categoria categoria1 = new Categoria(null, "Java");
		Categoria categoria2 = new Categoria(null, "Mobile");
		
		categoriaRepositorio.saveAll(Arrays.asList(categoria1,categoria2));
		
		// Criando Curso
		
		Curso curso1 = new Curso(null, "Java", "Java para Iniciantes", 200.00);
		Curso curso2 = new Curso(null, "Java II", "Java Intermediário", 400.00);
		
		curso1.setCategorias(Arrays.asList(categoria1,categoria2));
		curso2.setCategorias(Arrays.asList(categoria1));
		
		cursoRepositorio.saveAll(Arrays.asList(curso1,curso2));
	}
}