package be.vdab;

import be.vdab.schoolgerief.Boekentas;
import be.vdab.util.Laadbaar;
import be.vdab.util.Maat;
import be.vdab.util.Volume;
import be.vdab.util.VolumeException;
import be.vdab.voertuigen.div.be.vdab.voertuigen.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        // Voertuigen
        TreeSetVoertuigen tsV = new TreeSetVoertuigen();
        TreeSetManager setManager = new TreeSetManager();

        tsV.addVoertuig(new Personenwagen("VW", 17_000, 6));
        tsV.addVoertuig(new Personenwagen("Toyota", 10_000, 4));
        try {
            tsV.addVoertuig(new Personenwagen("", 10_000, 4));
        } catch (NullPointerException nex) {
            System.out.println(nex);
        }

        tsV.addVoertuig(new Pickup("Mercedes", 11_000, 7,
                new Volume(30, 30, 20, Maat.CENTIMETER)));
        try {
            tsV.addVoertuig(new Pickup("VW", 12_000, 7,
                    new Volume(2, -1, -3, Maat.DECIMETER)));
        }
        catch (VolumeException e) {
            System.out.println(e.getMessage());
        }

        try {
            tsV.addVoertuig(new Pickup("Mercedes", 13_000, 7,
                    new Volume(2, -1, 3, Maat.DECIMETER)));
        }
        catch (VolumeException e) {
            System.out.println(e.getMessage());
        }

        tsV.addVoertuig(new Pickup("Volvo", 35_000, 7,
                new Volume(30, 30, 20, Maat.CENTIMETER)));
        tsV.addVoertuig(new Vrachtwagen("Mercedes", 35_000,
                new Volume(50, 45, 35, Maat.CENTIMETER), 20_000, 2));
        tsV.addVoertuig(new Vrachtwagen("Volvo", 32_000,
                new Volume(6, 4, 3, Maat.DECIMETER), 18_000, 3));

        System.out.println(tsV);

        setManager.voertuigenToOutputStream(tsV);


        System.err.println("Gehaald from file wagenpark.dat");
        System.out.println(setManager.voertuigenFromInputStream());

        //Boekentassen
        Voertuig voertuig1 = new Personenwagen("VW", 17_000, 6);
        Voertuig voertuig2 = new Personenwagen("Toyota", 10_000, 4);

        Voertuig voertuig3 = new Pickup("Mercedes", 11_000, 7,
                new Volume(30, 30, 20, Maat.CENTIMETER));


        Voertuig voertuig4 = new Pickup("Volvo", 35_000, 7,
                new Volume(30, 30, 20, Maat.CENTIMETER));
        Voertuig voertuig5 = new Vrachtwagen("Mercedes", 35_000,
                new Volume(50, 45, 35, Maat.CENTIMETER), 20_000, 2);
        Voertuig voertuig6 = new Vrachtwagen("Volvo", 32_000,
                new Volume(6, 4, 3, Maat.DECIMETER), 18_000, 3);
        Boekentas red = new Boekentas("red", new Volume(50, 40, 10, Maat.CENTIMETER));
        Boekentas blue = new Boekentas("blue", new Volume(50, 40, 10, Maat.CENTIMETER));
        Boekentas grey = new Boekentas("grey", new Volume(2, 3, 2,Maat.DECIMETER));
        Boekentas yellow = new Boekentas("yellow", new Volume(1, 4, 2, Maat.DECIMETER));
        Boekentas blue2 = new Boekentas("blue", new Volume(50, 40, 10, Maat.CENTIMETER));
        System.out.println(red.toString() + blue.toString() + grey.toString() + yellow.toString());

        System.out.println("--- Laadbaars objecten ---");
        ArrayList<Laadbaar> laadbaars = new ArrayList<>();
        laadbaars.add(red);
        laadbaars.add(blue);
        laadbaars.add(grey);
        laadbaars.add(yellow);
        laadbaars.add((Laadbaar) voertuig3);
        laadbaars.add((Laadbaar) voertuig4);
        laadbaars.add((Laadbaar) voertuig5);

        double som = 0;
        for (Laadbaar laadbaar : laadbaars) {
            System.out.println(laadbaar);
            som += laadbaar.getLaadbaarVolume().getVolume();
        }

        System.out.println("Totale volume: " + Math.round(som * 10000.0) / 10000.0);
    }
}
