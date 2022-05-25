## Automação Web
Esse repositório contém a automação de um software web denominado Lojinha e foi desenvolvido durante o curso [Programa de Teste e Qualidade de Software](https://programa.juliodelima.com.br/) ministrado pelo professor Júlio de Lima.

## Tecnologias Utilizadas
 - [Java](https://www.oracle.com/java/technologies/downloads/)
 - [JUnit](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine)
 - [Selenium Java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
 - [Maven](https://maven.apache.org/)  

## Testes Automatizados
Testes para validar as partições de equivalência relacionadas ao valor do produto Lojinha, determinada pela regra de negócio que diz: O valor do produto deve estar entre R$0,01 e R$7.000,00.

Testes:
 - [x] Inclusão de um produto com o valor zerado;
 - [x]  Inclusão de um produto com o valor acima de R$ 7.000,00;
 - [x] Inclusão de um produto dentro da faixa determinada;

## Notas Gerais
- Foi utilizado o @BeforeEach para que em todas as execuções de teste o navegador seja aberto, maximize a tela e direcione para o site desejado.
- Adicionei um timeouts para para definir como padrão de espera 5 segundos caso exista alguma lentidão em abrir o site.
