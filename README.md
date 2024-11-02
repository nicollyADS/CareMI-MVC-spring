# Aplicação: CareMI

### Link do Repositório: https://github.com/nicollyADS/CareMI-MVC-spring

### Integrantes do Grupo - Mapped Innovation
- **rm99977** Alberto Seiji Assato
- **rm551997** Matheus Rodrigues Oliveira
- **rm99997** Miguel Francisco de Freitas Fernandes
- **rm552579** Nicolly de Almeida Gonçalves
- **rm551521** Patrick de Lima Jaguski

### Instruções para Executar a Aplicação

1. Clone o repositório para sua máquina local
2. Certifique-se de ter o Java JDK instalado em sua máquina
3. Atualize a versão do JDK no projeto
4. Carregue o projeto com Maven
5. Instale o plugin do Lombok e habilite
6. Configure o arquivo "application.properties" e coloque as suas credenciais do banco de dados
7. Após ter configurado o ambiente, inicialize o projeto
8. Para fazer as requisições, utilize a URL `http://localhost:8080`


### Vídeo de Apresentação

Assista ao vídeo de apresentação do projeto [aqui]().


#### Listagem de Endpoints
## Home
- **GET** `/home`  
  Renderiza a página inicial.

## Login
- **GET** `/login`  
  Renderiza a página de login.

## Atendimento
- **GET** `/atendimento/cadastrar`  
  Exibe o formulário para cadastrar um atendimento.
- **POST** `/atendimento/cadastrar`  
  Processa o formulário e salva um novo atendimento.
- **GET** `/atendimento/listar`  
  Lista todos os atendimentos.
- **GET** `/atendimento/detalhes/{id}`  
  Exibe detalhes de um atendimento específico.
- **GET** `/atendimento/editar/{id}`  
  Exibe o formulário para editar um atendimento específico.
- **POST** `/atendimento/editar`  
  Processa o formulário e atualiza um atendimento.
- **POST** `/atendimento/remover`  
  Remove um atendimento com o ID fornecido.

## Exame
- **GET** `/exame/cadastrar`  
  Exibe o formulário para cadastrar um exame.
- **POST** `/exame/cadastrar`  
  Processa o formulário e salva um novo exame.
- **GET** `/exame/listar`  
  Lista todos os exames.
- **GET** `/exame/detalhes/{id}`  
  Exibe detalhes de um exame específico.
- **GET** `/exame/editar/{id}`  
  Exibe o formulário para editar um exame específico.
- **POST** `/exame/editar`  
  Processa o formulário e atualiza um exame.
- **POST** `/exame/remover`  
  Remove um exame com o ID fornecido.

## Médico
- **GET** `/medico/cadastrar`  
  Exibe o formulário para cadastrar um médico.
- **POST** `/medico/cadastrar`  
  Processa o formulário e salva um novo médico.
- **GET** `/medico/listar`  
  Lista todos os médicos.
- **GET** `/medico/pesquisar`  
  Pesquisa médicos por nome.
- **GET** `/medico/detalhes/{id}`  
  Exibe detalhes de um médico específico.
- **GET** `/medico/editar/{id}`  
  Exibe o formulário para editar um médico específico.
- **POST** `/medico/editar`  
  Processa o formulário e atualiza um médico.
- **POST** `/medico/remover`  
  Remove um médico com o ID fornecido.

## Paciente
- **GET** `/paciente/cadastrar`  
  Exibe o formulário para cadastrar um paciente.
- **POST** `/paciente/cadastrar`  
  Processa o formulário e salva um novo paciente.
- **GET** `/paciente/listar`  
  Lista todos os pacientes.
- **GET** `/paciente/detalhes/{id}`  
  Exibe detalhes de um paciente específico.
- **GET** `/paciente/editar/{id}`  
  Exibe o formulário para editar um paciente específico.
- **POST** `/paciente/editar`  
  Processa o formulário e atualiza um paciente.
- **POST** `/paciente/remover`  
  Remove um paciente com o ID fornecido.

### ResultadoExame
- **GET /resultado-exame/cadastrar**  
  Renderiza o formulário para cadastro de um novo resultado de exame.

- **POST /resultado-exame/cadastrar**  
  Cadastra um novo resultado de exame. Requer um objeto `ResultadoExame` válido.

- **GET /resultado-exame/listar**  
  Exibe a lista de todos os resultados de exames cadastrados.

- **GET /resultado-exame/detalhes/{id}**  
  Exibe os detalhes de um resultado de exame específico com base no ID.

- **GET /resultado-exame/editar/{id}**  
  Renderiza o formulário de edição para um resultado de exame específico com base no ID.

- **POST /resultado-exame/editar**  
  Salva as alterações de um resultado de exame existente.

- **POST /resultado-exame/remover**  
  Remove um resultado de exame específico com base no ID.

### Usuario
- **GET /usuario/cadastrar**  
  Renderiza o formulário para cadastro de um novo usuário.

- **POST /usuario/cadastrar**  
  Cadastra um novo usuário. Requer um objeto `UseForm` válido.

- **GET /usuario/listar**  
  Exibe a lista de todos os usuários cadastrados.

- **GET /usuario/editar/{id}**  
  Renderiza o formulário de edição para um usuário específico com base no ID.

- **POST /usuario/editar**  
  Salva as alterações de um usuário existente.

- **POST /usuario/remover**  
  Remove um usuário específico com base no ID.
