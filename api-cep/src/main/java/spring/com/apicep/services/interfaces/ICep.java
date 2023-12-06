package spring.com.apicep.services.interfaces;

import spring.com.apicep.dto.CepDTO;

public interface ICep {

	CepDTO consultarCEP(String cep);
}
