package neu.edu.cs5200.ass5.models;

import javax.persistence.*;

@Entity
public class Equipment {
	@Id
	@SequenceGenerator( name = "mySeq", sequenceName = "MY_SEQ", allocationSize = 1, initialValue = 1 )
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="mySeq")
	Integer id;
	String name;
	String brand;
	String description;
	double price;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="towerId")	
	Tower tower;
	
	public Equipment() {
		super();
	}
	/**
	 * @param id
	 * @param name
	 * @param brand
	 * @param description
	 * @param price
	 * @param tower
	 */
	public Equipment(Integer id, String name, String brand, String description,
			double price, Tower tower) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.price = price;
		this.tower = tower;
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
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the tower
	 */
	public Tower getTower() {
		return tower;
	}
	/**
	 * @param tower the tower to set
	 */
	public void setTower(Tower tower) {
		this.tower = tower;
	}
}
