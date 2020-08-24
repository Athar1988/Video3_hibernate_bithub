package org.projet.metier;

import java.sql.ResultSet;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.projet.util.HibernateUtil;

public class CatalogueMetierImp implements ICatalogueMetier{

	@Override
	public void addProduit(Produit p) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
        session.save(p);
        }catch(Exception e){
        	session.getTransaction().rollback();
        	e.printStackTrace();
        }
        session.getTransaction().commit();
	}

	@Override
	public List<Produit> ListProduit() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query req=session.createQuery("select p from Produit p");
        List<Produit>  prods=req.getResultList();
        session.getTransaction().commit();
        return prods;
	}

	@Override
	public Produit getProduit(Long idProd) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Object o=session.get(Produit.class, idProd);
        if(o==null) throw new RuntimeException("Produit introuvable");
        return (Produit)o;
	}

	@Override
	public List<Produit> getProduitParMC(String mc) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query req=session.createQuery("select p from Produit p where p.designation like :x");
		req.setParameter(":x", "%"+mc+"%");
		List<Produit>  prods=req.getResultList();
        session.getTransaction().commit();
        return prods;
	}

	@Override
	public void deleteProduit(Long idProd) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Object o=session.get(Produit.class, idProd);
        if(o==null) throw new RuntimeException("Produit introuvable");
        session.delete(o);
        session.getTransaction().commit();

	}

	@Override
	public void updateProduit(Produit p) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();	
        session.update(p);
        session.getTransaction().commit();

	}

}
