package cubo.kart.modelo;

public class Piloto {

	private String codigo;
	private String nome;
	private int posicao;
	private int quantidadeDeVoltas;
	private int tempoDeProva;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public int getQuantidadeDeVoltas() {
		return quantidadeDeVoltas;
	}

	public void setQuantidadeDeVoltas(int quantidadeDeVoltas) {
		this.quantidadeDeVoltas = quantidadeDeVoltas;
	}

	public int getTempoDeProva() {
		return tempoDeProva;
	}

	public void setTempoDeProva(int tempoDeProva) {
		this.tempoDeProva = tempoDeProva;
	}

}
