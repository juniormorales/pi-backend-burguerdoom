package api.backend.burguerdoom.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import api.backend.burguerdoom.repo.model.CartDao;
import api.backend.burguerdoom.repo.model.ProductoPedidoDao;

public interface ProductoPedidoRepository extends JpaRepository<ProductoPedidoDao, Integer>{
	
	List<ProductoPedidoDao> findByCart(CartDao cart);
}
