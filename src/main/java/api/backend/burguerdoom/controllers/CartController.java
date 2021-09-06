package api.backend.burguerdoom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.backend.burguerdoom.controllers.responses.SaveDataResponse;
import api.backend.burguerdoom.repo.model.CartDao;
import api.backend.burguerdoom.service.ICartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	
	@Autowired
	ICartService cartService;
	
	@PostMapping("/save")
	public ResponseEntity<SaveDataResponse> saveDataCart(@RequestBody CartDao cart) {
		SaveDataResponse response = cartService.saveCartInDb(cart);

		return response.getIsError() ? new ResponseEntity<>(response, HttpStatus.OK)
				: new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/byUser")
	public ResponseEntity<List<CartDao>> findCartByUser(@RequestParam String correo){
		try {
			List<CartDao> cart = cartService.findCartsByUser(correo);
			return new ResponseEntity<>(cart,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
