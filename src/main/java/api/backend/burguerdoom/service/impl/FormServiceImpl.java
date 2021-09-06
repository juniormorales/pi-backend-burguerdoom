package api.backend.burguerdoom.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.backend.burguerdoom.controllers.responses.SaveDataResponse;
import api.backend.burguerdoom.repo.FormRepository;
import api.backend.burguerdoom.repo.model.FormDao;
import api.backend.burguerdoom.service.IFormService;
import api.backend.burguerdoom.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FormServiceImpl implements IFormService {
	
	@Autowired
	FormRepository formRepository;

	@Override
	public SaveDataResponse saveFormInDB(FormDao form) {
		try {
			if(Objects.nonNull(formRepository.save(form))) {
				return ResponseUtils.saveFormOkResponse;
			}else {
				return ResponseUtils.saveFormErrorResponse;
			}
		} catch (Exception e) {
			log.error("Error in FormServiceImpl, line: {}, error: {}",e.getStackTrace()[0].getLineNumber(), e.getMessage());
			return ResponseUtils.saveFormErrorResponse;
		}
	}

	@Override
	public List<FormDao> listAllForms() {
		return formRepository.findAll();
	}

}
