Feature: Formatos aceitos de CEP
	Os formatos aceito de CEP sempre é uma string numérica, com máscara (ou seja, com um traço na quinta posição) ou uma string numérica sem máscara, sendo assim, tendo no mínimo 8 caracteres e no máximo 9.
	
	Scenario: Envia CEP sem mascara
		When o usuario faz uma chamada com CEP "01001000"
		Then o usuario recebe um status 200
		And o usuario recebe informacoes validas (nao nulas)
	
	Scenario: Envia CEP com máscara
		When o usuario faz uma chamada com CEP "01001-000"
		Then o usuario recebe um status 200
		And o usuario recebe informacoes validas (nao nulas)
		
	Scenario: Envia CEP com menos dígitos numéricos
		When o usuario faz uma chamada com CEP invalido "0100100"
		Then o usuario recebe um status 400
		And com a mensagem "Cep não é válido"
		
	Scenario: Envia CEP com mais digitos numéricos
		When o usuario faz uma chamada com CEP invalido "010010010"
		Then o usuario recebe um status 400
		And com a mensagem "Cep não é válido"
		
	Scenario: Envia CEP com a máscara incorreta (traço na posição incorreta)
		When o usuario faz uma chamada com CEP invalido "01-001000"
		Then o usuario recebe um status 400
		And com a mensagem "Cep não é válido"
		
	Scenario: Envia CEP com algum caractere que não seja numérico
		When o usuario faz uma chamada com CEP invalido "01001a00"
		Then o usuario recebe um status 400
		And com a mensagem "Cep não é válido"