package be.vdab.schoolgerief;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;

import java.io.Serializable;
import java.util.Objects;

public class Boekentas implements Laadbaar, Serializable {
    private static final long serialVersionUID = 1L;
    private String kleur;
    private Volume laadvolume;

    public Boekentas(String kleur, Volume laadvolume) {
        setKleur(kleur);
        setLaadbaarVolume(laadvolume);
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        if (kleur != null && !kleur.isBlank()) {
            this.kleur = kleur;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Volume getLaadbaarVolume() {
        return laadvolume;
    }

    @Override
    public void setLaadbaarVolume(Volume volume) {
        if (volume == null) {
            throw new IllegalArgumentException();
        }
        laadvolume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boekentas boekentas)) return false;

        return kleur.equals(boekentas.kleur) && laadvolume.equals(boekentas.laadvolume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kleur, laadvolume);
    }

    @Override
    public String toString() {
        return "*** Boekentas ***\n"
                + "Kleur: " + kleur + "\n"
                + "Laad volume: " + laadvolume.getVolume() + "\n\n";
    }
}
