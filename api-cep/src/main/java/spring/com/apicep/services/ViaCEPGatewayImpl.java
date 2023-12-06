package spring.com.apicep.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import spring.com.apicep.dto.CepDTO;
import spring.com.apicep.services.interfaces.ICepGateway;

@Component
public class ViaCEPGatewayImpl implements ICepGateway {


	private final RestTemplate restTemplate;
	
	@Value("${viacep.url}")
	private String viaCEPUrl;

	@Autowired
	public ViaCEPGatewayImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public String buildApiUrl(String cep) {
		return viaCEPUrl + cep + "/json/";
	}

	@Override
	public String makeApiRequest(String apiUrl) {
		return restTemplate.getForObject(apiUrl, String.class);
	}

	@Override
	public CepDTO parseJsonToDTO(String json) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(json);

			CepDTO bffDTO = new CepDTO();
			bffDTO.setCep(jsonNode.get("cep").asText());
			bffDTO.setLogradouro(jsonNode.get("logradouro").asText());
			bffDTO.setComplemento(jsonNode.get("complemento").asText());
			bffDTO.setBairro(jsonNode.get("bairro").asText());
			bffDTO.setLocalidade(jsonNode.get("localidade").asText());
			bffDTO.setUf(jsonNode.get("uf").asText());
			

			return bffDTO;
		} catch (IOException e) {
			throw new RuntimeException("Erro ao processar o JSON do ViaCEP", e);
		}
	}
}
