
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class Teste {

	Tabuleiro t;
	
	@Before
	public void setUp() {
		t = new Tabuleiro();
	}

	@Test
	public void testeCriarJogo() {
		try {
			t.criarJogo(2, 3);
			fail("Deveria ter lançado uma execeção");
		} catch (TamanhoInvalidoException e) {
			assertEquals("Largura e Altura devem ser maiores que 2",
					e.getMessage());
		}
		try {
			t.criarJogo(3, 2);
			fail("Deveria ter lançado uma execeção");
		} catch (TamanhoInvalidoException e) {
			assertEquals("Largura e Altura devem ser maiores que 2",
					e.getMessage());
		}
		try {
			t.criarJogo(-1, 15);
			fail("Deveria ter lançado uma execeção");
		} catch (TamanhoInvalidoException e) {
			assertEquals("Largura invalida: -1", e.getMessage());
		}
		try {
			t.criarJogo(0, 15);
			fail("Deveria ter lançado uma execeção");
		} catch (TamanhoInvalidoException e) {
			assertEquals("Largura invalida: 0", e.getMessage());
		}
		try {
			t.criarJogo(15, -1);
			fail("Deveria ter lançado uma execeção");
		} catch (TamanhoInvalidoException e) {
			assertEquals("Altura invalida: -1", e.getMessage());
		}
		try {
			t.criarJogo(15, 0);
			fail("Deveria ter lançado uma execeção");
		} catch (TamanhoInvalidoException e) {
			assertEquals("Altura invalida: 0", e.getMessage());
		}
		try {
			t.criarJogo(-1, -1);
			fail("Deveria ter lançado uma execeção");
		} catch (TamanhoInvalidoException e) {
			assertEquals("Largura invalida: -1", e.getMessage());
		}
	}

	@Test
	public void testeGetLarguraAlturaTabuleiro() {
		t.criarJogo(20, 10);
		assertEquals(20, t.getLarguraTabuleiro());
		assertEquals(10, t.getAlturaTabuleiro());
	}

	@Test
	public void testeGetQuantidadedeBarcos0() {
		assertEquals(0, t.getQuantidadedeBarcos());
	}
	
	@Test
	public void testeGetQuantidadedeBarcos1(){
			t.setQuantidadedeBarcos(1);
			assertEquals(t.getQuantidadedeBarcos(),1);
			t.setQuantidadedeBarcos(0);
	}
	@Test 
	public void testeGetQuantidadeBarcos3(){
		t.setQuantidadedeBarcos(3);
		assertEquals(t.getQuantidadedeBarcos(),3);
		t.setQuantidadedeBarcos(0);	
	}

	@Test 
	public void testeAddBarcoMuitoGrande() throws BarcoInvalido {
		try {
			t.addBarcoNoJogo("BARCO_GRANDE", 21);
			fail("Barco nao cabe no tabuleiro");
		} catch (BarcoInvalido e) {
			assertEquals("Barco nao cabe no tabuleiro", e.getMessage());
		}
	}
	@Test 
	public void testeAddBarcoGrande (){
			t.addBarcoNoJogo("BARCO_GRANDE", 15);	
	}
	@Test 
	public void testeAddLancha(){
		t.addBarcoNoJogo("LANCHA", 3);
	}
	@Test
	public void testeAddBarcoNomeVazio(){
		try{
		t.addBarcoNoJogo("", 3);
		fail ("Nome invalido");
		}catch(BarcoInvalido e){
			assertEquals("Nome invalido", e.getMessage());
		}
	}
	@Test 
	public void testeAddBarcoExistente(){
	try{
		t.addBarcoNoJogo("BARCOGRANDE", 15);
		t.addBarcoNoJogo("BARCOGRANDE", 15);
	fail("Ja existe um barco com nome BARCOGRANDE no jogo");
	}catch(BarcoInvalido e){
		assertEquals("Ja existe um barco com nome BARCOGRANDE no jogo",e.getMessage());
	}
}	
	@Test
	public void testeTamanhoInvalido(){
		try{
			t.addBarcoNoJogo("LANCHA", 0);
			fail("Tamanho de embarcacao invalido");
		}catch(BarcoInvalido e){
			assertEquals("Tamanho de embarcacao invalido",e.getMessage());
		}
	}
	@Test 
	public void testeTamanhoInvalido1(){
		try{
			t.addBarcoNoJogo("LANCHA", -1);
			fail("Tamanho de embarcacao invalido: -1");
		}catch (BarcoInvalido e){
			assertEquals("Tamanho de embarcacao invalido: -1",e.getMessage());
		}
		
	}
	
//	@Test
	//public void testeAddBarcoN(){
		//try{
			//t.addBarcoNoJogo ("%#",3);
		//	fail("Nome deve conter apenas os seguintes caracteres (A..Z), (0..9) e (_-.)");
	//	}catch(BarcoInvalido e){
			//assertEquals("Nome deve conter apenas os seguintes caracteres (A..Z), (0..9) e (_-.)",e.getMessage());
		//}	
		//}
	
	
}

