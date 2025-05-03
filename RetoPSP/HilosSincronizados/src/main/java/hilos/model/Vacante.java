package hilos.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vacante {

    private static int id;
    private String tittle;
    private String description;
    private String date;
    private String company;


    public static int getId() {
        return id;
    }

}