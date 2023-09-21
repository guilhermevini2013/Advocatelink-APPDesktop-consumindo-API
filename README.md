# Documentação do Projeto AdvocateLink

## Visão Geral
O projeto AdvocateLink é uma aplicação que permite gerenciar funcionários e clientes através de uma API. Ele oferece as seguintes funcionalidades:

- **Uso em Modo Offline:** O aplicativo suporta um modo offline que permite ao usuário continuar utilizando-o mesmo quando não estiver conectado à API do AdvocateLink.

- **Gerenciamento de Funcionários e Clientes:** É possível realizar operações CRUD (Create, Read, Update, Delete) para funcionários e clientes.

## Modo Offline
O AdvocateLink suporta um modo offline para permitir que os usuários continuem utilizando o aplicativo mesmo quando não estão conectados à API. No entanto, é importante notar que as operações que requerem interação com a API não estarão disponíveis durante o modo offline. As informações serão sincronizadas com a API assim que a conexão for restaurada.

## Endpoints da API
A API do AdvocateLink oferece os seguintes endpoints:

### 1. Alterar Funcionário/Cliente (PUT)
- **Endpoint:** `PUT /client/api/{id}`
- **Descrição:** Este endpoint permite alterar informações de um cliente existente com base no ID fornecido.
- **Parâmetros:**
  - `{id}`: ID do funcionário ou cliente que deseja atualizar.
- **Corpo da Solicitação:** O corpo da solicitação deve conter os dados atualizados do funcionário ou cliente.

### 2. Deletar Funcionário/Cliente (DELETE)
- **Endpoint:** `DELETE /client/api/{id}`
- **Descrição:** Este endpoint permite excluir cliente existente com base no ID fornecido.
- **Parâmetros:**
  - `{id}`: ID do funcionário ou cliente que deseja excluir.

### 3. Pesquisar Lista de Clientes (GET)
- **Endpoint:** `GET /client/api`
- **Descrição:** Este endpoint retorna uma lista de todos os clientes cadastrados no AdvocateLink.

### 4. Adicionar Cliente (POST)
- **Endpoint:** `POST /client/api/add`
- **Descrição:** Este endpoint permite adicionar um novo cliente ao AdvocateLink.
- **Corpo da Solicitação:** O corpo da solicitação deve conter os dados do novo cliente a ser adicionado.

### 5. Obter um Único Cliente (GET)
- **Endpoint:** `GET /client/api/{id}`
- **Descrição:** Este endpoint retorna informações detalhadas de um cliente específico com base no ID fornecido.
- **Parâmetros:**
  - `{id}`: ID do cliente que deseja obter.
    
## Como Consumir a API
Para consumir a API do AdvocateLink, siga os passos abaixo:

1. Clone o repositório da API em [https://github.com/guilhermevini2013/Formulario-AdvocateLink](https://github.com/guilhermevini2013/Formulario-AdvocateLink).

2. Siga as instruções fornecidas no README do repositório para configurar e iniciar a API localmente.

3. Depois de configurada, você poderá acessar a API localmente no seu servidor local (normalmente em `localhost:8080`).

Utilize os endpoints mencionados nesta documentação para interagir com a API do AdvocateLink.

Isso conclui a documentação do projeto AdvocateLink. Utilize essas instruções para consumir a API local e gerenciar funcionários e clientes.
<br>
<br>
# Modelo logico e conceitual do Banco de Dados
<img src="src/imagens/logico.png">
<img src="src/imagens/conceitual.png">
