#language: pt
#encoding: iso-8859-1

Funcionalidade: Criar conta de acesso
	como um usu�rio do sistema
	eu quero cadastrar uma conta de acesso
	de modo que eu possa comprar livros
	
Esquema do Cen�rio: Cadastro de conta com sucesso
	Dado Acessar a p�gina de cadastro de conta
	E Informar o primeiro nome <nome>
	E Informar o ultimo nome <sobrenome>
	E Informar o email <email>
	E Informar a senha <senha>
	E Confirmar a senha <senha>
	Quando Solicitar a realiza��o do cadastro
	Ent�o Sistema informa que o cadastro foi realizado com sucesso
	
Exemplos:

	| nome      | sobrenome | email                  | senha      |
	| "Roberta" | "Silva"   | "betaSilva@gmail.com"  | "teste123" |
	| "Ana"     | "Maria"   | "mariaana@gmail.com"   | "teste123" |
	| "Bia"     | "Caveari" | "biacaveari@gmail.com" | "teste123" |