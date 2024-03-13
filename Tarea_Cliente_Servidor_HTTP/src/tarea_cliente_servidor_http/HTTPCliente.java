package tarea_cliente_servidor_http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Ricardo Núñez Hernández
 */
public class HTTPCliente {
    
    public static void main(String[] args) {
        
        
        System.out.println("CLIENTE HTTP");
        System.out.println("-------------");
        System.out.println("Cliente HTTP del profe");
        final String DIRECCION_WEB = "http://www.iesaguadulce.es/centro/index.php/oferta-formativa/formacion-profesional-a-distancia/dam-modalidad-distancia";
        
        try {
            
            URL url = new URL(DIRECCION_WEB);
            
            HttpURLConnection.setFollowRedirects(false);
            HttpURLConnection conexion = (HttpURLConnection) 
                    url.openConnection();
            
            System.out.println("Conectandose a la URL http://" + url.getHost() + url.getPath());
            
            conexion.setRequestMethod("HEAD");
            System.out.println("");
            
            if ((conexion.getResponseCode() == HttpURLConnection.HTTP_OK) == true) {
                
            System.out.printf("Respuesta: %b OK \n", 
                conexion.getResponseCode() == HttpURLConnection.HTTP_OK);
            
            System.out.println("");
            
            conexion.getRequestMethod();
            
            } else {
                
                System.out.println("Error. URL no valida");
            }
                
   
        }catch (IOException e) {
            
            System.out.println("Error");
            
        }
        
    }
    
}
