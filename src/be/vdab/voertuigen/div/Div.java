package be.vdab.voertuigen.div;

public enum Div {
    INSTANCE; // stelt een enige object voor
    private int nummer = 1;

    public Nummerplaat getNummerplaat() {
        String plaat = String.format("1-AAA-%03d", nummer++);
        if (nummer >= 999) {
            nummer = 1;
        }
        return new Nummerplaat(plaat);
    }

}