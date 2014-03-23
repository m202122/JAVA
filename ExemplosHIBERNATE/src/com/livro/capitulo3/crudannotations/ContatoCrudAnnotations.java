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

package com.livro.capitulo3.crudannotations;

import java.sql.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.livro.capitulo3.conexao.HibernateUtil;

public class ContatoCrudAnnotations {

	public void salvar(ContatoAnnotations contato) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(contato);
			transacao.commit();
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

	public void atualizar(ContatoAnnotations contato) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(contato);
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

	public void excluir(ContatoAnnotations contato) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(contato);
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

	public List<ContatoAnnotations> listar() {
		Session sessao = null;
		Transaction transacao = null;
		Query consulta = null;
		List<ContatoAnnotations> resultado = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			consulta = sessao.createQuery("from ContatoAnnotations");
			resultado = consulta.list();
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
	
	public ContatoAnnotations buscaContato(int valor) {
		ContatoAnnotations contato = null;
		Session sessao = null;
		Transaction transacao = null;
		Query consulta = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			consulta = sessao.createQuery("from Contato where codigo = :parametro");
			consulta.setInteger("parametro", valor);
			contato = (ContatoAnnotations) consulta.uniqueResult();
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
		ContatoCrudAnnotations contatoCrudAnnotations = new ContatoCrudAnnotations();
		String[] nomes = {"Solanu", "Lunare", "Venusiana"};
		String[] fones = {"(47) 3333-4444", "(47) 7777-5555", "(47) 9090-2525"};
		String[] emails = {"solanu@javapro.com.br", "lunare@javapro.com.br", "venusiana@javapro.com.br"};
		String[] observacoes = {"Novo cliente", "Cliente em dia", "Ligar na sexta"};
		ContatoAnnotations contatoAnnotations = null;
		
		for (int i = 0; i < nomes.length; i++) {
			contatoAnnotations = new ContatoAnnotations();
			contatoAnnotations.setNome(nomes[i]);
			contatoAnnotations.setTelefone(fones[i]);
			contatoAnnotations.setEmail(emails[i]);
			contatoAnnotations.setDataCadastro(new Date(System.currentTimeMillis()));
			contatoAnnotations.setObservacao(observacoes[i]);
			contatoCrudAnnotations.salvar(contatoAnnotations);
		}
		System.out.println("Total de registros cadastrados: " + contatoCrudAnnotations.listar().size());
	}
}
