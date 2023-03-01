package be.vdab.voertuigen.div.be.vdab.voertuigen;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;

public class Vrachtwagen extends Voertuig implements Laadbaar {
    private Volume laadvolume;
    private int maximaalToegelatenMassa;
    private int aantalAssen;

    public Vrachtwagen(String merk, int aankoopprijs, Volume laadvolume, int maximaalToegelatenMassa, int aantalAssen)
    {
        super(merk, aankoopprijs);
        setLaadbaarVolume(laadvolume);
        setMaximaalToegelatenMassa(maximaalToegelatenMassa);
        setAantalAssen(aantalAssen);
    }

    public int getMaximaalToegelatenMassa() {
        return maximaalToegelatenMassa;
    }

    public void setMaximaalToegelatenMassa(int maximaalToegelatenMassa) {
        if(maximaalToegelatenMassa > 0) {
            this.maximaalToegelatenMassa = maximaalToegelatenMassa;
        }
    }

    public int getAantalAssen() {
        return aantalAssen;
    }

    public void setAantalAssen(int aantalAssen) {
        if(aantalAssen > 0) {
            this.aantalAssen = aantalAssen;
        }
    }

    @Override
    public Volume getLaadbaarVolume() {
        return laadvolume;
    }

    @Override
    public void setLaadbaarVolume(Volume volume) {
        laadvolume = volume;
    }

    @Override
    public String toString() {

        return super.toString()
                + "*** Vrachtwagen ***\n"
                + "Laadvolume: " + laadvolume.getVolume() + "\n"
                + "Max toegelaten massa: " + maximaalToegelatenMassa  + "\n"
                + "Aantal assen: " + aantalAssen + "\n\n";
        }
}
