import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CSVAnfrage extends Anfrage { //Punkt: Vererbung von Anfrage

    public CSVAnfrage( String pfad) throws IOException { //Punkt: Constuctor mit diesen Parametern

       var path = Paths.get(pfad); //Java spezifisch

        //Punkt: Daten in Array aufspliten
        String text = Files.readString(path, Charset.defaultCharset() );
        String[] daten = text.split(";");

        //Punkt: Einzeldaten Variablen zuweisen
        int nr = Integer.parseInt(daten[0]);//Punkt: Datentyp konvertieren

        int kw = Integer.parseInt(daten[1]);

        int speicherKwh = Integer.parseInt(daten[2]);

        String[] flaechenWest = daten[3].split(",");
        String[] flaechenOst = daten[4].split(",");


        //Aufgabe: allgemeingültig für mehrere Flächen mit Hilfe einer Schleife lösen
        String nameWest = flaechenWest[0];
        int laengeWest = Integer.parseInt(flaechenWest[1]);
        int breiteWest = Integer.parseInt(flaechenWest[2]);

        String nameOst = flaechenOst[0];
        int laengeOst = Integer.parseInt(flaechenOst[1]);
        int breiteOst = Integer.parseInt(flaechenOst[2]);





    }
}
