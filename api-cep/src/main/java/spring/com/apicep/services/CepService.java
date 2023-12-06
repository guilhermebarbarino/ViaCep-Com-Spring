package spring.com.apicep.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.com.apicep.dto.CepDTO;
import spring.com.apicep.services.interfaces.ICep;
import spring.com.apicep.services.interfaces.ICepGateway;

@Service
public class CepService implements ICep {

    private final ICepGateway cepGateway;

    @Autowired
    public CepService(ICepGateway cepGateway) {
        this.cepGateway = cepGateway;
    }

    @Override
    public CepDTO consultarCEP(String cep) {
        String apiUrl = cepGateway.buildApiUrl(cep);
        String jsonResponse = cepGateway.makeApiRequest(apiUrl);
        return cepGateway.parseJsonToDTO(jsonResponse);
    }
}
