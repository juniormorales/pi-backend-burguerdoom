package api.backend.burguerdoom.repo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="carrito")
public class CartDao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nombreyapellido;
	
	private String telefono;
	
	@Column(unique = true, nullable=true)
	private String correo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
	private List<ProductoPedidoDao> productos;
	
}
