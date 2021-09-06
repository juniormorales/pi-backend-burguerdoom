package api.backend.burguerdoom.controllers.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Builder
@AllArgsConstructor
@Data
public class SaveDataResponse {
	
	private Integer status;
	private String description;
	private Boolean isError;
}
