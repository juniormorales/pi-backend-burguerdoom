package api.backend.burguerdoom.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.backend.burguerdoom.controllers.responses.SaveDataResponse;
import api.backend.burguerdoom.repo.CartRepository;
import api.backend.burguerdoom.repo.ProductoPedidoRepository;
import api.backend.burguerdoom.repo.model.CartDao;
import api.backend.burguerdoom.service.ICartService;
import api.backend.burguerdoom.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CartServiceImpl implements ICartService {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	ProductoPedidoRepository productoPedidoRepository;
	
	@Override
	public SaveDataResponse saveCartInDb(CartDao cart) {
		try {
			cart.setFecha(LocalDateTime.now());
			CartDao cartsave = cartRepository.save(cart);
			if(Objects.nonNull(cartsave)) {
				cart.getProductos().forEach(producto -> {
					producto.setCart(cartsave);
					productoPedidoRepository.save(producto);
				});
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
	public List<CartDao> findCartsByUser(String correo) {
		try {
			List<CartDao> carts = cartRepository.findByCorreo(correo);
			carts.forEach(carrito -> {
				carrito.setProductos(productoPedidoRepository.findByCart(carrito));
			});
			return carts;
		} catch (Exception e) {
			log.error("Error in CartServiceImpl - findCartByUser, line: {}, error: {}",e.getStackTrace()[0].getLineNumber(), e.getMessage());
			throw e;
		}
	}

}
