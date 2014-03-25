JDBC
====
JDBC é usado para realizar operações e comunicação com um banco de dados.

- banco.sql - Tabela do banco de dados usada como exemplo
- lib/mysql-connector-java-5.1.7-bin.jar - Driver necessário para executar os arquivos;
- conexao/ConectaMySQL.java - Exemplo de conexão com banco de dados MySQL;
- crudjdbc/Contato.java - Classe que representa a tabela 'contato' do banco de dados como um objeto, mapeando todas as colunas da tabela nas respectivas propriedades;
- crudjbdc/ContatoCrudJDBC.java - Classe responsável por fazer as operações de SQL(insert, delete, update, select) na tabela contato. Não foi usado o conceito do padrão MVC de separação de responsabilidades para realizar as operações.
