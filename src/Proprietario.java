public class Proprietario {
	private String nome;
	private long telefone;
	private long cpf;
	
	public Proprietario(String nome, long telefone, long cpf) {
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
	}
	
	public Proprietario() {
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public long getTelefone() {
		return telefone;
	}
	
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	
	public long getCpf() {
		return cpf;
	}
	
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
}
