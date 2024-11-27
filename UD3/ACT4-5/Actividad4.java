import java.net.URI;

public class Actividad4 {

    public static void main(String[] args) {
        // Declare the URIs
        URI uri1 = URI.create("http://docs.oracle.com");
        URI uri2 = URI.create("http://docs.oracle.com/javase/7");
        URI uri3 = URI.create("http://docs.oracle.com/javase/7/docs/api/java/net/URL.html");

        // Call Visualizar method for each URI
        Actividad4 instance = new Actividad4();
        instance.Visualizar(uri1);
        instance.Visualizar(uri2);
        instance.Visualizar(uri3);
    }

    // Private method to display URI details
    private void Visualizar(URI uri) {
        System.out.println("URI: " + uri.toString());
        System.out.println("\tHost: " + uri.getHost());
        System.out.println("\tPort: " + uri.getPort());
        System.out.println("\tPath: " + uri.getPath());
        System.out.println("\tScheme: " + uri.getScheme());
        System.out.println("\tAuthority: " + uri.getAuthority());
    }
}
