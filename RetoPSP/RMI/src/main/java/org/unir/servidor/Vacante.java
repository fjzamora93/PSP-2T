package org.unir.servidor;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vacante {
    private int id;
    private String date;
    private String title;
    private String description;
    private String companyName;
}
