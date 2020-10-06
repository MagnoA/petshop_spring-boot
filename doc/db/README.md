# Banco de Dados

A aplicação Pet Schedule é uma ferramenta de agendamento de consultas em Petshop.
O serviço possui 3 entidades básicas: Pet, Employee e Client. E uma tabela resultado de um relacionamento entre Employee e Pet. Esse relacionamento contempla as informações de agenda, chamada de Schedule. 

O diagrama de entidade e relacionamento é mostrado no Anexo 1.

## Pet
O Pet é a entidade onde são armazenadas as informações do animal composto por 3 atributos:

 * name - Nome;
 
 * kind - Tipo de animal (Cachorro, gato, papagaio etc);
 
 * breed - Raça daquele animal
 
 Além desses, a entidade pet se relaciona com client e por isso possui a chave estrangeira id_cliente.
 
 ## Client
 Client diz respeito a todos os clientes do petshop que são donos de um ou mais pets. A entidade contém 4 atributos.
 
  * name - Nome
  
  * address - Endereço residencial
  
  * telephone - Número de telefone
  
  * cpf - CPF
  
O CPF é uma string única dentro do banco de dados.
  
## Employee
Employee representa todos os funcionários do petshop. A função desempenhada por cada funcionário dentro da empresa é indicada com o atributo **role**. Esse atributo também pode ser utilizado para criar a autorização de usuários autenticados.
Employee contém 4 atributos básicos.

 * name - Nome
 
 * email - Endereço de email
 
 * Password - Senha de acesso
 
 * role - Papel desempenhado pelo funcionário.

## Schedule
O schedule mantém as informações de agendamentos das consultas feitas no petshop. O relacionamento contém os seguintes atributos:

 * id_pet - Chave estrangeira com o ID de Pet
 
 * id_employee - Chave estrangeira com o ID de Employee
 
 * date - Data de agendamento
 
 * time - Hora e minuto de agendamento
 
 
 
 ## Anexo 1
Modelagem do bando de dados.

![db_model](./images/db_model.png)

\*Imagem para simples conferência
