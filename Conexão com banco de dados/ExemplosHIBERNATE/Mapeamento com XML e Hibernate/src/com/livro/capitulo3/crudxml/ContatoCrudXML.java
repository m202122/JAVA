/*
 * Código-fonte do livro "Programação Java para a Web"
 * Autores: Décio Heinzelmann Luckow <decioluckow@gmail.com>
 *          Alexandre Altair de Melo <alexandremelo.br@gmail.com>
 *
 * ISBN:978-85-7522-238-6
 * http://www.javaparaweb.com.br
 * http://www.novatec.com.br/livros/javaparaweb
 * Editora Novatec, 2010 - todos os direitos reservados
 *
 * LICENÇA: Este arquivo-fonte está sujeito a Atribuição 2.5 Brasil, da licença Creative Commons,
 * que encontra-se disponível no seguinte endereço URI: http://creativecommons.org/licenses/by/2.5/br/
 * Se você não recebeu uma cópia desta licença, e não conseguiu obtê-la pela internet, por favor,
 * envie uma notificação aos seus autores para que eles possam enviá-la para você imediatamente.
 *
 *
 * Source-code of "Programando Java para Web" book
 * Authors: Décio Heinzelmann Luckow <decioluckow@gmail.com>
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
				// Uso da classe HibernateUtil. A partir dela recuperamos uma instância de SessionFactory
				// para usarmos o método openSession que abre uma sessão com o banco.
			transacao = sessao.beginTransaction();
			sessao.save(contato);
				// Método save da sessão, é o método pelo qual o Hibernate realizará a operação de insert
				// no banco. Objeto contato a ser adicionado é passado como parâmetro.
			transacao.commit();
				// Método commit gera a instrução de commit no banco, confirmando a transação.
		} catch (HibernateException e) {
			System.out.println("Não foi possível inserir o contato. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operação de inserção. Mensagem: " + e.getMessage());
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
				// Método update da sessão, é o método pelo qual o Hibernate realizará a operação de update
				// no banco.
			transacao.commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível alterar o contato. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operação de atualização. Mensagem: " + e.getMessage());
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
				// Método delete da sessão, é o método pelo qual o Hibernate realizará a operação de delete
				// no banco.
			transacao.commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível excluir o contato. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operação de exclusão. Mensagem: " + e.getMessage());
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
				// Trabalhamos com uma classe nova chamada Query, responsável por montar consultas no Hibernate
				// usando o padrão HQL. Ao passarmos a instrução SQL para o método, não usamos a tradicional 
				// instrução 'select * from contato', mas from Contato. Isso porque estamos lidando agora com
				// objetos, e não + linhas de resultado de uma consulta. Contato, de 'from Contato', se refere
				// à nossa classe conforme mapeada no XML. O método list() retornará uma lista de objetos consultados.
			transacao.commit();
			return resultado;
		} catch (HibernateException e) {
			System.out.println("Não foi possível selecionar contatos. Erro: " + e.getMessage());
			throw new HibernateException(e);
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operação de consulta. Mensagem: " + e.getMessage());
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
				// Montamos consulta parametrizada no exemplo com base na chave primária da tabela.
			consulta.setInteger("parametro", valor);
				// setInteger possui 2 parâmetros: primeiro é o nome do parâmetro, nomeado propositalmente
				// de parâmetro, enquanto o segundo é o valor a ser pesquisado.
			contato = (Contato) consulta.uniqueResult();
				// uniqueResult() é a maneira de o objeto Query retornar um único objeto.
			transacao.commit();
			return contato;
		} catch (HibernateException e) {
			System.out.println("Não foi possível buscar contato. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operação de buscar. Mensagem: " + e.getMessage());
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
