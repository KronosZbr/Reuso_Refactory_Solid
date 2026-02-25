# Gerenciador de Usuários - Refatoração SOLID

## Objetivo do Projeto
Este projeto foi refatorado com o objetivo de aplicar na prática os princípios **SOLID**, promovendo uma arquitetura mais limpa, redução de acoplamento e maior facilidade para extensões futuras. A refatoração focou na separação clara de responsabilidades entre as camadas da aplicação.

## Arquitetura Pós-Refatoração
A aplicação agora segue um fluxo de camadas bem definido, onde a comunicação ocorre preferencialmente através de interfaces:
**Controller** → **Service** → **Regra (Strategy)** → **Repository** & **NotificationService**.

## Aplicação dos Princípios SOLID

### 1. Single Responsibility Principle (SRP)
Cada classe passou a ter uma única razão para mudar:
* **Controllers**: Responsáveis apenas por receber requisições HTTP e retornar respostas.
* **`GerenciadorUsuarioService`**: Concentra apenas a orquestração do processo de criação de usuários.
* **`NotificationService`**: Especializado exclusivamente no fluxo de notificações.

### 2. Open/Closed Principle (OCP)
O sistema está aberto para extensão, mas fechado para modificação:
* Foi introduzida a interface **`RegraUsuario`**.
* O serviço de usuário agora utiliza um mapa de regras injetado via Spring, permitindo adicionar novos tipos de usuários (como "Premium" ou "Administrador") apenas criando uma nova classe, sem alterar o código existente no `GerenciadorUsuarioService`.

### 3. Liskov Substitution Principle (LSP)
A hierarquia de modelos foi refinada para garantir que as subclasses possam substituir a superclasse sem quebrar o sistema:
* A classe **`Usuario`** define comportamentos base que são estendidos por **`UsuarioVIP`** de forma coerente.
* As implementações de regras de negócio (`RegraUsuarioComum` e `RegraUsuarioVip`) respeitam rigorosamente o contrato da interface pai.

### 4. Interface Segregation Principle (ISP)
A interface de repositório original foi segregada em interfaces menores e mais específicas, evitando que os clientes dependam de métodos que não utilizam:
* **`UsuarioCrudRepository`**: Operações básicas de persistência.
* **`UsuarioFiltroRepository`**: Consultas e buscas personalizadas.
* **`UsuarioRelatorioRepository`**: Métodos específicos para geração de relatórios e contagens.

### 5. Dependency Inversion Principle (DIP)
O projeto agora depende de abstrações (interfaces) e não de implementações concretas:
* O `NotificationService` depende da interface **`EmailService`**.
* A implementação concreta **`SpringEmailService`** encapsula os detalhes do `JavaMailSender`, permitindo trocar a tecnologia de envio de e-mail sem afetar a lógica de negócio.

## Estrutura do Projeto
A nova organização de pacotes reflete a separação de responsabilidades:
* `controller`: Endpoints da API.
* `dto`: Objetos de transferência de dados.
* `model`: Entidades de domínio.
* `repository`: Interfaces de persistência segregadas.
* `service`: Lógica de negócio e notificações.
* `service.regra`: Implementações do padrão Strategy para regras de usuários.
* `service.email`: Abstrações e implementações de infraestrutura de e-mail.

---
*Projeto desenvolvido com Java 21 e Spring Boot.*
