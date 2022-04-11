package paginas;

import org.checkerframework.common.reflection.qual.ForName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormAddProdutoPage {
    private WebDriver navegador;

    public FormAddProdutoPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public FormAddProdutoPage infoNomeProduto (String produtoNome) {
        navegador.findElement(By.id("produtonome")).sendKeys(produtoNome);

        return this;
    }

    public FormAddProdutoPage infoValorProduto (String produtoValor) {
        navegador.findElement(By.name("produtovalor")).sendKeys(produtoValor);

        return this;
    }

    public FormAddProdutoPage infoCoresProduto (String produtoCores) {
        navegador.findElement(By.id("produtocores")).sendKeys(produtoCores);

        return this;
    }

    public ListaProdutosPage submeterFormComErro () {
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        return new ListaProdutosPage(navegador);
    }

    public FormEdicaoProdutoPage submeterFormSucesso() {
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        return new FormEdicaoProdutoPage(navegador);

    }
}