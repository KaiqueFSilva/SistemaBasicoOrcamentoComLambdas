package TesteLambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Operacao {
	
	public static void main(String[] args) {
		
		Produtos produto01 = new Produtos("Notebook" , 3850.50 , 0.10);
		Produtos produto02 = new Produtos("Celular" , 1720.20 , 0.5);
		Produtos produto03 = new Produtos("Televisão" , 2970.50 , 0.20);
		
		
		
		 //Operação Predicate onde será analisado se o produto com desconto está a cima do valor proposto (1.700). 
		Predicate<Produtos> isCaro = prod -> ((prod.preco * (1 - prod.desconto)) > 1700);
	
		/*teste			
		System.out.println(isCaro.test(produto01));		
		System.out.println(produto01.preco * (1 - produto01.desconto)); */
		
		
		List<Produtos> produtos = Arrays.asList(produto01, produto02, produto03);
		
		
		
			produtos.forEach(p -> System.out.printf("%s custa %.2f com desconto de %.2f ele valerá %.2f \nPassa do valor orçamentado (1700)? %s \n\n",
					                                p.nome, p.preco, p.desconto, (p.preco * (1 - p.desconto)), isCaro.test(p)));
			
			
			
			Operacao executar = new Operacao();
			
			executar.clientePlay();
			
			
	}
	
	
	
	
	
	void clientePlay () {
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("\n\nFaça sua pesquisa de produto!\nOrçamento maximo a gastar: ");
		String maximoGastoCF = leitor.next().replace(",", ".");
		double maximoGastoC = Double.parseDouble(maximoGastoCF);
		
		Predicate<Produtos> isCaro = prod -> ((prod.preco * (1 - prod.desconto)) > maximoGastoC);
		
		System.out.println("\nNome do Produto(Ex: Notebook): ");
		String nomeProdutoC = leitor.next();
		
		System.out.println("\nPreço(Ex: R$4200): ");
		System.out.print("R$");
		String precoProdutoFormatC = leitor.next().replace(",", ".");
		double precoProdutoC = Double.parseDouble(precoProdutoFormatC);
		
		System.out.println("\nDesconto (Ex:0,20): ");
		String descontoProdutoFormatC = leitor.next().replace(",", ".");
		double descontoProdutoC = Double.parseDouble(descontoProdutoFormatC);
		
		Produtos produtoC = new Produtos(nomeProdutoC, precoProdutoC, descontoProdutoC);  
		
		System.out.println("\n" + produtoC.nome + " custa R$" + produtoC.preco +
				" com desconto de " + produtoC.desconto + " ele valerá " + String.format("%.2f", produtoC.preco * (1 - produtoC.desconto))  
				+ "\nPassa do valor orçamentado(" + maximoGastoC + ")? "  + isCaro.test(produtoC));
		
		leitor.close();
		
	}

}
