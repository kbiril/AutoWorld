package be.vdab.voertuigen.div.be.vdab.voertuigen;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;

public class Pickup extends Personenwagen implements Laadbaar {
    private Volume laadvolume;

    public Pickup(String merk, int aankoopprijs, int zitplaatsen, Volume laadvolume) {
        super(merk, aankoopprijs, zitplaatsen);
        this.laadvolume = laadvolume;
    }

    @Override
    public Volume getLaadbaarVolume() {
        return laadvolume;
    }

    @Override
    public void setLaadbaarVolume(Volume volume) {
        this.laadvolume = volume;
    }

    @Override
    public String toString() {
        return super.toString()
                + "*** Pickup ***" + "\n"
                + "laadvolume=" + laadvolume.getVolume() + "\n\n";
    }
}
