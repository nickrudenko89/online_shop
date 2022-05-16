package by.iba.onlineshop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import by.iba.onlineshop.entities.enums.Category;
import by.iba.onlineshop.entities.enums.Subcategory;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "category")
	@Enumerated(EnumType.STRING)
	private Category category;

	@Column(name = "subcategory")
	@Enumerated(EnumType.STRING)
	private Subcategory subcategory;

	@Column(name = "brand")
	private String brand;

	@Column(name = "model")
	private String model;

	@Column(name = "count")
	private int count;

	public Product() {
	}

	public Product(int id, Category category, Subcategory subcategory, String brand, String model, int count) {
		this.id = id;
		this.category = category;
		this.subcategory = subcategory;
		this.brand = brand;
		this.model = model;
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", subcategory=" + subcategory + ", brand=" + brand
				+ ", model=" + model + ", count=" + count + "]";
	}

}
