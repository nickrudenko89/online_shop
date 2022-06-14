package by.iba.onlineshop.entities.ids;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderedProductId implements Serializable {

	private static final long serialVersionUID = 3691865287564813967L;

	private String order;

	private String brand;

	private String model;

}
