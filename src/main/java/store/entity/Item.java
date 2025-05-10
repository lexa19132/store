package store.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class Item {

	@Id
	@SequenceGenerator(name = "item_id_sequence_generator", sequenceName = "item_id_sequence", allocationSize = 50, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_sequence_generator")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", length = 31)
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Embedded
	private Price price;
//	
//	private Blob picture;
//	
//	private BigDecimal rating;	
//	
//	private LocalDate date;
//	
//	private User addedBy;
	
	public Item() {
		
	}

	public Item(Long id, String name, String description, Price price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Item other = (Item) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return String.format("Item [id=%s, name=%s, description=%s, price=%s]", id, name, description, price);
	}
}
