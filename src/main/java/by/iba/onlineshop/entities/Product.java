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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private int id;

	@Column
	@Enumerated(EnumType.STRING)
	@Getter
	@Setter
	private Category category;

	@Column
	@Enumerated(EnumType.STRING)
	@Getter
	@Setter
	private Subcategory subcategory;

	@Column
	@Getter
	@Setter
	private String brand;

	@Column
	@Getter
	@Setter
	private String model;

	@Column
	@Getter
	@Setter
	private int count;

}
