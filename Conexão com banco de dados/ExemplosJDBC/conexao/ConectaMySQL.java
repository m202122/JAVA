/*
 * C�digo-fonte do livro "Programa��o Java para a Web"
 * Autores: D�cio Heinzelmann Luckow <decioluckow@gmail.com>
 *          Alexandre Altair de Melo <alexandremelo.br@gmail.com>
 *
 * ISBN:978-85-7522-238-6
 * http://www.javaparaweb.com.br
 * http://www.novatec.com.br/livros/javaparaweb
 * Editora Novatec, 2010 - todos os direitos reservados
 *
 * LICEN�A: Este arquivo-fonte est� sujeito a Atribui��o 2.5 Brasil, da licen�a Creative Commons,
 * que encontra-se dispon�vel no seguinte endere�o URI: http://creativecommons.org/licenses/by/2.5/br/
 * Se voc� n�o recebeu uma c�pia desta licen�a, e n�o conseguiu obt�-la pela internet, por favor,
 * envie uma notifica��o aos seus autores para que eles possam envi�-la para voc� imediatamente.
 *
 *
 * Source-code of "Programando Java para Web" book
 * Authors: D�cio Heinzelmann Luckow <decioluckow@gmail.com>
 *          Alexandre Altair de Melo <alexandremelo.br@gmail.com>
 *
 * ISBN:978-85-7522-238-6
 * http://www.javaparaweb.com.br
 * http://www.novatec.com.br/livros/javaparaweb
 * Editora Novatec, 2010 - all rights reserved
 *
 * LICENSE: This source file is subject to Attibution version 2.5 Brazil of the Creative Commons
 * license that is available through the following URI:  http://creativecommons.org/licenses/by/2.5/br/
 * If you did not receive a copy of this license and are unable to obtain it through the web, please
 * send a note to the authors so they can mail you a copy immediately.
 *
 */
package com.livro.capitulo3.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaMySQL {

	public static void main(String[] args) {
		Connection conexao = null;
		
		try {
			// Registrando a classe JDBC no sistema em tempo de execu��o
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/agenda";
			String usuario = "root";
			String senha = "admin";

			conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectou!");
		} catch (ClassNotFoundException e) {
			System.out.println("Classe n�o encontrada. Erro: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro de SQL. Erro: " + e.getMessage());
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar a conex�o. Erro: " + e.getMessage());
			} 		
		}
	}
}
