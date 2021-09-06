package api.backend.burguerdoom.repo.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name="carrito")
public class CartDao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nombreyapellido;
	
	@Column(nullable=false)
	private String telefono;
	
	@Column(nullable=false)
	private String direccion;
	
	@Column(unique = true, nullable=true)
	private String correo;
	
	private LocalDateTime fecha;
	
	@Transient
	private List<ProductoPedidoDao> productos;
	
}
