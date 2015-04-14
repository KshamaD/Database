package neu.edu.cs5200.ass5.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class Tower {
	@Id
	@SequenceGenerator( name = "mySeq", sequenceName = "MY_SEQ", allocationSize = 1, initialValue = 1 )
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="mySeq")
	Integer id;
	String name;
	double height;
	int sides;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="siteId")
	Site site;
	@OneToMany(mappedBy="tower", cascade=CascadeType.ALL, 
				orphanRemoval=true)
	List<Equipment> equipments;
	
	public Tower() {
		super();
	}
	/**
	 * @param id
	 * @param name
	 * @param height
	 * @param sides
	 * @param site
	 * @param equipments
	 */
	public Tower(Integer id, String name, double height, int sides, Site site,
			List<Equipment> equipments) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.sides = sides;
		this.site = site;
		this.equipments = equipments;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	/**
	 * @return the sides
	 */
	public int getSides() {
		return sides;
	}
	/**
	 * @param sides the sides to set
	 */
	public void setSides(int sides) {
		this.sides = sides;
	}
	/**
	 * @return the site
	 */
	public Site getSite() {
		return site;
	}
	/**
	 * @param site the site to set
	 */
	public void setSite(Site site) {
		this.site = site;
	}
	/**
	 * @return the equipments
	 */
	public List<Equipment> getEquipments() {
		return equipments;
	}
	/**
	 * @param equipments the equipments to set
	 */
	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}
	
}
