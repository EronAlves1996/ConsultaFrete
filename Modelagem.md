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

- A aplicação deverá ter um endpoint `POST v1/consulta-endereco`

  - Este único endpoint deverá aceitar um body no seguinte schema:
    ```json
    {
      "cep": "string"
    }
    ```

- A aplicação responderá de acordo com o seguinte schema
  ```json
  {
    "cep": "string",
    "rua": "string",
    "complemento": "string",
    "bairro": "string",
    "cidade": "sctring",
    "estado": "string",
    "frete": "number"
  }
  ```
- Na requisição, o CEP poderá ser aceito com ou sem máscara
- Na resposta, obrigatoriamente o campo "cep" será escrito com máscara
- A aplicação não deverá retornar o status 500 sob nenhuma hipótese
- A aplicação deverá validar o CEP quanto aos caracteres (alfa-numéricos) e quanto à extensão da string de entrada
  - A string de entrada deverá ter ao menos 8 caracteres e no máximo 9 caracteres
- Qualquer inconsistência na requisição, quanto ao formato da string de entrada, deverá retornar um erro 400 (Bad Request)
- A consulta do CEP deverá ser feita à API viacep usando uma requisição `GET viacep.com.br/ws/{cep}/json/`
- A aplicação deverá tentar realizar a consulta à API por duas vezes
- O timeout que a aplicação deverá considerar para a consulta em cada uma das tentativas é de 2500ms
- Caso à API não responda nas duas tentativas, a aplicação deverá retornar um código 504, com uma mensagem no body, no seguinte schema:
  ```json
  {
    "mensagem": "string"
  }
  ```
- Caso à API informe que o CEP não existe, conforme documentação, a aplicação retornará status 200 com o seguinte body:
  ```json
  {
    "mensagem": "CEP não existe"
  }
  ```
- O cálculo para o frete obedeçerá a seguinte tabela
   <table>
      <tr>
         <th>Região</th>
         <th>Preço</th>
      </tr>
   <thead>
   </thead>
   <tbody>
      <tr><td>Sudeste</td><td>R$ 7,85</td></tr>
      <tr><td>Centro-Oeste</td><td>R$ 12,50</td></tr>
      <tr><td>Nordeste</td><td>R$ 15,98</td></tr>
      <tr><td>Sul</td><td>R$ 17,30</td></tr>
      <tr><td>Norte</td><td>R$ 20,83</td></tr>
   </tbody>
   </table>
- A região de um endereço será determinada pelo seu estado, conforme seguinte tabela
   <table>
     <tr>
        <th>Região</th>
        <th>Estado</th>
     </tr>
  <thead>
  </thead>
  <tbody>
     <tr><td>Sudeste</td><td>MG, SP, ES, RJ</td></tr>
     <tr><td>Centro-Oeste</td><td>DF, GO, MS, MT</td></tr>
     <tr><td>Nordeste</td><td>MA, PI, RN, CE, PB, BA, PB, AL, SE</td></tr>
     <tr><td>Sul</td><td>SC, PR, RS</td></tr>
     <tr><td>Norte</td><td>AM, AC, RO, RR, AP, PA, TO</td></tr>
  </tbody>
  </table>
