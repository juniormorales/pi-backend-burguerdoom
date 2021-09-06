package api.backend.burguerdoom.utils;

import api.backend.burguerdoom.controllers.responses.SaveDataResponse;

public class ResponseUtils {
	
	//FORM RESPONSES
	public static SaveDataResponse saveFormOkResponse = builderSaveFormOkResponse();
	public static SaveDataResponse saveFormErrorResponse = builderSaveFormErrorResponse();
	
	//CART RESPONSES
	public static SaveDataResponse saveCartOkResponse = builderSaveCartOkResponse();
	public static SaveDataResponse saveCartErrorResponse = builderSaveCartErrorResponse();
	
	
	private static SaveDataResponse builderSaveFormOkResponse() {
		return SaveDataResponse.builder()
				.status(1)
				.isError(false)
				.description("Formulario registrado correctamente")
				.build();
	}
	
	private static SaveDataResponse builderSaveFormErrorResponse() {
		return SaveDataResponse.builder()
				.status(0)
				.isError(true)
				.description("Ocurrio un error al intentar registrar el formulario")
				.build();
	}
	
	private static SaveDataResponse builderSaveCartOkResponse() {
		return SaveDataResponse.builder()
				.status(1)
				.isError(false)
				.description("SU ORDEN YA HA SIDO REGISTRADA, EN UNOS MOMENTOS LLAMAREMOS AL NUMERO QUE USTED HA REGISTRADO PARA CONFIRMAR SU COMPRA")
				.build();
	}
	
	private static SaveDataResponse builderSaveCartErrorResponse() {
		return SaveDataResponse.builder()
				.status(0)
				.isError(true)
				.description("Ocurrio un error al intentar registrar los datos del carrito")
				.build();
	}
	
	
}
