import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad2 {
    public static void main(String[] args) {
        // Check if an address was provided as an argument
        if (args.length == 0) {
            System.out.println("Uso: java Actividad2 <direccion>");
            return;
        }

        String address = args[0];

        try {
            // Get all IP addresses associated with the provided address
            InetAddress[] addresses = InetAddress.getAllByName(address);

            System.out.println("Direcciones asociadas a " + address + ":");

            // Print each address
            for (InetAddress addr : addresses) {
                System.out.println(addr);
            }
        } catch (UnknownHostException e) {
            System.out.println("No se pudieron obtener las direcciones asociadas al dominio o dirección: " + address);
        }
    }
}
