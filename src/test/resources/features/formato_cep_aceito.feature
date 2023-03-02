Feature: Formatos aceitos de CEP
	Os formatos aceito de CEP sempre é uma string numérica, com máscara (ou seja, com um traço na quinta posição) ou uma string numérica sem máscara, sendo assim, tendo no mínimo 8 caracteres e no máximo 9.
	
	Scenario: Envia CEP sem mascara
		When o usuario faz uma chamada com CEP "01001000"
		Then o usuario recebe um status 200
		And o usuario recebe informacoes validas (nao nulas)