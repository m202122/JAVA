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

package com.livro.capitulo3.crudxml;

import java.sql.Date;
import java.util.List;
import org.hibernate.*;
import com.livro.capitulo3.conexao.HibernateUtil;

public class ContatoCrudXML {

	public void salvar(Contato contato) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession(); 
				// Uso da classe HibernateUtil. A partir dela recuperamos uma inst�ncia de SessionFactory
				// para usarmos o m�todo openSession que abre uma sess�o com o banco.
			transacao = sessao.beginTransaction();
			sessao.save(contato);
				// M�todo save da sess�o, � o m�todo pelo qual o Hibernate realizar� a opera��o de insert
				// no banco. Objeto contato a ser adicionado � passado como par�metro.
			transacao.commit();
				// M�todo commit gera a instru��o de commit no banco, confirmando a transa��o.
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel inserir o contato. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar opera��o de inser��o. Mensagem: " + e.getMessage());
			}
		}
	}

	public void atualizar(Contato contato) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(contato);
				// M�todo update da sess�o, � o m�todo pelo qual o Hibernate realizar� a opera��o de update
				// no banco.
			transacao.commit();
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel alterar o contato. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar opera��o de atualiza��o. Mensagem: " + e.getMessage());
			}
		}
	}

	public void excluir(Contato contato) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(contato);
				// M�todo delete da sess�o, � o m�todo pelo qual o Hibernate realizar� a opera��o de delete
				// no banco.
			transacao.commit();
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel excluir o contato. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar opera��o de exclus�o. Mensagem: " + e.getMessage());
			}
		}
	}

	public List<Contato> listar() {
		Session sessao = null;
		Transaction transacao = null;
		Query consulta = null;
		List<Contato> resultado = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			consulta = sessao.createQuery("from Contato");
			resultado = consulta.list();
				// Trabalhamos com uma classe nova chamada Query, respons�vel por montar consultas no Hibernate
				// usando o padr�o HQL. Ao passarmos a instru��o SQL para o m�todo, n�o usamos a tradicional 
				// instru��o 'select * from contato', mas from Contato. Isso porque estamos lidando agora com
				// objetos, e n�o + linhas de resultado de uma consulta. Contato, de 'from Contato', se refere
				// � nossa classe conforme mapeada no XML. O m�todo list() retornar� uma lista de objetos consultados.
			transacao.commit();
			return resultado;
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel selecionar contatos. Erro: " + e.getMessage());
			throw new HibernateException(e);
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar opera��o de consulta. Mensagem: " + e.getMessage());
			}
		}
	}

	public Contato buscaContato(int valor) {
		Contato contato = null;
		Session sessao = null;
		Transaction transacao = null;
		Query consulta = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			consulta = sessao.createQuery("from Contato where codigo = :parametro");
				// Montamos consulta parametrizada no exemplo com base na chave prim�ria da tabela.
			consulta.setInteger("parametro", valor);
				// setInteger possui 2 par�metros: primeiro � o nome do par�metro, nomeado propositalmente
				// de par�metro, enquanto o segundo � o valor a ser pesquisado.
			contato = (Contato) consulta.uniqueResult();
				// uniqueResult() � a maneira de o objeto Query retornar um �nico objeto.
			transacao.commit();
			return contato;
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel buscar contato. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar opera��o de buscar. Mensagem: " + e.getMessage());
			}
		}
		return contato;
	}

	public static void main(String[] args) {
		ContatoCrudXML contatoCrudXML = new ContatoCrudXML();
		String[] nomes = {"Fulano", "Beltrano", "Ciclano"};
		String[] fones = {"(47) 2222-1111", "(47) 7777-5555", "(47) 9090-2525"};
		String[] emails = {"fulano@teste.com.br", "beltrano@teste.com.br", "ciclano@teste.com.br"};
		String[] observacoes = {"Novo cliente", "Cliente em dia", "Ligar na quinta"};
		Contato contato = null;
		
		for (int i = 0; i < nomes.length; i++) {
			contato = new Contato();
			contato.setNome(nomes[i]);
			contato.setTelefone(fones[i]);
			contato.setEmail(emails[i]);
			contato.setDataCadastro(new Date(System.currentTimeMillis()));
			contato.setObservacao(observacoes[i]);
			contatoCrudXML.salvar(contato);
		}
		System.out.println("Total de registros cadastrados: " + contatoCrudXML.listar().size());
	}
}
