package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Audit;
import util.HibernateUtil;

public class AuditDAOImpl implements AuditDAO{

	@Override
	public void nuevo(Audit auditoria) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(auditoria);
		t.commit();
		
	}

	@Override
	public Audit getAudit(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		Query q=session.createQuery("from Audit where id = :id");
		q.setParameter("id", id);
		List lista = q.list();
		t.commit();
		session.close();
		if(!lista.isEmpty())
		{
			return (Audit)lista.get(0);
		}
		else
		{
			return null;
		}
	}

	@Override
	public void actualizar(Audit auditoria) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(auditoria);
		t.commit();
		
	}
	
	@Override
	public void eliminar(Audit auditoria)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(auditoria);
		t.commit();
	}

	@Override
	public List<Audit> lista() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Audit").list();
		t.commit();
		return lista;
	}


}