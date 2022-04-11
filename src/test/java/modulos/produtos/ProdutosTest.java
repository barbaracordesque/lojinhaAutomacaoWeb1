package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Teste Web do Módulo de Produtos ")
public class ProdutosTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeach () {
        // Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver100\\chromedriver.exe");
        this.navegador = new ChromeDriver();
        // Maximizar a tela
        this.navegador.manage().window().maximize();

        // Definir tempo de espera padrao de 5 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navegar para a página da Lojinha Web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");
    }

    @Test
    @DisplayName("Não é permitido registar um produto com o valor igual a zero")
    public void testProdutoValorZerado() {

        // Fazer Login
        String msgApresentada = new LoginPage(navegador)
                .infoUsuario("admin")
                .infoSenha("admin")
                .submeterFormLogin()
                .acessarFormNovoProduto()
                .infoNomeProduto("Macbook Pro")
                .infoValorProduto("000")
                .infoCoresProduto("Preto, Branco")
                .submeterFormComErro()
                .capturarMsgApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", msgApresentada);

    }

    @Test
    @DisplayName("Não é permitido registrar um produto com valor maior que sete mil")
    public void testProdutoValorMaisSeteMil () {

        // Fazer Login
        String msgApresentada = new LoginPage(navegador)
                .infoUsuario("admin")
                .infoSenha("admin")
                .submeterFormLogin()
                .acessarFormNovoProduto()
                .infoNomeProduto("Iphone")
                .infoValorProduto("700001")
                .infoCoresProduto("Preto, Branco")
                .submeterFormComErro()
                .capturarMsgApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", msgApresentada);

    }

    @Test
    @DisplayName("Adicionar um produto que esteja dentro da faixa")
    public void testAddAdicionarProdutoNaFaixa() {

        String msgApresentada = new LoginPage(navegador)
                .infoUsuario("admin")
                .infoSenha("admin")
                .submeterFormLogin()
                .acessarFormNovoProduto()
                .infoNomeProduto("Iphone 8")
                .infoValorProduto("380000")
                .infoCoresProduto("Preto, Branco")
                .submeterFormSucesso()
                .capturarMsgApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso",msgApresentada);

    }

    @AfterEach
    public void afterEach () {
        // Fechar navegador
        //navegador.quit();
    }
}

