package be.vdab.voertuigen.div;

import java.io.Serializable;

import java.util.Objects;

public class Nummerplaat implements Comparable<Nummerplaat>, Serializable {
    private static final long serialVersionUID = 1L;
    private final String plaat;

    public Nummerplaat(String plaat) {
        this.plaat = plaat;
    }

    public String getPlaat() {
        return plaat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Nummerplaat nummerplaat)) { return false; }

        return plaat.equals(nummerplaat.plaat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plaat);
    }

    @Override
    public String toString() {
        return "Nummerplaat: " + plaat + '\n';
    }

    @Override
    public int compareTo(Nummerplaat nummerplaat) {
        return plaat.compareTo(nummerplaat.plaat);
    }
}
