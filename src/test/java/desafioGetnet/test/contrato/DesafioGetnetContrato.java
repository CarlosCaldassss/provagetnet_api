package desafioGetnet.test.contrato;

import desafioGetnet.services.DesafioGetnetService;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static org.apache.http.HttpStatus.*;

public class DesafioGetnetContrato {
    DesafioGetnetService desafioGetnetService = new DesafioGetnetService();


    @Before
    public void conectarApi() {
        baseURI = "https://reqres.in/api/";
    }

    @Test
    public void validarContratoUser(){
        desafioGetnetService.validarContratoUser("users","2",SC_OK);
    }
}
