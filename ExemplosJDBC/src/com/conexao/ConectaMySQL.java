package com.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaMySQL {
	
	public static void main(String[] args) 
	{
		
		Connection conexao = null;
		
		try {
			// Registrando a classe jdbc no sistema em tempo de execução
			String url = "jdbc:mysql://localhost/agenda"; // agenda corresponde ao schema agenda presente dentro do MySql 
			String usuario = "root"; // Usuário do MySQL
			String senha = "admin"; // Senha do usuário do MySQL
			conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectou!");
		} catch(SQLException e) {
			System.out.println("Ocorreu um erro de SQL. Erro: "+e.getMessage());
		} finally {
			try {
				conexao.close();
			} catch(SQLException e) {
				System.out.println("Erro ao fechar a conexão. Erro: "+e.getMessage());
			}
		}
	}
}
