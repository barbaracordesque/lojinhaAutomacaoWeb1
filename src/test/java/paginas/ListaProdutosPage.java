package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaProdutosPage {
    private WebDriver navegador;

    public ListaProdutosPage (WebDriver navegador) {
        this.navegador = navegador;
    }

    public FormAddProdutoPage acessarFormNovoProduto (){
        navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        return new FormAddProdutoPage(navegador);
    }

    public String capturarMsgApresentada () {
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();
    }
}
