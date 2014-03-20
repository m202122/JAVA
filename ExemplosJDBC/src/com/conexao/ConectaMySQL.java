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
			String url = "jdbc:mysql://localhost/agenda"; // agenda corresponde ao schema agenda presenta dentro do mysql 
			String usuario = "root";
			String senha = "admin";
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
