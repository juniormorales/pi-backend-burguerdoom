package api.backend.burguerdoom.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import api.backend.burguerdoom.repo.model.CartDao;

public interface CartRepository extends JpaRepository<CartDao, Integer> {
	
	List<CartDao> findByCorreo(String correo);
	
}
