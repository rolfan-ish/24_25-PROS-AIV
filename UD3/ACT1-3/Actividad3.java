import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad3 {
    public static void main(String[] args) {
        try {
            if (args.length > 0) {
                // Get the IP address of the provided domain
                String domain = args[0];
                InetAddress address = InetAddress.getByName(domain);
                System.out.println("Dirección IP de " + domain + ": " + address.getHostAddress());
            } else {
                // Get and display the local IP address
                InetAddress localAddress = InetAddress.getLocalHost();
                System.out.println("No se proporcionó un dominio.");
                System.out.println("Dirección IP local: " + localAddress.getHostAddress());
            }
        } catch (UnknownHostException e) {
            System.out.println("No se pudo resolver la dirección proporcionada.");
        }
    }
}
