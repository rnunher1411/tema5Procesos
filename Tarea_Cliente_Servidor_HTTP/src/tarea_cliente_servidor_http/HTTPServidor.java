package tarea_cliente_servidor_http;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 *
 * @author Ricardo Núñez Hernández
 */
public abstract class HTTPServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        final int puerto = 8066;
        HttpServer httpd = HttpServer.create(new InetSocketAddress(puerto), 0);
        
        httpd.createContext("/saludar", new HandlerSaludar());
        httpd.createContext("/calculadora",   new HttpHandlerCalculadora());
        
        httpd.setExecutor(Executors.newCachedThreadPool());
        
        httpd.start();
    }
    
    public abstract void setExecutor​(Executor executor);
}
