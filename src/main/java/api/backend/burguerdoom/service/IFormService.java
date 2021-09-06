package api.backend.burguerdoom.service;

import java.util.List;

import api.backend.burguerdoom.controllers.responses.SaveDataResponse;
import api.backend.burguerdoom.repo.model.FormDao;

public interface IFormService {
	
	SaveDataResponse saveFormInDB(FormDao form);
	List<FormDao> listAllForms();
}
