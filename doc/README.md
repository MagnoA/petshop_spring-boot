# Documentação da API

Para informacoes a docuementação relacionada ao banco de dados, [clique aqui](./db).

## Sumário 
[1 - Consulta de Agendamentos](#topico1) \
[2 - Gerenciamento de Clientes](#topico2) \
[3 - Gerenciamento de Pets](#topico3) \
[4 - Gerenciamento de Funcionários](#topico4) \
[5 - Gerenciamento de Agenda](#topico5) 


## Endpoints

### 1 - Consulta simples de Agendamentos <a name="topico1"></a>
> As seguintes URIs não necessitam de autenticação.

 * ``` /client ``` \
**Metodo:** GET \
**Descrição:** Consulta de agendamentos pelo usuário. \
**Condeúdo da Requisição:** JSON informando CPF
**Resposta:** JSON com todos os Pets e agendamentos do cliente \
**Exemplo:** 
```
curl -X GET -H "Content-Type: application/json" http://FQDN_OR_IP[:PORT]/client -d '{"cpf": "155.038.607-72"}'

```

 * ``` /date ``` \
**Metodo:** GET \
**Descrição:** Consulta de agendamentos pelo usuário. \
**Condeúdo da Requisição:** JSON informando a data (Formato: **yyyy-MM-dd**) \
**Resposta:** JSON com todos os agendamentos daquela data (Pet + Agendamento) \
**Exemplo:** 
```
curl -X GET -H "Content-Type: application/json" http://FQDN_OR_IP[:PORT]/date -d '{"date": "2020-10-15"}'

```


### Consultas e requisições do aplicação.
> As seguintes URIs necessitam de autenticação

#### 2 - Gerenciamento de Clientes <a name="topico2"></a>
 * ``` /clients ``` \
**Metodo:** GET \
**Descrição:** Consulta todos os clientes. \
**Condeúdo da Requisição:**
**Resposta:** JSON com todos os clientes registrados com seus respectivos pets e agendamentos \
**Exemplo:** 
```
curl -X GET -H "Content-Type: application/json" -u email:password http://FQDN_OR_IP[:PORT]/clients

```

 * ``` /clients/{id} ``` \
**Metodo:** GET \
**Descrição:** Busca o cliente pelo ID. \
**Condeúdo da Requisição:**
**Resposta:** JSON com o cliente com seus respectivos pets e agendamentos \
**Exemplo:** 
```
curl -X GET -H "Content-Type: application/json" -u email:password http://FQDN_OR_IP[:PORT]/clients/1

```

 * ``` /clients/cpf ``` \
**Metodo:** GET \
**Descrição:** Busca o cliente pelo seu CPF. \
**Condeúdo da Requisição:** JSON com o cpf do cliente
**Resposta:** JSON com o cliente e com seus respectivos pets e agendamentos \
**Exemplo:** 
```
curl -X GET -H "Content-Type: application/json" -u email:password http://FQDN_OR_IP[:PORT]/clients/cpf -d '{"cpf": "155.038.607-72"}'

```

 * ``` /clients/cpf/pets ``` \
**Metodo:** GET \
**Descrição:** Busca somente os pets daquele um cliente pelo seu cpf. \
**Condeúdo da Requisição:** JSON com o cpf do cliente
**Resposta:** JSON os respectivos pets e agendamentos \
**Exemplo:** 
```
curl -X GET -H "Content-Type: application/json" -u email:password http://FQDN_OR_IP[:PORT]/clients/cpf/pets -d '{"cpf": "155.038.607-72"}'

```

 * ``` /clients ``` \
**Metodo:** POST \
**Descrição:** Registra um cliente e a lista de pets (OPCIONAL). \
**Condeúdo da Requisição:** JSON com todas as informações do cliente. Se optar por adicionar os pets, deve ser informado em forma de lista.
**Resposta:** JSON com o cliente e pets(se houver) criados \
**Exemplo:** 
```
curl -X POST -H "Content-Type: application/json" -u email:password http://FQDN_OR_IP[:PORT]/clients/ -d @client.json

```

client.json (Sem pets)
```json
{
  "name": "fulano da silva",
  "address": "Rua 1",
  "telephone": "48999999999",
  "cpf": "155.038.607-72"
}
```

client.json (Com pets)
```json
{
  "name": "fulano da silva",
  "address": "Rua 1",
  "telephone": "48999999999",
  "cpf": "155.038.607-72",
  "pets":
  [
    {
      "name": "bilu",
      "kind": "cachorro",
      "breed": "chihuahua"
    }
  ]
}
```

 * ``` /clients ``` \
**Metodo:** PUT \
**Descrição:** Atualiza as informações do cliente. \
**Condeúdo da Requisição:** JSON com todas as informações do cliente que deseja atualizar. Não há a necessidade de conhecimento prévido do ID do cliente, a busca é feita pelo cpf. Obs.: Somente informaçoes do cliente. \
**Resposta:** JSON com as informações do cliente atualizadas \
**Exemplo:** 
```
curl -X PUT -H "Content-Type: application/json" -u email:password http://FQDN_OR_IP[:PORT]/clients/ -d '{"cpf": "155.038.607-72", "telephone": "48777777777"}'

```

 * ``` /clients ``` \
**Metodo:** DELETE \
**Descrição:** Deleta um cliente. \
**Condeúdo da Requisição:** JSON com o CPF do cliente. \
**Resposta:**
**Exemplo:** 
```
curl -X DELETE -H "Content-Type: application/json" -u email:password http://FQDN_OR_IP[:PORT]/clients/ -d '{"cpf": "155.038.607-72"}'

```

 * ``` /clients/{id} ``` \
**Metodo:** DELETE \
**Descrição:** Deleta o cliente pelo ID informado \
**Condeúdo da Requisição:** \
**Resposta:** \
**Exemplo:** 
```
curl -X DELETE -H "Content-Type: application/json" -u email:password http://FQDN_OR_IP[:PORT]/clients/1

```

#### 3 - Gerenciamento de Pets <a name="topico3"></a>

 * ``` /pets ``` \
**Metodo:** GET  \
**Descrição:** Busca todos os pets registrados \
**Condeúdo da Requisição:** \
**Resposta:** JSON contendo todos os pets \
**Exemplo:** 
```
curl -X GET -H "Content-Type: application/json" -u email:password http://FQDN_OR_IP[:PORT]/pets

```

 * ``` /pets/{id} ``` \
**Metodo:** GET \
**Descrição:** Busca um pet pelo ID \
**Condeúdo da Requisição:** \
**Resposta:** JSON com as informações do pet com seus respectivos agendamentos \
**Exemplo:** 
```
curl -X  -H "Content-Type: application/json" -u email:password http://FQDN_OR_IP[:PORT]/pets/1

```
 * ``` /pets ``` \
**Metodo:** POST \
**Descrição:**  Registro um novo pet\
**Condeúdo da Requisição:** JSON com o cpf do dono e informações do(s) pet(s) \
**Resposta:** JSON com o(s) pet(s) adicionado(s) \
**Exemplo:** 
```
curl -X POST -H "Content-Type: application/json" -u email:password http://FQDN_OR_IP[:PORT]/pets -d @pets.json

```

pets.json
```json
{
  "cpf": "155.038.607-72",
  "pets":
  [
    {
      "name": "miau",
      "kind": "gato",
      "breed": "somali"
    },
    {
      "name": "lua",
      "kind": "gato",
      "breed": "vira-lata"
    }
  ]
}
```

 * ``` /pets ``` \
**Metodo:** PUT \
**Descrição:** Atualiza um pet via CPF do cliente. \
**Condeúdo da Requisição:** JSON com o CPF do cliente, ID do pet e as informações que deseja atualizar do(s) pet(s) \
**Resposta:** JSON com o(s) pet(s) atualizado(s) \
**Exemplo:** 
```
curl -X PUT -H "Content-Type: application/json" -u email:password http://FQDN_OR_IP[:PORT]/pets -d @petsUpdate.json
```

petsUpdate.json
```json
{
  "cpf": "155.038.607-72",
  "pets":
  [
    {
      "id": 1,
      "name": "mia",
    },
    {
      "id": 2,
      "name": "lulu",
    }
  ]
}
```

 * ``` /pets ``` \
**Metodo:** PUT \
**Descrição:** Atualiza informações de um determinado pet \
**Condeúdo da Requisição:** JSON com o ID e as informações que deseja atualizar \
**Resposta:** JSON com as informações do pet atualizadas \
**Exemplo:** 
```
curl -X PUT -H "Content-Type: application/json" -u email:password http://FQDN_OR_IP[:PORT]/pets -d @petUpdate.json

```

petUpdate.json
```json
{
  "id": 1,
  "breed": "savannah"
}
```
 * ``` /pets ``` \
**Metodo:** DELETE \
**Descrição:** Apaga pet(s) dos registros. \
**Condeúdo da Requisição:** JSON com o CPF do dono e o ID do(s) pet(s)  \
**Resposta:** \
**Exemplo:** 
```
curl -X DELETE -H "Content-Type: application/json" -u email:password http://FQDN_OR_IP[:PORT]/pets -d '{"cpf": "155.038.607-72", "pets": [ {"id": 1} ] }'

```

#### 4 - Gerenciamento de Funcionários <a name="topico4"></a>


 * ``` /employees ``` \
**Metodo:** GET \
**Descrição:** Busca todos os funcionários registrado e suas respectivas agendas \
**Condeúdo da Requisição:** \
**Resposta:** JSON com todos os funcionários e respectivas agendas \
**Exemplo:** 
```
curl -X GET -H "Content-Type: application/json" -u email:password http://FQDN_OR_IP[:PORT]/employees

```


 * ``` /employees/1 ``` \
**Metodo:**  GET \
**Descrição:**  Busca um funcionário pelo seu ID \
**Condeúdo da Requisição:** \
**Resposta:** JSON com informações do funcionário e sua agenda \
**Exemplo:** 
```
curl -X GET  -H "Content-Type: application/json" -u email:password http://FQDN_OR_IP[:PORT]/employees/1

```

 * ``` /employees/email ``` \
**Metodo:**  GET \
**Descrição:** Busca um funcionário pelo seu e-mail. \
**Condeúdo da Requisição:** JSON com o email do funcioário \
**Resposta:** JSON com informações do funcionário e sua agenda \
**Exemplo:** 
```
curl -X GET -H "Content-Type: application/json" -u email:password http://FQDN_OR_IP[:PORT]/employees/email -d '{"email": "func@vet.com"}'

```


 * ``` /employees ``` \
**Metodo:** POST  \
**Descrição:**  Registra um novo funcionário \
**Condeúdo da Requisição:** JSON com todas as informações referentes ao funcionário \
**Resposta:** JSON com as informações registradas do funcionário \
**Exemplo:** 
```
curl -X POST -H "Content-Type: application/json" -u email:password http://FQDN_OR_IP[:PORT]/employees -d @func.json

```

func.json
```json
{
  "name": "funcionario",
  "email": "func@vet.com",
  "password": "senha",
  "role": "ROLE_VET"
}
```

 * ``` /employees ``` \
**Metodo:** PUT \
**Descrição:** Atualiza as informações de um funcionário \
**Condeúdo da Requisição:** JSON com o e-mail e as informações que deseja atualizar. Obs.: O email não pode ser alterado \
**Resposta:** JSON com as informações atualizadas do funcionário \
**Exemplo:** 
```
curl -X PUT -H "Content-Type: application/json" -u email:password http://FQDN_OR_IP[:PORT]/employees -d '{"email": "func@vet.com", "senha": "senha123"}'

```

 * ``` /employees/{id} ``` \
**Metodo:** DELETE \
**Descrição:** Remove um funcionário pelo seu ID \
**Condeúdo da Requisição:** \
**Resposta:** JSON com os demais funcionários \
**Exemplo:** 
```
curl -X DELETE -H "Content-Type: application/json" -u email:password http://FQDN_OR_IP[:PORT]/employees/1

```


#### 5 - Gerenciamento de Agenda <a name="topico5"></a>

 * ``` /schedule/vet ``` \
**Metodo:**  GET \
**Descrição:**  Busca toda a agenda de um determinado funcionário \
**Condeúdo da Requisição:** JSON com o e-mail do funcionário \
**Resposta:** JSON com todas as agendas (PET + AGENDA) daquele funcionário \
**Exemplo:** 
```
curl -X GET  -H "Content-Type: application/json" -u email:password http://FQDN_OR_IP[:PORT]/schedule/vet -d '{"email": "func@vet.com"}'

```

 * ``` /schedule ``` \
**Metodo:**  POST \
**Descrição:**  Registra uma nova consulta \
**Condeúdo da Requisição:** JSON com o e-mail do funcionário dono da agenda e agendamento(s) \
**Resposta:** JSON com o(s) agendamento(s) \
**Exemplo:** 
```
curl -X POST -H "Content-Type: application/json" -u email:password http://FQDN_OR_IP[:PORT]/schedule -d @schedule.json

```

schedule.json
```json
{
  "email": "func@vet.com",
  "schedule":
  [
    {
      "date": "2020-10-20",
      "time": "13:30",
      "pet":
        {
          "id": 1
        }
    }
  ]
}
```

* ``` /schedule ``` \
**Metodo:**  PUT \
**Descrição:**  Atualiza a consulta \
**Condeúdo da Requisição:** JSON com o e-mail do funcionário dono da agenda e agendamento(s) a ser(em) atualizado(s) \
**Resposta:** JSON com o(s) agendamento(s) (PET + AGENDAMENTO)\
**Exemplo:** 
```
curl -X PUT -H "Content-Type: application/json" -u email:password http://FQDN_OR_IP[:PORT]/schedule -d @schedule.json

```

scheduleUpdate.json
```json
{
  "email": "func@vet.com",
  "schedule":
  [
    {
      "id": 1,
      "time": "15:30"
    }
  ]
}
```

 * ``` /schedule/{id} ``` \
**Metodo:** DELETE  \
**Descrição:** Remove uma consulta agendada do bacno de dados \
**Condeúdo da Requisição:** \
**Resposta:** \
**Exemplo:** 
```
curl -X DELETE -H "Content-Type: application/json" -u email:password http://FQDN_OR_IP[:PORT]/1

```

