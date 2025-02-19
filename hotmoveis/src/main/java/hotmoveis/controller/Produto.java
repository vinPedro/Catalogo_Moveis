package hotmoveis.controller;

public class Produto {
	
	private String nomeString;
	private Categoria categoria;
	private String corString;
	private String materialString;
	private String texturaString;
	private String marca;
	private String fabricanteString;
	private int garantiaMeses;
	private float peso;
	private float altura;
	private float largura;
	private float profundidade;
	private int quantEstoque;
	
	public Produto() {
		
	}
	
	public Produto(String nomeString, Categoria categoria, String corString, String materialString,
			String texturaString, String marca, String fabricanteString, int garantiaMeses, float peso, float altura,
			float largura, float profundidade, int quantEstoque) {
		super();
		this.nomeString = nomeString;
		this.categoria = categoria;
		this.corString = corString;
		this.materialString = materialString;
		this.texturaString = texturaString;
		this.marca = marca;
		this.fabricanteString = fabricanteString;
		this.garantiaMeses = garantiaMeses;
		this.peso = peso;
		this.altura = altura;
		this.largura = largura;
		this.profundidade = profundidade;
		this.quantEstoque = quantEstoque;
	}
	
	public String getNomeString() {
		return nomeString;
	}
	public void setNomeString(String nomeString) {
		this.nomeString = nomeString;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getCorString() {
		return corString;
	}
	public void setCorString(String corString) {
		this.corString = corString;
	}
	public String getMaterialString() {
		return materialString;
	}
	public void setMaterialString(String materialString) {
		this.materialString = materialString;
	}
	public String getTexturaString() {
		return texturaString;
	}
	public void setTexturaString(String texturaString) {
		this.texturaString = texturaString;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getFabricanteString() {
		return fabricanteString;
	}
	public void setFabricanteString(String fabricanteString) {
		this.fabricanteString = fabricanteString;
	}
	public int getGarantiaMeses() {
		return garantiaMeses;
	}
	public void setGarantiaMeses(int garantiaMeses) {
		this.garantiaMeses = garantiaMeses;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public float getLargura() {
		return largura;
	}
	public void setLargura(float largura) {
		this.largura = largura;
	}
	public float getProfundidade() {
		return profundidade;
	}
	public void setProfundidade(float profundidade) {
		this.profundidade = profundidade;
	}
	public int getQuantEstoque() {
		return quantEstoque;
	}
	public void setQuantEstoque(int quantEstoque) {
		this.quantEstoque = quantEstoque;
	}
	
}
