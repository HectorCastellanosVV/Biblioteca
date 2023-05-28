/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import control.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Prestamo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Cliente;
import modelo.Visita;

/**
 *
 * @author Hector
 */
public class ClienteJpaController implements Serializable {

    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) {
        if (cliente.getPrestamoList() == null) {
            cliente.setPrestamoList(new ArrayList<Prestamo>());
        }
        if (cliente.getVisitaList() == null) {
            cliente.setVisitaList(new ArrayList<Visita>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Prestamo> attachedPrestamoList = new ArrayList<Prestamo>();
            for (Prestamo prestamoListPrestamoToAttach : cliente.getPrestamoList()) {
                prestamoListPrestamoToAttach = em.getReference(prestamoListPrestamoToAttach.getClass(), prestamoListPrestamoToAttach.getIdPrestamo());
                attachedPrestamoList.add(prestamoListPrestamoToAttach);
            }
            cliente.setPrestamoList(attachedPrestamoList);
            List<Visita> attachedVisitaList = new ArrayList<Visita>();
            for (Visita visitaListVisitaToAttach : cliente.getVisitaList()) {
                visitaListVisitaToAttach = em.getReference(visitaListVisitaToAttach.getClass(), visitaListVisitaToAttach.getIdVisita());
                attachedVisitaList.add(visitaListVisitaToAttach);
            }
            cliente.setVisitaList(attachedVisitaList);
            em.persist(cliente);
            for (Prestamo prestamoListPrestamo : cliente.getPrestamoList()) {
                Cliente oldIdUsuarioOfPrestamoListPrestamo = prestamoListPrestamo.getIdUsuario();
                prestamoListPrestamo.setIdUsuario(cliente);
                prestamoListPrestamo = em.merge(prestamoListPrestamo);
                if (oldIdUsuarioOfPrestamoListPrestamo != null) {
                    oldIdUsuarioOfPrestamoListPrestamo.getPrestamoList().remove(prestamoListPrestamo);
                    oldIdUsuarioOfPrestamoListPrestamo = em.merge(oldIdUsuarioOfPrestamoListPrestamo);
                }
            }
            for (Visita visitaListVisita : cliente.getVisitaList()) {
                Cliente oldIdUsuarioOfVisitaListVisita = visitaListVisita.getIdUsuario();
                visitaListVisita.setIdUsuario(cliente);
                visitaListVisita = em.merge(visitaListVisita);
                if (oldIdUsuarioOfVisitaListVisita != null) {
                    oldIdUsuarioOfVisitaListVisita.getVisitaList().remove(visitaListVisita);
                    oldIdUsuarioOfVisitaListVisita = em.merge(oldIdUsuarioOfVisitaListVisita);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getIdUsuario());
            List<Prestamo> prestamoListOld = persistentCliente.getPrestamoList();
            List<Prestamo> prestamoListNew = cliente.getPrestamoList();
            List<Visita> visitaListOld = persistentCliente.getVisitaList();
            List<Visita> visitaListNew = cliente.getVisitaList();
            List<Prestamo> attachedPrestamoListNew = new ArrayList<Prestamo>();
            for (Prestamo prestamoListNewPrestamoToAttach : prestamoListNew) {
                prestamoListNewPrestamoToAttach = em.getReference(prestamoListNewPrestamoToAttach.getClass(), prestamoListNewPrestamoToAttach.getIdPrestamo());
                attachedPrestamoListNew.add(prestamoListNewPrestamoToAttach);
            }
            prestamoListNew = attachedPrestamoListNew;
            cliente.setPrestamoList(prestamoListNew);
            List<Visita> attachedVisitaListNew = new ArrayList<Visita>();
            for (Visita visitaListNewVisitaToAttach : visitaListNew) {
                visitaListNewVisitaToAttach = em.getReference(visitaListNewVisitaToAttach.getClass(), visitaListNewVisitaToAttach.getIdVisita());
                attachedVisitaListNew.add(visitaListNewVisitaToAttach);
            }
            visitaListNew = attachedVisitaListNew;
            cliente.setVisitaList(visitaListNew);
            cliente = em.merge(cliente);
            for (Prestamo prestamoListOldPrestamo : prestamoListOld) {
                if (!prestamoListNew.contains(prestamoListOldPrestamo)) {
                    prestamoListOldPrestamo.setIdUsuario(null);
                    prestamoListOldPrestamo = em.merge(prestamoListOldPrestamo);
                }
            }
            for (Prestamo prestamoListNewPrestamo : prestamoListNew) {
                if (!prestamoListOld.contains(prestamoListNewPrestamo)) {
                    Cliente oldIdUsuarioOfPrestamoListNewPrestamo = prestamoListNewPrestamo.getIdUsuario();
                    prestamoListNewPrestamo.setIdUsuario(cliente);
                    prestamoListNewPrestamo = em.merge(prestamoListNewPrestamo);
                    if (oldIdUsuarioOfPrestamoListNewPrestamo != null && !oldIdUsuarioOfPrestamoListNewPrestamo.equals(cliente)) {
                        oldIdUsuarioOfPrestamoListNewPrestamo.getPrestamoList().remove(prestamoListNewPrestamo);
                        oldIdUsuarioOfPrestamoListNewPrestamo = em.merge(oldIdUsuarioOfPrestamoListNewPrestamo);
                    }
                }
            }
            for (Visita visitaListOldVisita : visitaListOld) {
                if (!visitaListNew.contains(visitaListOldVisita)) {
                    visitaListOldVisita.setIdUsuario(null);
                    visitaListOldVisita = em.merge(visitaListOldVisita);
                }
            }
            for (Visita visitaListNewVisita : visitaListNew) {
                if (!visitaListOld.contains(visitaListNewVisita)) {
                    Cliente oldIdUsuarioOfVisitaListNewVisita = visitaListNewVisita.getIdUsuario();
                    visitaListNewVisita.setIdUsuario(cliente);
                    visitaListNewVisita = em.merge(visitaListNewVisita);
                    if (oldIdUsuarioOfVisitaListNewVisita != null && !oldIdUsuarioOfVisitaListNewVisita.equals(cliente)) {
                        oldIdUsuarioOfVisitaListNewVisita.getVisitaList().remove(visitaListNewVisita);
                        oldIdUsuarioOfVisitaListNewVisita = em.merge(oldIdUsuarioOfVisitaListNewVisita);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cliente.getIdUsuario();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getIdUsuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            List<Prestamo> prestamoList = cliente.getPrestamoList();
            for (Prestamo prestamoListPrestamo : prestamoList) {
                prestamoListPrestamo.setIdUsuario(null);
                prestamoListPrestamo = em.merge(prestamoListPrestamo);
            }
            List<Visita> visitaList = cliente.getVisitaList();
            for (Visita visitaListVisita : visitaList) {
                visitaListVisita.setIdUsuario(null);
                visitaListVisita = em.merge(visitaListVisita);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cliente findCliente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
