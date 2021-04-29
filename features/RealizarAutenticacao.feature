#language: pt
#encoding: iso-8859-1

Funcionalidade: Realizar Autenticação
	Como um usuário da loja de livros
	eu quero acessar minha conta
	de modo que eu possa comprar livros
	
Cenário: Autenticar usuário com sucesso
	Dado Acessar a página de autenticação de usuário
	E Informar o email de acesso "sergio.coti@gmail.com"
	E Informar a senha de acesso "adminadmin"
	Quando Solicitar o acesso ao sistema
	Então Sistema autentica o usuário com sucesso

Cenário: Autenticar usuário com sucesso
	Dado Acessar a página de autenticação de usuário
	E Informar o email de acesso "teste@gmail.com"
	E Informar a senha de acesso "teste123"
	Quando Solicitar o acesso ao sistema
	Então Sistema exibe a mensagem "Usuário ou Senha Inválido."
	
Cenário: Validação de campos obrigatórios
	Dado Acessar a página de autenticação de usuário
	Quando Solicitar o acesso ao sistema
	Então Sistema informa que email e senha são campos obrigatórios



