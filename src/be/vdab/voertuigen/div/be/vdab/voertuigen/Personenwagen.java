package be.vdab.voertuigen.div.be.vdab.voertuigen;

public class Personenwagen extends Voertuig{

    private int zitplaatsen = 1;

    public Personenwagen(String merk, int aankoopprijs, int zitplaatsen) {
        super(merk, aankoopprijs);
        setZitplaatsen(zitplaatsen);
    }

    public int getZitplaatsen() {
        return zitplaatsen;
    }

    public void setZitplaatsen(int zitplaatsen) {
        if (zitplaatsen > 0) {
            this.zitplaatsen = zitplaatsen;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "*** Personenwagen ***\n"+ "Zitplaatsen: " + zitplaatsen + "\n\n";
    }


}
