Feature: Tratamento de Erros da API Via CEP
	Alguns erros podem surgir na API Via CEP, e eles devem ser tratados pelo servidor. A aplicação irá tentar realizar a requisição duas vezes, e caso não consiga, retorna 504. Outra situação é quando o CEP não existe, então a aplicação irá informar que o CEP não existe. Os testes unitários preveem esse use case.
	
	Scenario: O Usuario consulta um CEP que não existe
		When o usuario faz uma chamada com CEP invalido "99999-999"
		Then o usuario recebe um status 200
		And com a mensagem "CEP não existe"
		
