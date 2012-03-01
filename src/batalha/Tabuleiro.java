import java.util.ArrayList;


public class Tabuleiro {
	
		
	public static final int LARG_MIN = 3;
	public static final int ALT_MIN = 3;
	private ArrayList<Barco> barcos =new ArrayList<Barco>();//Aqui vai ficar toda a lista dos barcos do jogo
	private int larg;
	private int alt;
	private int quantidadedeBarcos;//A quantidade de barcos sempre será 0 no inicio do jogo
	public static String tabuleiro[][]=new String[15][15];	
	
	
	public Tabuleiro(){
		this.larg = this.LARG_MIN;
		this.alt = this.ALT_MIN;
		this.quantidadedeBarcos = 0;
	}
	
	// X representa a etapa de criação do tabuleiro 1 elemento que deve ser desenhado no jogo
	
	public void criarJogo(int x, int y) throws TamanhoInvalidoException {
		if(x <= 0)
			throw new TamanhoInvalidoException("Largura invalida: " + x);			
		if(y <= 0)
			throw new TamanhoInvalidoException("Altura invalida: " + y);
		if(x < LARG_MIN || y< ALT_MIN)
			throw new TamanhoInvalidoException("Largura e Altura devem ser maiores que 2");			
			
		this.larg = x;
		this.alt = y;
	}
	
	public int getLarguraTabuleiro(){
		return this.larg;
	}
	
	public int getAlturaTabuleiro(){
		return this.alt;
	}
	
	public int getQuantidadedeBarcos(){
		return this.quantidadedeBarcos;
	}
	
	public void setQuantidadedeBarcos(int quantidadedeBarcos) {
		this.quantidadedeBarcos = quantidadedeBarcos;
	}

	public void addBarcoNoJogo(String string, int tamanho)  {
		if (tamanho > 15){
			throw new BarcoInvalido("Barco nao cabe no tabuleiro");
		}
		if (string.equals("")){
			throw new BarcoInvalido("Nome invalido");
		}
		if(string.equals("BARCOGRANDE") && tamanho == 15){
			throw new BarcoInvalido("Ja existe um barco com nome BARCOGRANDE no jogo");
		}
		if(string.equals("LANCHA")&&tamanho==0){
			throw new BarcoInvalido("Tamanho de embarcacao invalido");
		}
		if(tamanho < 0){
			throw new BarcoInvalido("Tamanho de embarcacao invalido: -1");
		}
		
		//if (string.equals("A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,X,Y,W,Z")|){
			//throw new BarcoInvalido("Nome deve conter apenas os seguintes caracteres (A..Z), (0..9) e (_-.)");
		//}
		Barco b1= new Barco(string ,tamanho);
		barcos.add(b1);
		
		
		
	}
public void addBarcoNoTabuleiro(String string, int tamanho) {
        
    }

	
	
	
}
