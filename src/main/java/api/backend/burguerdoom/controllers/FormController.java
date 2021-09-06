package api.backend.burguerdoom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.backend.burguerdoom.controllers.responses.SaveDataResponse;
import api.backend.burguerdoom.repo.model.FormDao;
import api.backend.burguerdoom.service.IFormService;

@RestController
@RequestMapping("/api/form")
public class FormController {

	@Autowired
	IFormService formService;

	@PostMapping
	public ResponseEntity<SaveDataResponse> saveForm(@RequestBody FormDao form) {

		SaveDataResponse response = formService.saveFormInDB(form);

		return !response.getIsError() ? new ResponseEntity<>(response, HttpStatus.OK)
				: new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping
	public ResponseEntity<List<FormDao>> listsForms() {

		List<FormDao> response = formService.listAllForms();

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
