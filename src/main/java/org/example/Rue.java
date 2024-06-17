package org.example;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Rue{
    private String nom = "";
    private Lieu lieu1;
    private Lieu lieu2;

    public Rue(Lieu lieu1, Lieu lieu2) {
        this.lieu1 = lieu1;
        this.lieu2 = lieu2;
    }
}