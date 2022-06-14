package by.iba.onlineshop.entities.ids;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartItemId implements Serializable {

	private static final long serialVersionUID = 5964318699530599906L;

	private int cart;

	private int product;

}
