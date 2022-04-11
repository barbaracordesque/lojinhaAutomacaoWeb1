package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormEdicaoProdutoPage {
    private WebDriver navegador;

    public FormEdicaoProdutoPage( WebDriver navegador) {
        this.navegador = navegador;
    }

    public String capturarMsgApresentada () {
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();
    }
}