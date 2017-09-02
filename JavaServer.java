import java.io.*;
import java.net.*;
import java.util.concurrent.TimeUnit;

class JavaServer {
    public static void main(String args[]) throws Exception {
        String fromClient;
        String toClient;
 
        ServerSocket server = new ServerSocket(8080);
        System.out.println("\nEsperando conexión con el puerto 8080...\n");
 
        boolean run = true;
        while(run) {
            Socket client = server.accept();
            System.out.println("Establecida conexión con el puerto 8080\n");
            
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(),true);
 
            fromClient = in.readLine();
            System.out.println("Recibido: " + fromClient + "\n");
            TimeUnit.SECONDS.sleep(2); 
            if(fromClient.equals("Hola")) {
                toClient = "aloH";
                System.out.println("Enviado aloH\n");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Esperando respuesta...\n");
                TimeUnit.SECONDS.sleep(2);
                out.println(toClient);
                fromClient = in.readLine();
                System.out.println("Recibido: " + fromClient + "\n");
                TimeUnit.SECONDS.sleep(2);

                if(fromClient.equals("Adiós")) {
                    toClient = "sóidA";
                    System.out.println("Enviado sóidA\n");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("Esperando respuesta...\n");
                    TimeUnit.SECONDS.sleep(2);
                    out.println(toClient);
                    client.close();
                    run = false;
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("Socket cerrado\n");
                }
            }
        }
        System.exit(0);
    }
}