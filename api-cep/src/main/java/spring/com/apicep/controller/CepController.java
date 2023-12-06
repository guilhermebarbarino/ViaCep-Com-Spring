package spring.com.apicep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import spring.com.apicep.dto.CepDTO;
import spring.com.apicep.services.CepService;

@RestController
@RequestMapping("/viacep")
public class CepController {

    private final CepService cepService;

    @Autowired
    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping("/consultar/{cep}")
    @Operation(summary = "consultar ceps", description = "buscar endereços via cep", 
	responses = { @ApiResponse(description = "Success", responseCode = "200", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CepDTO.class))) }),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content) })
    public CepDTO consultarCEP(@PathVariable String cep) {
        return cepService.consultarCEP(cep);
    }
}