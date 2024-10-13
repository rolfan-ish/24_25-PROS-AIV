import java.io.*;

public class Actividad11 {
    public static void main(String[] args) {
        try {
            // For Windows: use CMD command
            String os = System.getProperty("os.name").toLowerCase();
            String comando = "";
            if (os.contains("win")) {
                comando = "CMD /C DIR";
            } else {
                // For Linux or macOS: use ls command
                comando = "ls -al";
            }

            String[] command = {"java", "Ejemplo2", comando};
            Process process = Runtime.getRuntime().exec(command);

            InputStream is = process.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();

            int exitCode = process.waitFor();
            System.out.println("Finished with exit code: " + exitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

