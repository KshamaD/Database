package neu.edu.cs5200.ass5.dao;

import java.util.*;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import neu.edu.cs5200.ass5.models.Site;

@Path("/site")
public class SiteDao {
	public EntityManagerFactory factory = 
			Persistence.createEntityManagerFactory("Assignment5");
	public EntityManager em = null;
	
	//inserts a new site record into the database and then 
	//returns a list of all the sites
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> createSite(Site site) {
		em = factory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(site);
		em.getTransaction().commit();
		em.close();
		
		List<Site> sites = findAllSites();
		return sites;
	}
	
	// returns an instance of Site representing 
    // a record whose id is siteId
	@GET
	@Path("/{ID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Site findSite(@PathParam("ID") int siteId) {
		em = factory.createEntityManager();
		Site site = em.find(Site.class, siteId);
		em.close();
		return site;
	}
	
	// returns a list of Site instances
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> findAllSites() {
		
		em = factory.createEntityManager();
		Query query = em.createQuery("select site from Site site");
		List<Site> sites = (List<Site>)query.getResultList();
		em.close();
		/*
		List<Site> sites = new ArrayList<Site>();
		Site site1 = new Site(1,"site 1", 111.11,222.22,null);
		Site site2 = new Site(2,"site 2", 111.11,222.22,null);
		Site site3 = new Site(3,"site 3", 111.11,222.22,null);
		sites.add(site1);
		sites.add(site2);
		sites.add(site3);
		*/
		return sites;
	}
	
	// updates the site record whose id is siteId 
	// and then returns all the sites
	@PUT
	@Path("/{ID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> updateSite(@PathParam("ID") int siteId, Site site)
	{
		em = factory.createEntityManager();
		em.getTransaction().begin();
		site.setId(siteId);
		em.merge(site); // merge via id
		em.getTransaction().commit();
		em.close();
		
		List<Site> sites = findAllSites();
		return sites;
	}
	
	//removes a site record whose id is siteId 
	//and the returns a list of all the sites
	@DELETE
	@Path("/{ID}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> removeSite(@PathParam("ID") Integer siteId){
		em = factory.createEntityManager();
		
		em.getTransaction().begin();
		Site Site = em.find(Site.class, siteId);
		em.remove(Site);
		em.getTransaction().commit();
		em.close();
		
		List<Site> sites = findAllSites();
		return sites;
	}
}
