package jdbc;

import java.util.List;

import jdbc.dao.DaoCachorro;
import jdbc.entidades.Cachorro;
import jdbc.utilitarios.Conexao;

public class Jdbc {

	public static void main(String[] args) {
		//testeConexao();
		
		DaoCachorro dcao = new DaoCachorro();
		
		Cachorro cao = new Cachorro("Lhasa Apso", "Lana", "pequeno");
		
		//testeSalvar(dcao, cao);
		
		//testeAlterar(dcao, 3, "Loki", "Husky Siberiano", "grande");
		
		//testeConsultarTodos(dcao);
		
		//testeConsultarUm(dcao, 4);
		
		dcao.excluir(4);
		
		
		
	}

	static void testeConexao() {
		if (Conexao.conectar() != null) {
			System.out.println("Conectado com sucesso");
		} else {
			System.out.println("Ocorreu uma falha na conexão");
		}
	}
	
	static void testeSalvar(DaoCachorro dcao, Cachorro cachorro) {
		if(dcao.salvar(cachorro)) {
			System.out.println("Salvo com sucesso!");
		}
	}
	
	static void testeAlterar(DaoCachorro dcao, int id, String nome, String raca, String porte) {
		Cachorro c = dcao.consultar(id);
		c.setNome(nome);
		c.setRaca(raca);
		c.setPorte(porte);
		if(dcao.alterar(c)) {
			System.out.println("Alterado com sucesso!");
		}
	}
	
	static void testeConsultarUm(DaoCachorro dcao, int id) {
		Cachorro c = dcao.consultar(id);
		System.out.println(c);
	}
	
	static void testeConsultarTodos(DaoCachorro dcao) {
		List<Cachorro> cachorros = dcao.consultar();
		for(Cachorro c: cachorros) {
			System.out.println(c);
		}
	}
	static void testeExcluir(DaoCachorro dcao, int id) {
		dcao.excluir(id);		
	}
}
