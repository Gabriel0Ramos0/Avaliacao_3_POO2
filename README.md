# Sistema de Gerenciamento de Passageiros com Tratamento de Exceções

O sistema de gerenciamento de passageiros implementado utiliza o framework Spring Boot para criar uma API REST que permite realizar operações CRUD (Create, Read, Update, Delete) em uma entidade de passageiro. Este sistema inclui um tratamento robusto de exceções para garantir que erros sejam adequadamente tratados e respostas apropriadas sejam retornadas aos clientes.

---

## Componentes Principais

### Modelo (Model)

O modelo `Passageiro` representa a entidade de passageiro e é mapeado para uma tabela no banco de dados usando JPA (Java Persistence API).

#### Atualização do Modelo

O modelo `Passageiro` foi atualizado para incluir um relacionamento `ManyToOne` com a classe `Aviao`, permitindo que um passageiro esteja associado a apenas um avião, enquanto um avião pode ter vários passageiros.

##### Atributos do Passageiro

- **id:** Identificador único do passageiro, gerado automaticamente.
- **nome:** Nome do passageiro.
- **rg:** Número do RG do passageiro.
- **cpf:** Número do CPF do passageiro.
- **avião:** Objeto Avião associado ao passageiro.

---

### Repositório (Repository)

O arquivo `AviaoRepository.java` é uma interface que estende JpaRepository e especifica métodos adicionais para acesso aos dados da entidade Avião no banco de dados.

O arquivo `PassageiroRepository.java` é uma interface que estende JpaRepository e permite o acesso aos dados da entidade Passageiro no banco de dados por meio de métodos padrão e personalizados fornecidos pelo Spring Data JPA.

---

### Recurso (Resource)

O arquivo `AviaoResource.java` é uma classe controladora que define os endpoints REST para operações relacionadas aos aviões (`Aviao`).

#### Uso do AviaoResource

Esta classe define endpoints REST acessíveis por clientes para realizar operações como listar todos os aviões, buscar aviões por ID ou modelo, e cadastrar novos aviões.

O arquivo `PassageiroResource.java` é uma classe controladora que define os endpoints REST para operações relacionadas aos passageiros (`Passageiro`).

#### Uso do PassageiroResource

Esta classe define endpoints REST acessíveis por clientes para realizar operações como listar todos os passageiros, buscar passageiros por ID e cadastrar novos passageiros.

---

### Manipulador Global de Exceções (Global Exception Handler)

Implementamos um manipulador global de exceções para capturar e tratar exceções em todo o sistema de forma consistente, garantindo respostas adequadas em caso de erros.

---

### Serviço (Service)

#### AviaoService

A classe `AviaoService` contém a lógica de negócio relacionada aos aviões (`Aviao`) e interage com o repositório (`AviaoRepository`) para realizar operações de persistência no banco de dados.

#### Métodos do AviaoService

- **insereAviao(Aviao a):** Salva um novo avião no banco de dados.
- **alteraAviao(Aviao a):** Atualiza as informações de um avião existente no banco de dados.
- **buscaPorCodigo(Integer id):** Busca um avião pelo seu ID no banco de dados.
- **buscaPorModelo(String modelo):** Busca um avião pelo seu modelo no banco de dados.
- **excluiAviao(Aviao a):** Exclui um avião do banco de dados.
- **listarTodosAvioes():** Retorna uma lista de todos os aviões cadastrados no sistema.

#### PassageiroService

A classe `PassageiroService` contém a lógica de negócio relacionada aos passageiros (`Passageiro`) e interage com o repositório (`PassageiroRepository`) para realizar operações de persistência no banco de dados.

#### Métodos do PassageiroService

- **inserePassageiro(Passageiro p):** Salva um novo passageiro no banco de dados.
- **alteraPassageiro(Passageiro p):** Atualiza as informações de um passageiro existente no banco de dados.
- **buscaPorCodigo(Integer id):** Busca um passageiro pelo seu ID no banco de dados.
- **excluiPassageiro(Passageiro p):** Exclui um passageiro do banco de dados.
- **listaTodosPassageiros():** Retorna uma lista de todos os passageiros cadastrados no sistema.

#### Uso do PassageiroService

Esta classe encapsula a lógica de negócio relacionada aos passageiros e é utilizada pelos controladores (`PassageiroResource`) para realizar operações CRUD no sistema.

---

### `pom.xml`

O arquivo `pom.xml` é um arquivo de configuração utilizado pelo Apache Maven para definir dependências e configurações do projeto Java. Ele é essencial para gerenciar as dependências necessárias e outras configurações relacionadas ao ciclo de vida do projeto.

---

### `application.properties`

O arquivo `application.properties` no Spring Boot é usado para configurar diversos aspectos da aplicação e da conexão com o banco de dados. Ele permite definir o nome da aplicação, ajustar o comportamento do Hibernate, configurar a atualização automática do esquema do banco de dados e fornecer informações de conexão como URL, nome de usuário e senha.

---

### Postman

O Postman é uma ferramenta utilizada para testar as funcionalidades da API desenvolvida em Spring Boot. Ele permite enviar requisições HTTP aos endpoints desenvolvidos, verificando se retornam as respostas esperadas. Com o Postman, é possível configurar diferentes cenários de teste, garantindo que a API funcione corretamente antes da implantação na produção.

---

Este README.md fornece uma visão geral do sistema de gerenciamento de passageiros, seus componentes principais, lógica de negócio e ferramentas utilizadas. Ele serve como um guia para colaboradores e usuários entenderem o funcionamento e uso adequado do sistema.

