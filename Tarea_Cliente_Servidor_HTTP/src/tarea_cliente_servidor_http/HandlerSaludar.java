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
        
        URI uri = exchange.getRequestURI();
        
        String nombre = uri.getQuery().substring(7, 11); 
        String apellido = uri.getQuery().substring(21);
        
        
        final int codigoRespuesta = 200;
        String contenido = "";
        
        if (!nombre.isBlank() && !apellido.isBlank()) {
            
            contenido = "hola " + nombre + " " + apellido;
            System.out.println("[" + Utilidades.getFechaHoraActualFormateada() + "] Respondiendo a la peticion " + uri);
        
        } else {
            
            contenido = "hola persona no identificada";
            System.out.println("[" + Utilidades.getFechaHoraActualFormateada() + "] Respondiendo a la peticion " + uri);
        
        }
        
        exchange.sendResponseHeaders(codigoRespuesta, contenido.getBytes().length);
        
        OutputStream os = exchange.getResponseBody();
        
        os.write(contenido.getBytes());
        os.close();
        
    }
    
}
