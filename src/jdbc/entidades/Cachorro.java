package jdbc.entidades;

public class Cachorro {
	private int id;
	private String raca;
	private String nome;
	private String porte;
	
	
	
	public Cachorro() { }

	public Cachorro(String raca, String nome, String porte) {
		this.raca = raca;
		this.nome = nome;
		this.porte = porte;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRaca() {
		return raca;
	}
	
	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getPorte() {
		return porte;
	}
	
	public void setPorte(String porte) {
		this.porte = porte;
	}
	
	@Override
	public String toString() {
		return "Cachorro: id= "+id+", raça= "+raca+", nome= "+nome+", porte= "+porte;
	}
}
