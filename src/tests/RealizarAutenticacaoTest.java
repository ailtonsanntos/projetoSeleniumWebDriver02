package tests;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class RealizarAutenticacaoTest {
	
	WebDriver driver; //Selenium Web Driver
	
	@Dado("^Acessar a página de autenticação de usuário$")
	public void acessar_a_página_de_autenticação_de_usuário() {
	    //Definindo o local onde está o driver utilizado para abrir o navegador
	    System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\Chrome\\89\\chromedriver.exe");
	    
	    //Abrindo o navegador
	    driver = new ChromeDriver();
	    
	    //Maximizando o navegador
	    driver.manage().window().maximize();
	    
	    //Abrindo a página
	    driver.get("https://lojaexemplod.lojablindada.com/customer/account/login/");
	}

	@Dado("^Informar o email de acesso \"([^\"]*)\"$")
	public void informar_o_email_de_acesso(String email) {
	    
		//localizar o campo email no formulário e preenche-lo
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
		
	}

	@Dado("^Informar a senha de acesso \"([^\"]*)\"$")
	public void informar_a_senha_de_acesso(String senha) {
	    
		//localizar o campo senha no formulário e preenche-lo
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(senha);
	}

	@Quando("^Solicitar o acesso ao sistema$")
	public void solicitar_o_acesso_ao_sistema() {
	    
	    //Clicar no botão entrar
		driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();
	}

	@Então("^Sistema autentica o usuário com sucesso$")
	public void sistema_autentica_o_usuário_com_sucesso() {
		
		//Critério: Verificar se o usuário está na página de acesso restrito
		
		//Obter a URL da página o qual o usuario foi redirecionado
		
		String urlpagina = driver.getCurrentUrl();
		
		//Comparando se a página para o qual o usuario foi redirecionado 
		//É igual a https://lojaexemplod.lojablindada.com/customer/account/
		
		assertEquals(urlpagina, "https://lojaexemplod.lojablindada.com/customer/account/");
		
		//Fechando o navegador
		driver.close();
	}

	@Então("^Sistema exibe a mensagem \"([^\"]*)\"$")
	public void sistema_exibe_a_mensagem(String mensagem) {
	    
	   //Critério: Verificar se o sistema exibe a mensagem 'Usuario ou Senha Invalido.'
		//Ler a mensagem exibida pelo sistema
		
		String resultadoObtido = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div/div/ul/li/ul/li/span")).getText();
		
	//Verificar se o resultado obtido é igual a mensagem definida na feature
		assertEquals(resultadoObtido, mensagem);		
		
		driver.close();
	}

	
	@Então("^Sistema informa que email e senha são campos obrigatórios$")
	public void sistema_informa_que_email_e_senha_são_campos_obrigatórios() {
	    
		//CRITÉRIO: Verificar se o sistema informa que os campos email e senha
			//são de preenchimento obrigatório
				
			//capturando as mensagens de erro de cada campo.
		String mensagemErroEmail = driver.findElement(By.xpath("//*[@id=\"advice-required-entry-email\"]")).getText();
		String mensagemErroSenha = driver.findElement(By.xpath("//*[@id=\"advice-required-entry-pass\"]")).getText();
		
		assertEquals(mensagemErroEmail, "Este é um campo obrigatório.");
		assertEquals(mensagemErroSenha, "Este é um campo obrigatório.");
		
		driver.close();
	}



}
