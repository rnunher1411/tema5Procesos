package tarea_cliente_servidor_http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

/**
 *
 * @author Ricardo Núñez Hernández
 */
public class HandlerSaludar implements HttpHandler {
    
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        
        //URI uri = new URI("http://localhost:8066/saludar?nombre=xxx&apellido=yyy");
        
        String nombre = "Juan"; 
        String apellido = "Jimenez";
        
        
        final int codigoRespuesta = 200;
        String contenido = "hola " + nombre + " " + apellido;
        
        exchange.sendResponseHeaders(codigoRespuesta, contenido.getBytes().length);
        
        OutputStream os = exchange.getResponseBody();
        
        os.write(contenido.getBytes());
        os.close();
        
    }
    
}
