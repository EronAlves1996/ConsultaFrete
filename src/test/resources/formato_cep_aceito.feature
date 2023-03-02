Feature: Formatos aceitos de CEP
	Os formatos aceito de CEP sempre é uma string numérica, com máscara (ou seja, com um traço na 
	quinta posição) ou uma string numérica sem máscara, sendo assim, tendo no mínimo 8 caracteres 
	e no máximo 9.
	
	Scenario: Envia CEP sem máscara
		Given
		When
		Then
		
	Scenario: Envia CEP com máscara
		Given
		When
		Then
		
	Scenario: Envia CEP com menos dígitos numéricos
		Given
		When
		Then
		
	Scenario: Envia CEP com mais digitos numéricos
		Given
		When
		Then
		
	Scenario: Envia CEP com a máscara incorreta (traço na posição incorreta)
		Given
		When
		Then
		
	Scenario: Envia CEP com algum caractere que não seja numérico
		Given
		When
		Then

