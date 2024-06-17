package org.example;

import java.util.List;

public record Trajet(List<Rue> rues) {
    public Trajet addRue(Rue rue){
        this.rues.add(rue);
        return this;
    }
}