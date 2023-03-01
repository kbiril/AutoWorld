package be.vdab.voertuigen.div.be.vdab.voertuigen;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.TreeSet;

public class TreeSetVoertuigen implements Serializable {
    private static final long serialVersionUID = 1L;

    private TreeSet<Voertuig> voertuigTreeSet = new TreeSet<>();

    public void addVoertuig (Voertuig voertuig) {
        voertuigTreeSet.add(voertuig);
    }

    @Override
    public String toString() {
        StringBuffer setVoertuigen = new StringBuffer();
        for (Voertuig voertuig : voertuigTreeSet) {
            setVoertuigen.append(voertuig).append("\n");
        }
        return setVoertuigen.toString();
    }
}
