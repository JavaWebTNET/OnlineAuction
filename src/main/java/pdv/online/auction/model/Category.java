package pdv.online.auction.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@Size(min = 5, max = 30, message = "Category Name must be between 5 and 30 characters long.")
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "Category Name must be alphabetic with any spaces")
	private String name;
	
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "Description must be alphabetic with any spaces")
	private String description;
	
	@ManyToOne
	private Category superCate;
	
	@OneToMany(mappedBy="superCate", fetch = FetchType.EAGER)
	private List<Category> subCate;
	
	public Category(){
		super();
	}
	
	public Category(int id){
		this.id = id;
	}
	
	public Category(int id, String name){
		this(id);
		this.name = name;
	}

	public Category(int id, String name, String description, Category superCate) {
		this(id,name);		
		this.description = description;
		this.superCate = superCate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Category getSuperCate() {
		return superCate;
	}

	public void setSuperCate(Category superCate) {
		this.superCate = superCate;
	}

	public List<Category> getSubCate() {
		return subCate;
	}

	public void setSubCate(List<Category> subCate) {
		this.subCate = subCate;
	}
		
}
