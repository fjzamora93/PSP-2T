package hilos;

import hilos.model.Mail;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BufferMails {
    // Atributo para almacenar la lista de mails
    private LinkedList<Mail> listaMails;

    // Constructor
    public BufferMails() {
        this.listaMails = new LinkedList<>();
    }

    // Método para agregar un mail a la lista
    public synchronized void agregarMail(Mail mail) {
        listaMails.add(mail);
        System.out.println("Agregado mail " + mail.getDestinatario() + "con ID "+ mail.getId());
    }

    public synchronized Mail consumirMail() {
        if (!listaMails.isEmpty()) {
            Mail mail = listaMails.remove();
            System.out.println("Delicioso... " + mail.getDestinatario() + "con ID " + mail.getId());
            return mail;
        } else {
            System.out.println("Que no hay mails, leches");
            return null;
        }
    }
}

