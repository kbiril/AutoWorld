package be.vdab.voertuigen.div.be.vdab.voertuigen;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class TreeSetManager {
    private static final Path PATH_VOERTUIGEN = Path.of("/data/voertuigen.ser");
    private static final Path PATH_DAT = Path.of("/data/wagenpark.dat");
    
    public void voertuigenToOutputStream (TreeSetVoertuigen voertuigTreeSet) {
        try (ObjectOutputStream stream = new ObjectOutputStream(Files.newOutputStream(PATH_DAT)))
        {
            stream.writeObject(voertuigTreeSet);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public TreeSetVoertuigen voertuigenFromInputStream () {

        try (ObjectInputStream stream = new ObjectInputStream(Files.newInputStream(PATH_DAT)))
        {
            return (TreeSetVoertuigen) stream.readObject();
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
}
