package api.backend.burguerdoom.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.backend.burguerdoom.controllers.responses.SaveDataResponse;
import api.backend.burguerdoom.repo.CartRepository;
import api.backend.burguerdoom.repo.model.CartDao;
import api.backend.burguerdoom.service.ICartService;
import api.backend.burguerdoom.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CartServiceImpl implements ICartService {
	
	@Autowired
	CartRepository cartRepository;
	
	@Override
	public SaveDataResponse saveCartInDb(CartDao cart) {
		try {
			if(Objects.nonNull(cartRepository.save(cart))) {
				return ResponseUtils.saveCartOkResponse;
			}else {
				return ResponseUtils.saveCartErrorResponse;
			}
		} catch (Exception e) {
			log.error("Error in CartServiceImpl - saveCartInDb, line: {}, error: {}",e.getStackTrace()[0].getLineNumber(), e.getMessage());
			return ResponseUtils.saveCartErrorResponse;
		}
	}

	@Override
	public CartDao findCartByUser(String correo) {
		try {
			return cartRepository.findByCorreo(correo);
		} catch (Exception e) {
			log.error("Error in CartServiceImpl - findCartByUser, line: {}, error: {}",e.getStackTrace()[0].getLineNumber(), e.getMessage());
			throw e;
		}
	}

}
