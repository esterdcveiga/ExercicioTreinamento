package jdbc;

import java.util.List;

import jdbc.dao.DaoCachorro;
import jdbc.entidades.Cachorro;
import jdbc.utilitarios.Conexao;

public class Jdbc {

	public static void main(String[] args) {
		//testeConexao();
		
		DaoCachorro dcao = new DaoCachorro();
//		Cachorro catioro = new Cachorro("Dog Alemão", "Scooby Doo", "grande");
//		dcao.salvar(catioro);
		
//		List<Cachorro> cachorros = dcao.consultar();
//		for(Cachorro c: cachorros) {
//			System.out.println(c.getId());
//			System.out.println(c.getNome());
//		}
		
//		Cachorro c = dcao.consultar(2);
//		System.out.println(c.getId());
//		System.out.println(c.getNome());
		
		
//		Cachorro c = dcao.consultar(4);
//		c.setNome("Marie");
//		c.setRaca("Poodle");
//		c.setPorte("pequeno");
//		dcao.alterar(c);
		
		dcao.excluir(1);
		
	}

	static void testeConexao() {
		if (Conexao.conectar() != null) {
			System.out.println("Conectado com sucesso");
		} else {
			System.out.println("Ocorreu uma falha na conexão");
		}
	}
	
	static void testeSalvar(DaoCachorro dcao) {
		Cachorro catioro = new Cachorro("Dog Alemão", "Scooby Doo", "grande");
		dcao.salvar(catioro);
	}
	
	static void testeAlterar(DaoCachorro dcao) {
		Cachorro c = dcao.consultar(4);
		c.setNome("Marie");
		c.setRaca("Poodle");
		c.setPorte("pequeno");
		dcao.alterar(c);
	}
	
	static void testeConsultarUm(DaoCachorro dcao) {
		Cachorro c = dcao.consultar(2);
		System.out.println(c.getId());
		System.out.println(c.getNome());
	}
	
	static void testeConsultarTodos(DaoCachorro dcao) {
		List<Cachorro> cachorros = dcao.consultar();
		for(Cachorro c: cachorros) {
			System.out.println(c.getId());
			System.out.println(c.getNome());
		}
	}
	static void testeExcluir(DaoCachorro dcao) {
		
	}
}
