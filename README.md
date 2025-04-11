# Sesi-Biblioteca-Java

![GitHub repo size](https://img.shields.io/github/repo-size/JoaoNascimento1802/Sesi-Biblioteca-Java?style=for-the-badge)
![GitHub language count](https://img.shields.io/github/languages/count/JoaoNascimento1802/Sesi-Biblioteca-Java?style=for-the-badge)
![GitHub forks](https://img.shields.io/github/forks/JoaoNascimento1802/Sesi-Biblioteca-Java?style=for-the-badge)
![Bitbucket open issues](https://img.shields.io/bitbucket/issues/JoaoNascimento1802/Sesi-Biblioteca-Java?style=for-the-badge)
![Bitbucket open pull requests](https://img.shields.io/bitbucket/pr-raw/JoaoNascimento1802/Sesi-Biblioteca-Java?style=for-the-badge)

> Projeto Java com Spring Boot para gerenciamento de uma biblioteca. Permite cadastro, consulta e atualização de livros, autores e empréstimos. Utiliza cache para otimização de performance nas buscas.

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

- Java JDK 17 ou superior instalado.
- Maven configurado corretamente.
- MySQL rodando localmente ou remotamente.
- IDE como IntelliJ ou VSCode.

## 🚀 Instalando Sesi-Biblioteca-Java

Para instalar o **Sesi-Biblioteca-Java**, siga estas etapas:

1. Clone o repositório:
   git clone https://github.com/JoaoNascimento1802/Sesi-Biblioteca-Java.git
   cd Sesi-Biblioteca-Java

2. Configure o banco de dados no arquivo `application.properties`:
   spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update

3. Rode o projeto com Maven:
   ./mvnw spring-boot:run

## ☕ Usando Sesi-Biblioteca-Java

Com a aplicação rodando, a API estará disponível em:

http://localhost:8080

Rotas disponíveis:
- GET /livros - Lista todos os livros.
- POST /livros - Cadastra um novo livro.
- PUT /livros/{id} - Atualiza os dados de um livro.
- GET /livros/{id} - Busca um livro com uso de cache.
- POST /emprestimos - Registra um empréstimo de livro.

## 📫 Contribuindo para Sesi-Biblioteca-Java

Para contribuir com **Sesi-Biblioteca-Java**, siga estas etapas:

1. Faça um fork do repositório.
2. Crie uma branch: git checkout -b minha-feature
3. Faça suas alterações: git commit -m 'minha melhoria'
4. Envie para sua branch: git push origin minha-feature
5. Crie um Pull Request.

Mais informações em: https://docs.github.com/pt/pull-requests

## 🤝 Colaboradores

Agradecimentos aos contribuidores do projeto:

João Nascimento  
https://github.com/JoaoNascimento1802

## 📝 Licença

Esse projeto está sob licença. Veja o arquivo LICENSE.md para mais detalhes.
