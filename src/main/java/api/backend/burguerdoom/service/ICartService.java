package api.backend.burguerdoom.service;

import java.util.List;

import api.backend.burguerdoom.controllers.responses.SaveDataResponse;
import api.backend.burguerdoom.repo.model.CartDao;

public interface ICartService {
	
	SaveDataResponse saveCartInDb(CartDao cart);
	List<CartDao> findCartsByUser(String correo);

}
