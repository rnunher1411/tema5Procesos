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
public class HttpHandlerCalculadora implements HttpHandler{
    
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        
        URI uri = exchange.getRequestURI();
        
        String op1 = uri.getQuery().substring(4, 5); 
        String op2 = uri.getQuery().substring(10,11);
        String ope =uri.getQuery().substring(16);
        
        final int codigoRespuesta = 200;
        String contenido = /*Utilidades.getFechaHoraActualFormateada() + */op1 + " + " + op2 + " = " + ope;
        
        exchange.sendResponseHeaders(codigoRespuesta, contenido.getBytes().length);
        
        OutputStream os = exchange.getResponseBody();
        
        os.write(contenido.getBytes());
        os.close();
        
    }
    
}
