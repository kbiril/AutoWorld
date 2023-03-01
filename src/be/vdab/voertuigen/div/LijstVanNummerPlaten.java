package be.vdab.voertuigen.div;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class LijstVanNummerPlaten implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final Path PATH_NUMMERPLATEN = Path.of("/data/nummerplaat.ser");
    private ArrayList<Nummerplaat> nummerplaatArrayList = new ArrayList<>();

    public void addNummerplaat (Nummerplaat nummerplaat) {
        nummerplaatArrayList.add(nummerplaat);
    }

    public void nrplatenToOutputStream(LijstVanNummerPlaten lijst) {
        try (ObjectOutputStream stream = new ObjectOutputStream(Files.newOutputStream(PATH_NUMMERPLATEN)))
        {
            stream.writeObject(lijst);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public LijstVanNummerPlaten nrplatenFromInputStream() {
        LijstVanNummerPlaten lijst = new LijstVanNummerPlaten();
        try (ObjectInputStream stream = new ObjectInputStream(Files.newInputStream(PATH_NUMMERPLATEN)))
        {
            lijst = (LijstVanNummerPlaten) stream.readObject();
        }
        catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return lijst;
    }

    @Override
    public String toString() {
        StringBuffer lijstVanPlaten = new StringBuffer();
        lijstVanPlaten.append("*** Lijst van Platen ***\n");
        for (int i = 0; i< nummerplaatArrayList.size(); i++) {
            lijstVanPlaten.append(nummerplaatArrayList.get(i)).append("\n");
        }
        return lijstVanPlaten.toString();
    }
}
