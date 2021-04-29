package tests;

import static org.junit.Assert.assertEquals;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class CriarContaDeAcessoTest {
	
	
	WebDriver driver; //Selenium WebDriver 
	

		@Dado("^Acessar a página de cadastro de conta$")
		public void acessar_a_página_de_cadastro_de_conta() {
		   
			System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\Chrome\\89\\chromedriver.exe");
		    
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.get("https://lojaexemplod.lojablindada.com/customer/account/create/");
		}

		@Dado("^Informar o primeiro nome \"([^\"]*)\"$")
		public void informar_o_primeiro_nome(String nome) {
		    
			driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys(nome);
		}

		@Dado("^Informar o ultimo nome \"([^\"]*)\"$")
		public void informar_o_ultimo_nome(String sobrenome) {

			driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys(sobrenome);
		}

		@Dado("^Informar o email \"([^\"]*)\"$")
		public void informar_o_email(String email) {
		    
			driver.findElement(By.xpath("//*[@id=\"email_address\"]")).sendKeys(email);
		}

		@Dado("^Informar a senha \"([^\"]*)\"$")
		public void informar_a_senha(String senha) {
		    
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(senha);
		}

		@Dado("^Confirmar a senha \"([^\"]*)\"$")
		public void confirmar_a_senha(String senha) {
			
			driver.findElement(By.xpath("//*[@id=\"confirmation\"]")).sendKeys(senha);
		}

		@Quando("^Solicitar a realização do cadastro$")
		public void solicitar_a_realização_do_cadastro() {
			
					    
			driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[3]/button")).click();
			
		}

		@Então("^Sistema informa que o cadastro foi realizado com sucesso$")
		public void sistema_informa_que_o_cadastro_foi_realizado_com_sucesso() {
		    
			String urlpagina = driver.getCurrentUrl();
			
			assertEquals(urlpagina, "https://lojaexemplod.lojablindada.com/customer/account/index/");
			
			driver.close();
		}


}
