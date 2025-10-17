public class Casa extends Imovel {
	
	public Casa(Long id, String endereco, int numero, boolean alugado, int valorAluguel, Proprietario proprietario) {
		super(id, endereco, numero, alugado, valorAluguel, proprietario);
	}
	
	public Casa() {
	}
	
	@Override
	public boolean estaAlugado() {
		boolean alugado = super.estaAlugado();
		
		if (alugado) {
			System.out.println("A casa está alugada.");
		} else {
			System.out.println("A casa está disponível.");
		}
		
		return alugado;
	}
	
	@Override
	public String toString() {
		return "Casa: " + super.toString();
	}
}
