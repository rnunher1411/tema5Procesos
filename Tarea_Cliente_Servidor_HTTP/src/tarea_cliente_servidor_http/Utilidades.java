package tarea_cliente_servidor_http;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Ricardo Núñez Hernández
 */
public class Utilidades {
    
    public static boolean esPrimo(long numero) {
        boolean primo= true;
        long candidatoDivisor= 2;
        while (candidatoDivisor < numero && primo) {
            try {
                Thread.sleep (0, 2);  // Para ralentizar el proceso
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            if (numero % candidatoDivisor == 0) {
                primo= false;
            } else
                candidatoDivisor++;                       
        }        
        return primo;
    }
    
    public static String getFechaHoraActualFormateada() {
        String patronFormato= "dd/MM/yyyy HH:mm:ss:SSS";
        DateTimeFormatter formato= DateTimeFormatter.ofPattern(patronFormato);
        LocalDateTime ahora= LocalDateTime.now();
        return ahora.format(formato);
    }
    
}
