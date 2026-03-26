# 🐾 Petland - Sistema de Gestão de Pet Shop

O **Petland** é uma API REST robusta desenvolvida para gerenciar as operações diárias de um Pet Shop. O sistema permite o controle de clientes, animais, catálogo de serviços e o fluxo completo de agendamentos.

Este projeto foi construído focando em **boas práticas de desenvolvimento backend**, separação de responsabilidades e escalabilidade.

---

## 🚀 Tecnologias Utilizadas

* **Java 25**
* **Spring Boot 3**
* **Spring Data JPA** (Persistência de dados)
* **Spring Validation** (Regras de negócio e validação de campos)
* **H2 Database** / **PostgreSQL** (Suporte a banco em memória e produção)
* **Lombok** (Produtividade e código limpo)
* **Maven** (Gerenciamento de dependências)
* **Docker** (Containerização da aplicação)

---

## 🛠️ Arquitetura e Padrões

O projeto segue a arquitetura em camadas para facilitar a manutenção:
* **Controller:** Exposição dos endpoints REST.
* **Service:** Camada de lógica de negócio (onde residem as regras de agendamento e descontos).
* **Repository:** Interface de comunicação com o banco de dados via JPA.
* **DTO (Data Transfer Object):** Utilizado para transferir dados entre camadas, protegendo as entidades e otimizando o payload JSON.
* **Exception Handling:** Tratamento global de erros para retornos HTTP padronizados.

---

## 📊 Modelo de Dados

Abaixo, a representação da estrutura de classes e relacionamentos:



---

## ⚙️ Como Executar o Projeto

1. **Clone o repositório:**
   [https://github.com/juniorn06/petland.git](https://github.com/juniorn06/petland)

📌 Principais Funcionalidades
[x] Cadastro de Clientes e Pets: Vínculo Many-to-One entre animais e donos.

[x] Gestão de Serviços: Cadastro de catálogo com preço e duração.

[x] Fluxo de Agendamento: - Busca automática de preços do catálogo.

Status dinâmicos (PENDENTE, COMPLETO, CANCELADO).

Validação de horários.

👨‍💻 Autor
Junior 
Transição de Carreira: Infraestrutura IT -> Backend Java Developer 
[LinkedIn](www.linkedin.com/in/adelso-gomes-de-sá-junior-a87a34196) | [Github](https://github.com/juniorn06)
