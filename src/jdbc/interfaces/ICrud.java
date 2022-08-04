package jdbc.interfaces;

import java.util.List;

public interface ICrud <T> {
	boolean salvar (T objeto);
	boolean alterar (T objeto);
	List<T> consultar();
	T consultar(int id);
	void excluir(int id);
}
