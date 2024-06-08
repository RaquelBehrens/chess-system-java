package aplicacao;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		/*
		// Inserir pessoas
		Pessoa p1 = new Pessoa(null, "Fulano", "fulano@gmail.com");
		Pessoa p2 = new Pessoa(null, "Ciclano", "ciclano@gmail.com");
		Pessoa p3 = new Pessoa(null, "Beltrano", "beltrano@gmail.com");
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		*/
		
		/*
		// Encontrar pessoa
		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p);
		*/
		
		/* 
		 * Entidade monitorada
		 * só pode remover entidades monitoradas
		 */
		
		// Remove pessoa
		Pessoa p = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		
		System.out.println("Pronto!");		
		em.close();
		emf.close();
	}

}
