package by.iba.onlineshop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import by.iba.onlineshop.entities.ids.CartItemId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart_items")
@IdClass(CartItemId.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {

	@Id
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cart_id")
	private Cart cart;

	@Id
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@Column(name = "product_amount")
	private int productAmount;

}
