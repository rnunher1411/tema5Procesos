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
public class HttpHandlerCalculadora implements HttpHandler {
    
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        
        URI uri = exchange.getRequestURI();
        
        String op1 = uri.getQuery().substring(4, 5); 
        String op2 = uri.getQuery().substring(10,11);
        String ope =uri.getQuery().substring(16);
        
        double num1 = Double.parseDouble(op1);
        double num2 = Double.parseDouble(op2);
        
        final int codigoRespuesta = 200;
        String contenido = "";
        
        if (ope.equals("suma")) {
            
            ope = "+";
            char oper = ope.charAt(0);
            Calculadora calculadora = new Calculadora(num1, num2, oper);
            contenido = calculadora.getResultado();
            System.out.println("[" + Utilidades.getFechaHoraActualFormateada() + "] Respondiendo a la peticion " + uri );
            
        } else if (ope.equals("resta")) {
            
            ope = "-";
            char oper = ope.charAt(0);
            Calculadora calculadora = new Calculadora(num1, num2, oper);
            contenido = calculadora.getResultado(); 
            System.out.println(Utilidades.getFechaHoraActualFormateada() + "] Respondiendo a la peticion " + uri );
            
        } else if (ope.equals("multiplica")) {
            
            ope = "*";
            char oper = ope.charAt(0);
            Calculadora calculadora = new Calculadora(num1, num2, oper);
            contenido = calculadora.getResultado();    
            System.out.println(Utilidades.getFechaHoraActualFormateada() + "] Respondiendo a la peticion " + uri );
            
        } else if (ope.equals("divide")) {
            
            ope = "/";
            char oper = ope.charAt(0);
            Calculadora calculadora = new Calculadora(num1, num2, oper);
            contenido = calculadora.getResultado();  
            System.out.println(Utilidades.getFechaHoraActualFormateada() + "] Respondiendo a la peticion " + uri );
            
        }
        
        exchange.sendResponseHeaders(codigoRespuesta, contenido.getBytes().length);
        
        OutputStream os = exchange.getResponseBody();
        
        os.write(contenido.getBytes());
        os.close();
        
    }
    
}
