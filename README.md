# Configuração inicial

* Configurar o banco de dados em ```/src/main/resources```

* Gerar um usuário inicial para realizar o CRUD com autenticação.
> A URI "/" permite cadastrar um funcinário e não está protegina gerar o primeiro usuário.

> Caso prefira, um dump foi disponibilizado [aqui](./doc/db/dump). Todos os usuários possuem a senha 1234.

O comando a seguir pode ser utilizado para cadastrar o primeiro funcionário.

```
curl -X POST -H "Content-Type: application/json" http://FQDN_OR_IP[:PORT]/ -d '{"name": "func1","email": "func1@vet.com", "password": "1234","role": "REOLE_VET"}'

```

# Documentação

* [Documentação da API](./doc)

* [Modelagem do banco de dados](./doc/db)

---

# Crud Spring Boot - Pet Schedule

# Tecnologias
- JAVA 1.8
- Maven
- Spring 
- REST
- MySQL

# Descrição Geral
 Este projeto é um modelo para agendamento de horários em um PetShop/Clinica Veterinária.
 O sistema deve ser capaz de cadastrar os funcionários/veterinários, cadastrar os Clientes 
 e os Pets que este Cliente possui. Após cadastro deve ser possivel agendar um horário para 
 que um pet seja atendido por um veterinário.
 Para cadastro o funcionário deve efetuar o login no sistema. Após logado, além de 
 cadastrar um agendamentos, o funcionario também poderá alterar e deletar consultas. 
 Além disso o funcionario deve poder listar os agendamentos podendo filtrar por veterinário, 
 e data. 
 O cliente pode consultar os seus agendamentos sem necessidade de login, apenas informando 
 o seu cpf. 

# Requisitos:
   * Para o desenvolvimento não é necessário criar o visual;
   * Todas as consultas devem ser realizadas através de API REST; 
   * O sistema deve ser desenvolvido usando a estrutura fornecida como exemplo;
   * O código deve ser documentado com JavaDoc;
   * Os Endpoints REST devem estar documentados;
   * Criar o Banco de Dados utilizando MySQL;
   * Enviar link do git com o código pronto;

# Diferenciais:
   * Criar os testes unitários.  
   * Criar versionamento do Banco com Liquibase

   

