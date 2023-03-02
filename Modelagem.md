# Modelagem

Neste arquivo contém todos os artefatos criados para auxiliar na modelagem da aplicação.

## Objetivo

Realizar uma consulta de endereço via API, fornecendo o CEP via POST, e retornando detalhes do endereço juntamente com um preço de frete.

## Use Case

1. O usuário solicita uma consulta à aplicação, fornecendo CEP
2. A Aplicação valida se o CEP é válido
   2.1 Se o CEP tiver menos dígitos, a aplicação retorna uma mensagem de erro
   2.2 Se o CEP tiver caracteres não numéricos, a aplicação retorna uma mensagem de erro
3. A Aplicação faz uma consulta de endereço à API ViaCEP fornecendo o CEP
4. A API retorna com um endereço
   4.1 Se a API demorar tempo demais, a requisição é parada. Retorna ao passo 3
   4.2 Se for a segunda tentativa de requisição sem resposta, a aplicação retorna uma mensagem de erro
   4.3 Se o CEP não existir, a aplicação retorna uma mensagem de erro
5. Com o endereço, a aplicação calcula o frete de acordo com tabela
6. A aplicação retorna para o usuário a informação de endereço, cep formatado e frete

## Requisitos
