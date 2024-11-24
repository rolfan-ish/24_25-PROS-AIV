import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad1 {
    public static void main(String[] args) {
        String domain = "www.spotify.com";
        
        try {
            // Get all IP addresses associated with the domain
            InetAddress[] addresses = InetAddress.getAllByName(domain);
            
            System.out.println("Direcciones asociadas a Spotify:");
            
            // Print each address
            for (InetAddress address : addresses) {
                System.out.println(address);
            }
        } catch (UnknownHostException e) {
            System.out.println("No se pudieron obtener las direcciones asociadas al dominio: " + domain);
        }
    }
}
