package server;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.*;
import java.net.Socket;



@Getter
@Setter
public class ClientCommunication {
    private Socket clientSocket;

    private InputStream entrada;
    private OutputStream salida;

    private BufferedReader reader;
    private PrintWriter writer;


    public ClientCommunication(Socket cliente) throws IOException {
        this.clientSocket = cliente;
        this.entrada = this.clientSocket.getInputStream();
        this.salida = this.clientSocket.getOutputStream();

        this.reader = new BufferedReader(new InputStreamReader(this.entrada));
        this.writer = new PrintWriter(new OutputStreamWriter(salida), true);
    }

    public String readRequest() throws IOException {
        return reader.readLine();
    }


    public void sendResponse(String response) {
        System.out.println("Respuesta del servidor" + response);
        writer.println(response);
    }

    public void close() throws IOException {
        reader.close();
        writer.close();
    }
}
