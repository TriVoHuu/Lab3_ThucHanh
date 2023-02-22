package buoi3;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name="Manufactory")
public class Manufactory {
	@Id
	private String manu_id;
	@Column(length = 128)
	@Getter
	@Setter
	private String name;
	@Column
	@Getter
	@Setter
	private String location;
	@Column
	@Getter
	@Setter
	private int employee;
	@OneToMany(mappedBy = "manuID")
	private List<Phone> phones;

	
	public Manufactory() {
		super();
	}
	
	public Manufactory(String manu_id, String name, String location, int employee) {
		this.manu_id = manu_id;
		this.name = name;
		this.location = location;
		this.employee = employee;
	}
	
	public String toString() {
		return "["+manu_id+", "+name+", "+location+", "+employee+"]";
	}
}
