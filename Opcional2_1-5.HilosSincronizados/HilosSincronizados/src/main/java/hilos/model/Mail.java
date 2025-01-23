package hilos.model;


public class Mail {
    // Atributos
    private static int id;
    private String destinatario;
    private String remitente;
    private String asunto;
    private String cuerpoMensaje;

    // Constructor
    public Mail(String destinatario, String remitente, String asunto, String cuerpoMensaje) {
        this.id = id +1;
        this.destinatario = destinatario;
        this.remitente = remitente;
        this.asunto = asunto;
        this.cuerpoMensaje = cuerpoMensaje;
    }

    public int getId() {
        return id;
    }
    public String getDestinatario() {
        return destinatario;
    }

    public String getRemitente() {
        return remitente;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getCuerpoMensaje() {
        return cuerpoMensaje;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public void setCuerpoMensaje(String cuerpoMensaje) {
        this.cuerpoMensaje = cuerpoMensaje;
    }

    // Método toString
    @Override
    public String toString() {
        return "Mail{" +
                "id=" + id +
                ", destinatario='" + destinatario + '\'' +
                ", remitente='" + remitente + '\'' +
                ", asunto='" + asunto + '\'' +
                ", cuerpoMensaje='" + cuerpoMensaje + '\'' +
                '}';
    }
}