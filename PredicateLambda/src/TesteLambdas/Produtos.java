package TesteLambdas;

public class Produtos {

	String nome;
	double preco;
	double desconto;
	double valorComDesconto;
	
	public Produtos(String nome, double preco, double desconto) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
		
		this.setValorComDesconto(this.preco * (1 - this.desconto));
	}
	

	
	public double getValorComDesconto() {
		return valorComDesconto;
	}



	public void setValorComDesconto(double valorComDesconto) {
		this.valorComDesconto = valorComDesconto;
	}



	public String toString() {
		
		return this.nome + " custa " + this.preco + " com desconto de " + this.desconto 
				+ "% ele valerá " + String.format("%.2f", this.getValorComDesconto());
	}
	
}
