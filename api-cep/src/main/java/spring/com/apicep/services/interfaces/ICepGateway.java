package spring.com.apicep.services.interfaces;

import spring.com.apicep.dto.CepDTO;

public interface ICepGateway {

	String buildApiUrl(String cep);
    String makeApiRequest(String apiUrl);
    CepDTO parseJsonToDTO(String json);
}
