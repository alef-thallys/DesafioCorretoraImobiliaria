import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Imovel> listaImoveis = new ArrayList<>();
		CorretoraService.adicionarValoresTesteListaImoveis(listaImoveis);
		
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
					CorretoraService.listarImoveis(listaImoveis, scanner);
					break;
				case "2":
					CorretoraService.cadastrarImovel(listaImoveis, scanner);
					break;
				case "3":
					CorretoraService.removerImovel(listaImoveis, scanner);
					break;
				case "4":
					CorretoraService.calcularValorAluguel(listaImoveis, scanner);
					break;
				case "5":
					CorretoraService.alugarImovel(listaImoveis, scanner);
					break;
				case "6":
					CorretoraService.disponibilizarImovel(listaImoveis, scanner);
					break;
				case "7":
					break;
				default:
					System.out.println("Alternativa invalida! Tente novamente");
					break;
			}
		}
	}
}