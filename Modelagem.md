# Modelagem

Neste arquivo contém todos os artefatos criados para auxiliar na modelagem da aplicação.

## Objetivo

Realizar uma consulta de endereço via API, fornecendo o CEP via POST, e retornando detalhes do endereço juntamente com um preço de frete.

## Use Case

1. O usuário realiza uma requisição à API (POST para /v1/consulta-endereco)
2. A aplicação recebe a requisição em um Controller
3. O Controller repassa a informação a um Service
4. O Service realiza uma requisição GET para a API do viaCEP com a informação do CEP
5. A API do VIACEP retorna com as informações
6. Utilizando a informação do 'estado' retornado da API, é realizada uma consulta em um dicionário interno para determinar a região (e consequentemente valor do frete)
7. Após determinado o valor do frete, o Service prepara a informação e retorna para o Controller
8. O Controller retorna a informação ao requisitante
