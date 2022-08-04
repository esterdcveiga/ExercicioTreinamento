package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.entidades.Cachorro;
import jdbc.interfaces.ICrud;
import jdbc.utilitarios.Conexao;

public class DaoCachorro implements ICrud<Cachorro> {
	private Cachorro cachorro = new Cachorro();
	private boolean retorno;
	private int id = 0;
	private List<Cachorro> cachorros = new ArrayList<>();

	@Override
	public boolean salvar(Cachorro cachorro) {
		String sql = "insert into cachorro (raca, nome, porte) values (?, ?, ?)";
		this.cachorro = cachorro;
		executar(sql, "salvar");
		return retorno;
	}

	@Override
	public boolean alterar(Cachorro cachorro) {
		this.cachorro = cachorro;
		String sql = "update cachorro set raca = ?,"
				+ "nome = ?,"
				+ "porte = ?"
				+ "where id = ?";
		executar(sql, "alterar");		
		return retorno;
	}

	@Override
	public List<Cachorro> consultar() {
		String sql = "select * from cachorro";
		executar(sql, "consultarTodos");
		return this.cachorros;
	}

	@Override
	public Cachorro consultar(int id) {
		String sql = "select * from cachorro where id =" + id;
		this.id = id;
		executar(sql, "consultarUm");
		return this.cachorro;
	}

	@Override
	public void excluir(int id) {
		String sql = "delete from cachorro where id = " +id;
		this.id = id;
		executar(sql, "excluir");	
	}
	
	private void executar(String sql, String metodo) {
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm =  con.prepareStatement(sql);	
			if(metodo == "salvar" || metodo =="alterar") {
				salvarAlterarLocal(stm, metodo);
			} else if(metodo == "consultarTodos" || metodo == "consultarUm") {
				consultasLocal(stm, metodo);
			}else if (metodo == "excluir") {
				stm.execute();
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Conexao.desconectar();
		}
	}
	
	private void salvarAlterarLocal(PreparedStatement stm, String metodo) {
		try {
			stm.setString(1, this.cachorro.getRaca());
			stm.setString(2, this.cachorro.getNome());
			stm.setString(3, this.cachorro.getPorte());
			if(metodo == "alterar")
				stm.setInt(4, cachorro.getId());
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			retorno = false;
		}		
		retorno = true;
	}
	
	private void consultasLocal(PreparedStatement stm, String metodo) {
		try {
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				cachorro = new Cachorro();
				cachorro.setId(rs.getInt("id"));
				cachorro.setRaca(rs.getString("raca"));
				cachorro.setNome(rs.getString("nome"));
				cachorro.setPorte(rs.getString("porte"));
				if(metodo == "consultarTodos")
					cachorros.add(cachorro);
			}
		}catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}
}
