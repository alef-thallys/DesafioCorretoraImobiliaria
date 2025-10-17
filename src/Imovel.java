abstract class Imovel {
	private Long id;
	protected String endereco;
	protected int numero;
	protected boolean alugado;
	private int valorAluguel;
	private Proprietario proprietario;
	
	public Imovel(Long id, String endereco, int numero, boolean alugado, int valorAluguel, Proprietario proprietario) {
		this.id = id;
		this.endereco = endereco;
		this.numero = numero;
		this.alugado = alugado;
		this.valorAluguel = valorAluguel;
		this.proprietario = proprietario;
	}
	
	public Imovel(Long id, String endereco, int numero, boolean alugado, int valorAluguel) {
		this.id = id;
		this.endereco = endereco;
		this.numero = numero;
		this.alugado = alugado;
		this.valorAluguel = valorAluguel;
	}
	
	public Imovel() {
	}
	
	public boolean estaAlugado() {
		return alugado;
	}
	
	public long contatoProprietario() {
		return proprietario.getTelefone();
	}
	
	public Integer calcularAluguel(int qtDeMeses) {
		return valorAluguel * qtDeMeses;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public boolean isAlugado() {
		return alugado;
	}
	
	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}
	
	public int getValorAluguel() {
		return valorAluguel;
	}
	
	public void setValorAluguel(int valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	
	public Proprietario getProprietario() {
		return proprietario;
	}
	
	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	
	@Override
	public String toString() {
		if (isAlugado()) {
			return "id=" + id +
					", endereco=" + endereco +
					", numero=" + numero +
					", alugado=" + alugado +
					", valorAluguel=" + valorAluguel +
					", contatoProprietario=" + contatoProprietario();
		}
		return "id=" + id +
				", endereco=" + endereco +
				", numero=" + numero +
				", alugado=" + alugado +
				", valorAluguel=" + valorAluguel;
	}
}
