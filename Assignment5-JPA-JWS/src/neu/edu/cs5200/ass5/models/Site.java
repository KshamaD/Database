package neu.edu.cs5200.ass5.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class Site {
	@Id
	@SequenceGenerator( name = "mySeq", sequenceName = "MY_SEQ", allocationSize = 1, initialValue = 1 )
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="mySeq")
	Integer id; 
	String name;
	double latitude;
	double longitude;
	@OneToMany(mappedBy="site", cascade=CascadeType.ALL, orphanRemoval=true)
	List<Tower> towers;
	
	public Site() {
		super();
	}
	
	/**
	 * @param id
	 * @param name
	 * @param latitude
	 * @param longitude
	 * @param towers
	 */
	public Site(Integer id, String name, double latitude, double longitude,
			List<Tower> towers) {
		super();
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.towers = towers;
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
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the towers
	 */
	public List<Tower> getTowers() {
		return towers;
	}
	/**
	 * @param towers the towers to set
	 */
	public void setTowers(List<Tower> towers) {
		this.towers = towers;
	}
		
}
