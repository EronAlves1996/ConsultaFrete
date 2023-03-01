# Modelagem

Neste arquivo contém todos os artefatos criados para auxiliar na modelagem da aplicação.

## Objetivo

Realizar uma consulta de endereço via API, fornecendo o CEP via POST, e retornando detalhes do endereço juntamente com um preço de frete.

## Use Case

1. O usuário solicita uma consulta à aplicação, fornecendo CEP
2. A Aplicação valida se o CEP é válido
3. A Aplicação faz uma consulta de endereço à API ViaCEP fornecendo o CEP
4. A API retorna com um endereço
5. Com o endereço, a aplicação calcula o frete
6. A aplicação retorna para o usuário a informação de endereço, cep e frete
