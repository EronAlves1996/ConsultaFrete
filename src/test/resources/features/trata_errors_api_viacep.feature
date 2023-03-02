Feature: Tratamento de Erros da API Via CEP
	Alguns erros podem surgir na API Via CEP, e eles devem ser tratados pelo servidor. A aplicação irá tentar realizar a requisição duas vezes, e caso não consiga, retorna 504. Outra situação é quando o CEP não existe, então a aplicação irá informar que o CEP não existe
	
	Scenario: API Via CEP está indisponível
		When o usuario faz uma chamada com CEP "01001-000" e API está indisponível
		Then o usuario espera por volta de 6 segundos
		And o usuario recebe um status 504
		And com a mensagem "API ViaCEP indisponível, tente novamente mais tarde!"
	
	Scenario: O Usuario consulta um CEP que não existe
		When o usuario faz uma chamada com CEP inválido "99999-999"
		Then o usuario recebe um status 200
		And com a mensagem "CEP não existe"
		
