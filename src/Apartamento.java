public class Apartamento extends Imovel {
	
	private String andar;
	
	public Apartamento(Long id, String endereco, int numero, String andar, boolean alugado, int valorAluguel, Proprietario proprietario) {
		super(id, endereco, numero, alugado, valorAluguel, proprietario);
		this.andar = andar;
	}
	
	public Apartamento(Long id, String endereco, int numero, String andar, boolean alugado, int valorAluguel) {
		super(id, endereco, numero, alugado, valorAluguel);
		this.andar = andar;
	}
	
	public Apartamento() {
	}
	
	@Override
	public boolean estaAlugado() {
		boolean alugado = super.estaAlugado();
		
		if (alugado) {
			System.out.println("O apartamento do número " + numero + " está alugado.");
		} else {
			System.out.println("O apartamento do número " + numero + " está disponível.");
		}
		
		return alugado;
	}
	
	public String getAndar() {
		return andar;
	}
	
	public void setAndar(String andar) {
		this.andar = andar;
	}
	
	@Override
	public String toString() {
		return "Apartamento: " + super.toString() + ", andar=" + andar;
	}
}
