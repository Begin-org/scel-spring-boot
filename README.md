## Projeto - Sistema de Controle de Empréstimo e Devolução de Livros 

### Centro Paula Souza -  Fatec Ferraz - Curso de Análise e Desenvolvimento de Sistemas 

### Disciplina – Programação Web – Prof. Edson Saraiva de Almeida 

### Grupo 1 
- Bruna Nunes 
- Erika Ramos 
- Gustavo Nunes 
- Nicholas Alves 

### Objetivo 
Este projeto tem como objetivo implementar uma aplicação de empréstimo e devolução de livros, para se familiarizar com a plataforma de desenvolvimento web JEE Spring Boot. 

### Design

![design1](https://user-images.githubusercontent.com/45825131/123523863-15ddd080-d69d-11eb-93fc-e7372eadd7b6.jpg)
![design2](https://user-images.githubusercontent.com/45825131/123523864-16766700-d69d-11eb-803c-fe40fd4b825e.jpg)
![design3](https://user-images.githubusercontent.com/45825131/123523865-170efd80-d69d-11eb-9140-d35b8d674686.jpg)
![design4](https://user-images.githubusercontent.com/45825131/123523866-170efd80-d69d-11eb-855c-f5e397e441e0.jpg)

### Processo de Desenvolvimento O processo de desenvolvimento segue uma adaptação do Scrum. 
Cada interação tem a duração de 4 aulas. Ao final da interação o código é avaliado pelo time 
junto com o professor na atividade de revisão da sprint. Em seguida a reunião de restrospectiva 
do sprint é realizada pelo grupo e uma ata é publicada no Teams.  
 
![idef02](https://user-images.githubusercontent.com/14267502/84417700-6a2a2580-abec-11ea-8b39-d20213a4f15d.png) 
 
### Backlog do produto 
- REQ01 - Cadastrar Usuário
  - Como: Bibliotecário
  - Quero: Cadastrar um usuário
  - De modo que: o usuário possa realizar login no sistema, consultar livros e ser capaz de realizar empréstimos.

- REQ01CT01 Cadastro de usuário com sucesso
  - Dado que: o usuário não está cadastrado
  - Quando: o bibliotecário digita as informações obrigatórias: "Nome", "CPF" (no caso de professores e bibliotecários) ou "RA" (no caso de alunos), "Email", "Tipo de usuário" e confirma o cadastro
  - Então: O sistema valida os dados e uma mensagem indicando o sucesso do cadastro é exibida.

- REQ01CT02 - Cadastro de usuário com CPF ou RA já existente
  - Dado que: o CPF informado já está cadastrado
  - Quando: o bibliotecário confirma o cadastro
  - Então: O sistema identifica a existência de um usuário com o mesmo CPF ou RA já cadastro e exibe uma mensagem de erro, informando o ocorrido e retornando a tela de cadastro para que o CPF ou RA seja corrigido.

- REQ02 - Consultar Usuário
  - Como: Bibliotecário
  - Quero: Consultar um usuário
  - De modo que: o bibliotecário possa revisar as informações sobre o cadastro e visualizar as pendências relacionadas a ele.

- REQ02CT01 - Consulta realizada com sucesso
  - Dado que: o usuário está cadastrado
  - Quando: o bibliotecário digita o nome ou CPF/RA do usuário para localizá-lo ou navega até a tela de consulta geral.
  - Então: O sistema exibe os dados correspondentes da pesquisa ou retorna todos os cadastros de usuário existentes no sistema.

- REQ02CT02 - Consulta sem resultados registrados
  - Dado que: o nome, CPF ou RA informado não está cadastrado
  - Quando: o bibliotecário digita o nome, CPF ou RA do usuário
  - Então: O sistema identifica a inexistência de um usuário com nome, CPF ou RA informado e retorna uma mensagem informando que não existem usuários correspondentes.

- REQ03 - Excluir Usuário
  - Como: Bibliotecário
  - Quero: Excluir um usuário
  - De modo que: o usuário não possa mais realizar login no sistema, consultar livros e ser capaz de realizar empréstimos, sendo excluído da base da dados do sistema.

- REQ03CT01 - Usuário excluído com sucesso
  - Dado que: o usuário está cadastrado
  - Quando: o bibliotecário consulta o usuário e acessa o seu perfil, selecionando a opção de exclusão.
  - Então: O sistema - requere uma confirmação e então realiza a exclusão, exibindo ao final uma mensagem de sucesso para a exclusão.

- REQ03CT02 - Exclusão de usuário com pendências
  - Dado que: o usuário já está cadastrado e possui pendências de livros emprestados
  - Quando: o bibliotecário consulta o usuário e acessa o seu perfil, selecionando a opção de exclusão
  - Então: O sistema identifica a existência de pendências relacionadas ao usuário, retornando uma mensagem de que não é possível excluir o usuário e voltando a tela de consulta.

- REQ04 - Editar Usuário
  - Como: Bibliotecário
  - Quero: Editar um usuário
  - De modo que: o usuário tenha suas informações alteradas.

- REQ04CT01 - Edição de usuário com sucesso
  - Dado que: o usuário está cadastrado
  - Quando: o bibliotecário edita as informações: "Nome", "Email", "Tipo de usuário" e confirma a edição
  - Então: O sistema valida os dados e uma mensagem indicando o sucesso da edição é exibida.

- REQ05 - Cadastrar Livro
  - Como: Bibliotecário
  - Quero: Cadastrar um livro
  - De modo que: o livro possa ser emprestado.

- REQ05CT01 - Cadastro de livro com sucesso
  - Dado que: o livro não está cadastrado
  - Quando: o bibliotecário digita as informações obrigatórias: "ISBN", "título", "autor" e confirma o cadastro
  - Então: O sistema valida os dados e uma mensagem indicando o sucesso do cadastro é exibida.

- REQ05CT02 - Cadastro de livro com ISBN já existente
  - Dado que: o ISBN informado já está cadastrado
  - Quando: o bibliotecário confirma o cadastro
  - Então: O sistema identifica a existência de um livro com o mesmo ISBN já cadastrado e exibe uma mensagem de erro, informando o ocorrido e retornando a tela de cadastro para que o ISBN seja corrigido.

- REQ06 - Consultar Livro
  - Como: Bibliotecário, aluno, professor
  - Quero: Consultar um livro
  - De modo que: o bibliotecário, aluno e professor possam visualizar as informações dos livros.

- REQ06CT01 - Consulta realizada com sucesso
  - Dado que: o livro está cadastrado
  - Quando: o bibliotecário, aluno e professor digitam o título ou ISBN do livro para localizá-lo ou navega até a tela de consulta geral.
  - Então: O sistema exibe os dados correspondentes da pesquisa ou retorna todos os cadastros de livros existentes no sistema.

- REQ06CT02 - Consulta sem resultados registrados
  - Dado que: o título ou ISBN informados não estão cadastrados
  - Quando: o bibliotecário digita o título ou ISBN do livro
  - Então: O sistema identifica a inexistência de um livro com o título ou ISBN informado e retorna uma mensagem informando que não existem livros correspondentes.

- REQ07 - Excluir Livro
  - Como: Bibliotecário
  - Quero: Excluir um livro
  - De modo que: o livro não possa mais ser consultado ou emprestado e seja excluído da base de dados.

- REQ07CT01 - Livro excluído com sucesso
  - Dado que: o livro está cadastrado
  - Quando: o bibliotecário consulta o livro e acessa o seu registro, selecionando a opção de exclusão.
  - Então: O sistema - requere uma confirmação e então realiza a exclusão, exibindo ao final uma mensagem de sucesso para a exclusão.

- REQ07CT02 - Exclusão de livro emprestado
  - Dado que: o livro já está cadastrado e foi emprestado
  - Quando: o bibliotecário consulta o livro e acessa o seu registro, selecionando a opção de exclusão
  - Então: O sistema identifica a existência de pendências relacionadas ao livro, retornando uma mensagem de que não é possível excluir o livro e voltando a tela de consulta.

- REQ08 - Editar Livro
  - Como: Bibliotecário
  - Quero: Editar um livro
  - De modo que: o livro tenha suas informações alteradas.

- REQ08CT01 - Edição de livro com sucesso
  - Dado que: o livro está cadastrado
  - Quando: o bibliotecário edita as informações: "Título" ou "autor" e confirma a edição
  - Então: O sistema valida os dados e uma mensagem indicando o sucesso da edição é exibida.

- REQ09 - Realizar Empréstimo
  - Como: Bibliotecário
  - Quero: Realizar um empréstimo
  - De modo que: um livro seja emprestado a determinado usuário.

- REQ09CT01 - Empréstimo realizado com sucesso
  - Dado que: o livro e o usuário estão cadastrados e o usuário e o livro não possuem pendências de empréstimo
  - Quando: o bibliotecário seleciona o usuário e o livro, digita a data de empréstimo, devolução e confirma o empréstimo
  - Então: O sistema valida os dados e uma mensagem indicando o sucesso do empréstimo é exibida.

- REQ09CT02 - usuário já está em posse de algum livro
  - Dado que: o usuário possui pendências
  - Quando: o bibliotecário confirma o empréstimo
  - Então: O sistema identifica a existência de pendências do usuário e exibe uma mensagem de erro, informando o ocorrido e retornando a tela de empréstimos.

- REQ09CT03 - O livro já foi emprestado
  - Dado que: o livro possui pendências
  - Quando: o bibliotecário confirma o empréstimo
  - Então: O sistema identifica a existência de pendências do livro e exibe uma mensagem de erro, informando o ocorrido e retornando a tela de empréstimos.

- REQ10 - Realizar Devolução
  - Como: Bibliotecário
  - Quero: Realizar uma devolução
  - De modo que: o livro volte a ser passível de empréstimo e o usuário volte a ser liberado para realizar novos empréstimos.

- REQ10CT01 - Devolução realizada com sucesso
  - Dado que: o livro e o usuário estão cadastrados e o usuário e o livro possuem pendências de empréstimo
  - Quando: o bibliotecário seleciona o registro relacionado ao empréstimo e confirma a devolução
  - Então: O sistema valida e uma mensagem indicando o sucesso da devolução é exibida.

- REQ11 - Realizar Login
  - Como: Bibliotecário, aluno e professor
  - Quero: Realizar login
  - De modo que: o usuário obtenha acesso ao sistema

- REQ11CT01 - Login realizado com sucesso
  - Dado que: o usuário está cadastrado no sistema e os dados de acesso estão corretos
  - Quando: o bibliotecário, professor e aluno digitam o usuário e senha
  - Então: O sistema valida os dados e uma mensagem indicando o sucesso do login é exibida. O usuário é redirecionado para a interface do sistema.

- REQ11CT02 - Dados de acesso incorretos
  - Dado que: O usuário e/ou senha estão incorretos
  - Quando: o bibliotecário, aluno e professor digitam o usuário e senha
  - Então: O sistema identifica que os dados estão incorretos e exibe uma mensagem de erro, informando o ocorrido e retornando a tela de login.

- REQ12 - Realizar Logout
  - Como: Bibliotecário, aluno e professor
  - Quero: Realizar logout
  - De modo que: o usuário saia do sistema

- REQ12CT01 - Logout realizado com sucesso
  - Dado que: o usuário está logado no sistema
  - Quando: o bibliotecário, professor e aluno clicam em logout
  - Então: O sistema retorna para a tela de login.

- REQ13 - Gerar relatório de livros mais emprestados
  - Como: Bibliotecário
  - Quero: Gerar relatório dos livros mais emprestados
  - De modo que: o sistema possa apoiar a tomada de decisões

- REQ13CT01 - relatório gerado com sucesso
  - Dado que: o usuário está logado no sistema
  - Quando: o bibliotecário clica na opção de relatório
  - Então: O sistema exibe o relatório

- REQ14 - Gerar relatório de livros não devolvidos
  - Como: Bibliotecário
  - Quero: Gerar relatório dos livros não devolvidos
  - De modo que: o sistema possa apoiar a tomada de decisões

- REQ14CT01 - relatório gerado com sucesso
  - Dado que: o usuário está logado no sistema
  - Quando: o bibliotecário clica na opção de relatório
  - Então: O sistema exibe o relatório
 
### 1. Planejamento da Sprint 
Durante a fase de planejamento as funcionalidades nesta interação são selecionadas do backlog do produto.  
 
### 2. Estratégia de desenvolvimento. 
Na primeira interação a meta é criar um baseline (base de sustentação) da arquitetura do sistema a fim de definir 
como o código será organizado nas próximas interações. A arquitetura se desenvolve a partir de um exame dos requisitos
mais significativos (aqueles que têm grande impacto na arquitetura do sistema) e de uma avaliação de risco. A 
estabilidade da arquitetura é avaliada através de um ou mais protótipos de arquitetura. O projeto do 
“Sistema de Controle de Empréstimo de Livros” deve se utilizar de uma arquitetura que permita flexibilidade na 
configuração do sistema de persistência (mudança do sistema de gerenciamento de banco de dados) e manutenções 
na interface de usuário com poucos efeitos colaterais. A arquitetura selecionada para atender esta necessidade é
a arquitetura MVC.  
 
A estratégia de construção e integração do software será ascendente na hierarquia de controle, ou seja, da base de dados 
(backend) para a interface de interação homem máquina (frontend).  

### Modelo de Domínio 
![modelo de dominio](https://user-images.githubusercontent.com/14267502/84425324-bd55a580-abf7-11ea-99c7-f427b80fb7cc.png)

