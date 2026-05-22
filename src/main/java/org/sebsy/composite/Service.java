package org.sebsy.composite;

import java.util.ArrayList;
import java.util.List;

public class Service implements IElement {
    private String nom;
    private List<IElement> elements = new ArrayList<>();

    @Override
    public double calculerSalaire() {
        return elements.stream()
            .mapToDouble(IElement::calculerSalaire)
            .sum();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<IElement> getElements() {
        return elements;
    }

    public void addElement(IElement element) {
        this.elements.add(element);
    }

    public void removeElement(IElement element) {
        this.elements.remove(element);
    }


    public void setElements(List<IElement> elements) {
        this.elements = elements;
    }
}
