package buoi3;

import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name="MobilePhone")
public class Phone{
	@Id
	@Getter
	@Setter
	private String id;
	
	@Column(nullable = false, length = 128)
	@Getter
	@Setter
	private String name;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private int price;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String color;
	
	@Column
	@Getter
	@Setter
	private String country;
	
	@Column
	@Getter
	@Setter
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="manu_id")
	private Manufactory manuID;

	
	public Phone() {
		super();
	}
	
	public Phone(String id, String name, int price, String color, String country, int quantity, Manufactory manuID) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.color = color;
		this.country = country;
		this.quantity = quantity;
		this.manuID = manuID;
	}
	
	public String toString() {
		return "["+id+", "+name+", "+price+", "+color+", "+country+", "+quantity+"]";
	}
	
	
}
