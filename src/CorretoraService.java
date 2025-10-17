import java.util.List;
import java.util.Scanner;

public class CorretoraService {
	
	public static void listarImoveis(List<Imovel> listaImoveis, Scanner scanner) {
		System.out.println("""
				Escolha uma alternativa:
				1. Listar todos imóveis
				2. Listar apenas imóveis alugados
				3. Listar apenas imóveis não alugados
				""");
		
		System.out.print("> ");
		String inputDoUsuario = scanner.nextLine();
		
		for (Imovel imovel : listaImoveis) {
			switch (inputDoUsuario) {
				case "1":
					System.out.println(imovel);
					break;
				case "2":
					if (imovel.isAlugado()) {
						System.out.println(imovel);
					}
					break;
				case "3":
					if (!imovel.isAlugado()) {
						System.out.println(imovel);
					}
					break;
				default:
					System.out.println("Alternativa invalida! Tente novamente");
					break;
			}
		}
	}
	
	public static void cadastrarImovel(List<Imovel> listaImoveis, Scanner scanner) {
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
	
	public static void removerImovel(List<Imovel> listaImoveis, Scanner scanner) {
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
	
	public static void cadastrarCasa(List<Imovel> listaImoveis, Long id, Scanner scanner) {
		Casa casa = new Casa();
		casa.setId(id);
		
		System.out.println("Digite o endereço da casa: ");
		System.out.print("> ");
		casa.setEndereco(scanner.nextLine());
		
		System.out.println("Digite o número da casa: ");
		System.out.print("> ");
		
		int numeroDaCasa = 0;
		
		try {
			numeroDaCasa = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException ex) {
			System.out.println("Número da casa invalido!");
			return;
		}
		
		casa.setNumero(numeroDaCasa);
		
		System.out.println("Digite o valor do aluguel: ");
		System.out.print("> ");
		
		int valorAluguel = 0;
		
		try {
			valorAluguel = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException ex) {
			System.out.println("Valor invalido!");
			return;
		}
		
		if (valorAluguel <= 0) {
			System.out.println("Valor do aluguel deve ser maior que 0");
			return;
		}
		
		casa.setValorAluguel(valorAluguel);
		listaImoveis.add(casa);
		
		System.out.println("Casa cadastrada: " + casa);
	}
	
	public static void cadastrarApartamento(List<Imovel> listaImoveis, Long id, Scanner scanner) {
		Apartamento apartamento = new Apartamento();
		apartamento.setId(id);
		
		System.out.println("Digite o endereço do apartamento:");
		System.out.print("> ");
		apartamento.setEndereco(scanner.nextLine());
		
		System.out.println("Digite o número do apartamento:");
		System.out.print("> ");
		
		int numeroDoApartamento = 0;
		
		try {
			numeroDoApartamento = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException ex) {
			System.out.println("Número do apartamento invalido!");
			return;
		}
		
		apartamento.setNumero(numeroDoApartamento);
		
		System.out.println("Digite o andar do apartamento:");
		System.out.print("> ");
		apartamento.setAndar(scanner.nextLine());
		
		System.out.println("Digite o valor do aluguel: ");
		System.out.print("> ");
		apartamento.setValorAluguel(Integer.parseInt(scanner.nextLine()));
		
		listaImoveis.add(apartamento);
		
		System.out.println("Apartamento cadastrado: " + apartamento);
	}
	
	public static void calcularValorAluguel(List<Imovel> listaImoveis, Scanner scanner) {
		System.out.println("Digite o ID do imóvel que queira calcular");
		System.out.print("> ");
		
		Long id = Long.parseLong(scanner.nextLine());
		
		for (Imovel imovel : listaImoveis) {
			if (imovel.getId().equals(id)) {
				System.out.println("Digite por quantos meses você quer alugar o imóvel");
				System.out.print("> ");
				
				int qtDeMeses = Integer.parseInt(scanner.nextLine());
				
				if (qtDeMeses < 1) {
					System.out.println("Quantidade de meses tem que ser maior ou igual a 1!");
					return;
				}
				
				Integer total = imovel.calcularAluguel(qtDeMeses);
				System.out.println("Você pagara o total de " + total + " por " + qtDeMeses + " meses de aluguel.");
				return;
			}
		}
		System.out.println("Imóvel com id: " + id + " não encontrado!");
	}
	
	public static void alugarImovel(List<Imovel> listaImoveis, Scanner scanner) {
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
				
				long telefone = 0;
				
				try {
					telefone = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException ex) {
					System.out.println("Telefone invalido!");
					return;
				}
				
				proprietario.setTelefone(telefone);
				
				System.out.println("Digite o CPF do proprietario");
				System.out.print("> ");
				
				long cpf = 0;
				
				try {
					cpf = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException ex) {
					System.out.println("CPF invalido!");
					return;
				}
				
				proprietario.setCpf(cpf);
				
				imovel.setProprietario(proprietario);
				imovel.setAlugado(true);
				
				System.out.println("Imóvel alugado com sucesso!");
				return;
			}
		}
		System.out.println("Imóvel com id: " + id + " não encontrado!");
	}
	
	public static void disponibilizarImovel(List<Imovel> listaImoveis, Scanner scanner) {
		System.out.println("Digite o ID do imóvel que queira disponibilizar");
		System.out.print("> ");
		Long id = Long.parseLong(scanner.nextLine());
		
		for (Imovel imovel : listaImoveis) {
			if (imovel.getId().equals(id)) {
				if (imovel.isAlugado()) {
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
	
	public static void adicionarValoresTesteListaImoveis(List<Imovel> listaImoveis) {
		Proprietario proprietario = new Proprietario("Alef", 12345678, 2345678);
		Imovel casa = new Casa(1L, "Rua do futuro", 123, true, 1500, proprietario);
		Imovel apartamento = new Apartamento(2L, "Avenida GFT", 456, "3", false, 3500);
		
		listaImoveis.add(casa);
		listaImoveis.add(apartamento);
	}
}
