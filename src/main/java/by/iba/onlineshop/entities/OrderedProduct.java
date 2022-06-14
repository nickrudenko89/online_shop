package by.iba.onlineshop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import by.iba.onlineshop.entities.ids.OrderedProductId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ordered_products")
@IdClass(OrderedProductId.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderedProduct {

	@Id
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "order_number")
	private Order order;

	@Id
	private String brand;

	@Id
	private String model;

	@Column
	private int amount;

	@Column
	private int price;

}
