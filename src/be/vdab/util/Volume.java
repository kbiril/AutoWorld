package be.vdab.util;

import java.io.Serializable;
import java.util.Objects;

public final class Volume implements Serializable, Comparable<Volume> {
    private static final long serialVersionUID = 1L;
    private final int breedte, hoogte, diepte;
    private final Maat maat;

    public Volume(int breedte, int hoogte, int diepte, Maat maat) {

        if (breedte > 0 && hoogte > 0 && diepte > 0) {
            this.breedte = breedte;
            this.hoogte = hoogte;
            this.diepte = diepte;
            this.maat = maat;
        } else {
            throw new VolumeException("Negatieve volume is niet toegestaan!" +
                    " Alle afmetingen moeten positief zijn!");
        }
}

    public double getVolume () {
        double volume = (double) breedte * hoogte * diepte;
        switch (maat) {
            case CENTIMETER -> volume /= 1_000_000D;
            case DECIMETER -> volume /= 1_000D;
            case METER -> volume /= 1D;
            default -> throw new IllegalArgumentException(maat + " verkeerde maat");
        }
        return volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Volume volume)) return false;

        return breedte == volume.breedte && hoogte == volume.hoogte && diepte == volume.diepte && maat == volume.maat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(breedte, hoogte, diepte, maat);
    }

    @Override
    public int compareTo(Volume v) {
        if (this.equals(v)) return 0;
        else if (this.getVolume() > v.getVolume()) return 1;
        else return -1;
    }
}
