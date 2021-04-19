package desafioGetnet.test.aceitacao;

import desafioGetnet.services.DesafioGetnetService;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static org.apache.http.HttpStatus.*;

public class DesafioGetnetAceitacao {
    DesafioGetnetService desafioGetnetService = new DesafioGetnetService();

    @Before
    public void conectarApi() {
        baseURI = "https://reqres.in/api/";
    }

    @Test
    public void adicionarUsuarioValidandoStatusCode() {
        desafioGetnetService.postUser("users",SC_CREATED);
    }

    @Test
    public void buscarUsuarioPassandoId(){
        desafioGetnetService.getUser("users","2",SC_OK);
    }

    @Test
    public void buscarUsuarioInexistente(){
        desafioGetnetService.getUser("users","23",SC_NOT_FOUND);
    }
}
