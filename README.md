# ViaCEP Spring Boot Project

Este é um projeto Spring Boot que consome a API do ViaCEP para obter informações sobre um determinado CEP. A aplicação segue uma arquitetura limpa, organizando o código em camadas, e utiliza o Spring Framework para injeção de dependências, facilitando a manutenção e testabilidade.

## Estrutura do Projeto

O projeto está estruturado em várias camadas, seguindo os princípios da arquitetura limpa:

- **Entidades (Entities):** A classe `CepDTO` representa a entidade de domínio que contém as informações do CEP.

- **Casos de Uso (Use Cases):** A interface `ICep` define o caso de uso para consultar o CEP, e a implementação `CepService` contém a lógica de negócios associada, utilizando um gateway externo.

- **Gateways (Interfaces Externas):** A interface `ICepGateway` define a interação com o serviço externo do ViaCEP, e a implementação `ViaCEPGatewayImpl` utiliza o `RestTemplate` para fazer solicitações HTTP à API do ViaCEP.

- **Controladores (Controllers):** O controlador `CepController` recebe as solicitações HTTP relacionadas ao CEP e chama o caso de uso correspondente.

- **Configuração (Configuration):** A classe `AppConfig` fornece uma configuração adicional, como a criação do bean `RestTemplate`.

- **Aplicação (Spring Boot):** A classe `ApiCepApplication` é a classe principal do aplicativo Spring Boot.

## Como Executar

Certifique-se de ter o [Maven](https://maven.apache.org/) instalado. No diretório do projeto, execute o seguinte comando no terminal:

```bash
mvn spring-boot:run
```

O aplicativo será iniciado e estará disponível em [http://localhost:8080](http://localhost:8080).

## Como Testar

Você pode testar o endpoint `/viacep/consultar/{cep}` usando uma ferramenta como o [curl](https://curl.se/) ou um cliente HTTP, como o [Postman](https://www.postman.com/).

Exemplo de solicitação usando curl:

```bash
curl http://localhost:8080/viacep/consultar/01001-000
```

Lembre-se de substituir `01001-000` pelo CEP desejado.

## Configuração do ViaCEP URL

Certifique-se de configurar corretamente a URL do ViaCEP no arquivo `application.properties`. O formato é:

```properties
viacep.url=https://viacep.com.br/ws/
```

## Dependências

Este projeto utiliza o [Spring Boot](https://spring.io/projects/spring-boot) para criar a aplicação, [Jackson](https://github.com/FasterXML/jackson) para manipulação de JSON e [RestTemplate](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html) para fazer solicitações HTTP.

## Contribuição

Se você quiser contribuir para este projeto, sinta-se à vontade para abrir uma issue ou enviar um pull request. Toda contribuição é bem-vinda!



