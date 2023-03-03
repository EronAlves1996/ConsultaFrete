# ConsultaFrete

Aplicação para consulta e cálculo de frete baseado no CEP.
Use essa aplicação para saber qual o endereço de uma localidade e qual será o valor do frete para essa localidade baseado no CEP.

## Tecnologias utilizadas

* Spring Boot
* Spring Web MVC
* Cucumber
* Springdoc OpenAI
* Java 11

## Testando

Para testes e execução da aplicação, é necessário usar o gradle. Caso não tenha instalado, utilize o wrapper:

```sh
$ ./gradlew test
```

A aplicação irá rodar todos os testes, unitários e de integração.

## Executando a aplicação

Para executar a aplicação, basta executar a task `bootRun` do gradle.

```sh
$ ./gradlew bootRun
```

## Como usar

A aplicação aceita requisições em um único endpoint, que é `POST /v1/consulta-endereco`.
O contrato da API que ela utiliza é simples:

```json
{
	"cep": "string"
}
```

A aplicação irá validar o CEP e chamar uma API Externa (Via CEP), te retornará o endereço daquele CEP, bem como o valor de frete.

Para maiores informações, é recomendável acessar o documento `Modelagem.md` e acessar a doc em swagger-ui, disponível na aplicação no endpoint `/swagger-ui.html`.

## Documentação

O documento Modelagem possui a documentação da modelagem dos requisitos da aplicação e o usecase no qual a mesma se baseia.

O Swagger UI irá fornecer informação sobre o endpoint, o que ele pode retornar e como pode retornar.

A informação sobre métodos e classes foi 100% documentada na aplicação usando a sintaxe javadoc. Para gerar, simplesmente execute a task javadoc do gradle

```sh
$ ./gradlew javadoc
```

Após isso, os páginas html do Javadoc estarão em `/build/docs/javadoc/index.html`




