import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Actividad5 {

    public static void main(String[] args) {
        Actividad5 instance = new Actividad5();
        instance.VisualizarConexion();
    }

    private void VisualizarConexion() {
        try {
            // Create an HttpClient instance
            HttpClient client = HttpClient.newHttpClient();

            // Create an HttpRequest using the builder
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://www.vitoria-gasteiz.com"))
                    .GET()
                    .build();

            // Send the request and get the HttpResponse
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print details 
            System.out.println("Conexión con www.vitoria-gasteiz.com");
            System.out.println("==========================");
            System.out.println("\tMétodo toString(): " + response.toString());
            System.out.println("\tMétodo getStatusCode(): " + response.statusCode());
            System.out.println("\tMétodo getContentType(): " +
                    response.headers().firstValue("Content-Type").orElse("N/A"));
        } catch (Exception e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}

