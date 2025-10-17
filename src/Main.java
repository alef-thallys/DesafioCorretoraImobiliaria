import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Imovel> listaImoveis = new ArrayList<>();
		adicionarValoresTesteListaImoveis(listaImoveis);
		
		Scanner scanner = new Scanner(System.in);
		String inputDoUsuario = "";
		
		while (!inputDoUsuario.equals("7")) {
			
			System.out.println("""
					
					Escolha uma alternativa:
					1. Listar imóveis
					2. Cadastrar imóvel
					3. Remover imóvel
					4. Calcular valor do aluguel
					5. Alugar imóvel
					6. Disponibilizar para alugar
					7. Finalizar
					""");
			
			System.out.print("> ");
			inputDoUsuario = scanner.nextLine();
			
			switch (inputDoUsuario) {
				case "1":
					listarImoveis(listaImoveis, scanner);
					break;
				case "2":
					cadastrarImovel(listaImoveis, scanner);
					break;
				case "3":
					removerImovel(listaImoveis, scanner);
					break;
				case "4":
					calcularValorAluguel(listaImoveis, scanner);
					break;
				case "5":
					alugarImovel(listaImoveis, scanner);
					break;
				case "6":
					disponibilizarImovel(listaImoveis, scanner);
					break;
				case "7":
					break;
				default:
					System.out.println("Alternativa invalida! Tente novamente");
					break;
			}
		}
	}
	
	private static void listarImoveis(List<Imovel> listaImoveis, Scanner scanner) {
		System.out.println("""
				Escolha uma alternativa:
				1. Listar todos imóveis
				2. Listar apenas imóveis alugados
				3. Listar apenas imóveis não alugados
				""");
		
		String inputDoUsuario = scanner.nextLine();
		
		for (Imovel imovel : listaImoveis) {
			switch (inputDoUsuario) {
				case "1":
					System.out.println(imovel);
					break;
				case "2":
					if (imovel.estaAlugadoStatus()) {
						System.out.println(imovel);
					}
					break;
				case "3":
					if (!imovel.estaAlugadoStatus()) {
						System.out.println(imovel);
					}
					break;
				default:
					System.out.println("Alternativa invalida! Tente novamente");
					break;
			}
		}
	}
	
	private static void cadastrarImovel(List<Imovel> listaImoveis, Scanner scanner) {
		Long idAtual = (long) listaImoveis.size() + 1;
		
		System.out.println("""
				Escolha uma alternativa:
				1. Cadastrar casa
				2. Cadastrar apartamento
				""");
		
		System.out.print("> ");
		String inputDoUsuario = scanner.nextLine();
		
		switch (inputDoUsuario) {
			case "1":
				cadastrarCasa(listaImoveis, idAtual, scanner);
				break;
			case "2":
				cadastrarApartamento(listaImoveis, idAtual, scanner);
				break;
			default:
				System.out.println("Alternativa invalida! Tente novamente");
				break;
		}
	}
	
	private static void removerImovel(List<Imovel> listaImoveis, Scanner scanner) {
		System.out.println("Digite o id do imóvel para remover");
		
		System.out.print("> ");
		Long id = Long.parseLong(scanner.nextLine());
		
		
		for (Imovel imovel : listaImoveis) {
			if (imovel.getId().equals(id)) {
				listaImoveis.remove(imovel);
				System.out.println("Imóvel deletado com sucesso!");
				return;
			}
		}
		System.out.println("Imóvel com id: " + id + " não encontrado!");
	}
	
	private static void cadastrarCasa(List<Imovel> listaImoveis, Long id, Scanner scanner) {
		Casa casa = new Casa();
		casa.setId(id);
		
		System.out.println("Digite o endereço da casa: ");
		System.out.print("> ");
		casa.setEndereco(scanner.nextLine());
		
		System.out.println("Digite o número da casa: ");
		System.out.print("> ");
		casa.setNumero(scanner.nextLine());
		
		System.out.println("Digite o valor do aluguel: ");
		System.out.print("> ");
		casa.setValorAluguel(Integer.parseInt(scanner.nextLine()));
		
		listaImoveis.add(casa);
		
		System.out.println("Casa cadastrada: " + casa);
	}
	
	private static void cadastrarApartamento(List<Imovel> listaImoveis, Long id, Scanner scanner) {
		Apartamento apartamento = new Apartamento();
		apartamento.setId(id);
		
		System.out.println("Digite o endereço do apartamento:");
		System.out.print("> ");
		apartamento.setEndereco(scanner.nextLine());
		
		System.out.println("Digite o número do apartamento:");
		System.out.print("> ");
		apartamento.setNumero(scanner.nextLine());
		
		System.out.println("Digite o andar do apartamento:");
		System.out.print("> ");
		apartamento.setAndar(scanner.nextLine());
		
		System.out.println("Digite o valor do aluguel: ");
		System.out.print("> ");
		apartamento.setValorAluguel(Integer.parseInt(scanner.nextLine()));
		
		listaImoveis.add(apartamento);
		
		System.out.println("Apartamento cadastrado: " + apartamento);
	}
	
	private static void calcularValorAluguel(List<Imovel> listaImoveis, Scanner scanner) {
		System.out.println("Digite o ID do imóvel que queira calcular");
		System.out.print("> ");
		
		Long id = Long.parseLong(scanner.nextLine());
		
		for (Imovel imovel : listaImoveis) {
			if (imovel.getId().equals(id)) {
				System.out.println("Digite por quantos meses você quer alugar o imóvel");
				System.out.print("> ");
				
				int qtDeMeses = Integer.parseInt(scanner.nextLine());
				Integer total = imovel.calcularAluguel(qtDeMeses);
				System.out.println("Você pagara o total de " + total + " por " + qtDeMeses + " meses de aluguel.");
				return;
			}
		}
		System.out.println("Imóvel com id: " + id + " não encontrado!");
	}
	
	private static void alugarImovel(List<Imovel> listaImoveis, Scanner scanner) {
		Proprietario proprietario = new Proprietario();
		
		System.out.println("Digite o ID do imóvel que queira alugar");
		System.out.print("> ");
		Long id = Long.parseLong(scanner.nextLine());
		
		for (Imovel imovel : listaImoveis) {
			if (imovel.getId().equals(id)) {
				if (imovel.estaAlugado()) {
					return;
				}
				
				System.out.println("Digite o nome proprietario");
				System.out.print("> ");
				proprietario.setNome(scanner.nextLine());
				
				System.out.println("Digite o telefone do proprietario");
				System.out.print("> ");
				proprietario.setTelefone(scanner.nextLine());
				
				System.out.println("Digite o CPF do proprietario");
				System.out.print("> ");
				proprietario.setCpf(scanner.nextLine());
				
				imovel.setProprietario(proprietario);
				imovel.setAlugado(true);
				
				System.out.println("Imóvel alugado com sucesso!");
				return;
			}
		}
		System.out.println("Imóvel com id: " + id + " não encontrado!");
	}
	
	private static void disponibilizarImovel(List<Imovel> listaImoveis, Scanner scanner) {
		System.out.println("Digite o ID do imóvel que queira disponibilizar");
		System.out.print("> ");
		Long id = Long.parseLong(scanner.nextLine());
		
		for (Imovel imovel : listaImoveis) {
			if (imovel.getId().equals(id)) {
				if (imovel.estaAlugadoStatus()) {
					imovel.setProprietario(null);
					imovel.setAlugado(false);
					System.out.println("Imóvel disponibilizado com sucesso!");
					return;
				}
				System.out.println("Imóvel já esta disponível!");
				return;
			}
		}
		System.out.println("Imóvel com id: " + id + " não encontrado!");
	}
	
	private static void adicionarValoresTesteListaImoveis(List<Imovel> listaImoveis) {
		Proprietario proprietario = new Proprietario("Alef", "12345678", "12345678");
		Imovel casa = new Casa(1L, "Rua do futuro", "123", true, 1500, proprietario);
		Imovel apartamento = new Apartamento(2L, "Avenida GFT", "456", "3", false, 3500);
		
		listaImoveis.add(casa);
		listaImoveis.add(apartamento);
	}
}