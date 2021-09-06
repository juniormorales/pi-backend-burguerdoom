package api.backend.burguerdoom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import api.backend.burguerdoom.repo.model.CartDao;

public interface CartRepository extends JpaRepository<CartDao, Integer> {
	
	CartDao findByCorreo(String correo);
	
}
