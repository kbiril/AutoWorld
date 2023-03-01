package be.vdab.voertuigen.div.be.vdab.voertuigen;

import be.vdab.voertuigen.div.Div;
import be.vdab.voertuigen.div.Nummerplaat;

import java.io.Serializable;
import java.util.Objects;

public class Voertuig implements Comparable<Voertuig>, Serializable {
    private static final long serialVersionUID = 1L;

    private final Nummerplaat nummerplaat = Div.INSTANCE.getNummerplaat();
    private String merk;
    private int aankoopprijs;

    public Voertuig(String merk, int aankoopprijs) {
        setMerk(merk);
        setAankoopprijs(aankoopprijs);
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        if (merk != null && !merk.isBlank()) {
            this.merk = merk;
        } else {
        throw new NullPointerException();
        }
    }

    public int getAankoopprijs() {
        return aankoopprijs;
    }

    public void setAankoopprijs(int aankoopprijs) {
        if (aankoopprijs > 0) {
            this.aankoopprijs = aankoopprijs;
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Voertuig voertuig)) return false;

        return nummerplaat.equals(voertuig.nummerplaat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nummerplaat);
    }

    @Override
    public int compareTo(Voertuig v) {
        return nummerplaat.compareTo(v.nummerplaat);
    }

    @Override
    public String toString() {
        return nummerplaat
                + "Merk: " + merk + "\n"
                + "Aankoopprijs: " + aankoopprijs + "\n";
    }
}
