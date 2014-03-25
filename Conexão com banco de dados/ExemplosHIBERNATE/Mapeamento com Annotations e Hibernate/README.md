HIBERNATE & ANNOTATIONS
=======================

Assim como o JDBC, Hibernate é usado para realizar operações e comunicação com um banco de dados, porém, de maneira mais padronizada.

- Pasta 'lib': contém as bibliotecas para execução do exemplo. As bibliotecas devem ser adicionadas no projeto do Eclipse.

- src/hibernate.cfg.xml: deve estar no package-raiz das fontes do projeto. Sua configuração e explicação pode ser encontrado dentro do arquivo.

- /src/com/livro/capitulo3/conexao/HibernateUtil.java: código-fonte que faz a ponte entre o arquivo de configuração e a conexão com o banco. Responsável por instanciar SessionFactory do Hibernate e retorná-lo quando solicitado. Método buildSessionFactory() é o responsável por criar uma SessionFactory com base no arquivo XML. O código-fonte de buildSessionFactory() é o responsável por configurar o Hibernate e retornar uma SessionFactory. Quando executamos o comando new Configuration(), o Hibernate procura pelo arquivo hibernate.properties no package-raiz.
