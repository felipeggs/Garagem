import com.felipegabriel.model.BaseEntity;

public interface AbstractDao <T extends BaseEntity>{
	
	public T inserir(T obj) throws Exception;
	public T alterar(T obj) throws Exception;
	public boolean excluir(T obj) throws Exception;
	public T buscarPorId(T obj) throws Exception;
	

}
