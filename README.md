
#Projeto TechStartPro

Este projeto foi desenvolvido na linguagem de programação Java 15 com Framework Spring Boot.

#Instalação

Para utilização do projeto, precisa-se fazer o clone deste repositório importando ele para uma IDE de desenvolvimento compatível com o Java. Em seguida fazer a instação de todas as dependências do Maven.
O arquivo csv está localizado na pasta src/main/java/resources/category.csv. Nele encontra-se todos os dados pré-definidos das categorias.


#Testes

Para a elaboração dos testes, precisa-se primeiramente criar um DataBase no mySQL com o nome olistapi. No arquivo src/main/java/resources/application.properties, informar o usuário e a senha do banco de dados, para que possa ser feito a conexão.

Para que seja feito a inserção dos dados do arquivo csv, primeiramente precisa-se fazer a seguinte request: POST => http://localhost:8080/api/feedCategoryData 
Com isto, todos os dados do arquivo csv é inserido no banco de dados.

Para mais detalhes de cada requisição disponível e como realiza-lá, basta apenas entrar no link do swagger http://localhost:8080/swagger-ui.html (*OBS:* O projeto deve estar executando)

#Ambiente utilizado para desenvolvimento do projeto

- Especificações do computador: Acer Aspire F15, Intel I5-7°geração 2.5Ghz, 8Gb RAM, HD 1t.
- Sistema operacional: Windows 10 pro 64bit.
- IDE: IntelliJ IDE Community Edition.
- Bibliotecas: Spring Boot, Swagger, JPA, MySQL Driver.
