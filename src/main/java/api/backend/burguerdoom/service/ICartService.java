package api.backend.burguerdoom.service;

import api.backend.burguerdoom.controllers.responses.SaveDataResponse;
import api.backend.burguerdoom.repo.model.CartDao;

public interface ICartService {
	
	SaveDataResponse saveCartInDb(CartDao cart);
	CartDao findCartByUser(String correo);

}
