import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//Aufgabe aus IHK Prüfung Winter 22 AP2
//die Fehler hier entstehen dadurch, dass in der Aufgabe vorgegebene
//Klassen "Flaeche" und "Anfrage" hier nicht implemeniert sind

public class CSVAnfrage extends Anfrage { //Punkt: Vererbung von Anfrage

    //die Attribute laut UML
    //von der abstrakten Klasse geerbt
    //(da protected), was fragwürdig ist, aber hier so gemacht
    //die Verwendung von Settern und Gettern wäre angebrachter mMn

    public CSVAnfrage( String pfad) throws IOException { //Punkt: Constuctor mit diesen Parametern

       var path = Paths.get(pfad); //Java spezifisch

        //Punkt: Daten in Array aufspliten
        String text = Files.readString(path, Charset.defaultCharset() );
        String[] daten = text.split(";");

        //Punkt: Einzeldaten den Eigenschaften der Klasse zuweisen
        this.anfrageNummer = Integer.parseInt(daten[0]);//Punkt: Datentyp konvertieren
        this.kwp = Double.parseDouble(daten[1]);//Punkt: Datentyp konvertieren

        if(daten[2].isEmpty()){//Punkt: prüfen ob pvLeistung vorhanden ist
            this.pvLeistung = null;
        }
        else {
            this.speicherKapazitaet = Double.parseDouble(daten[2]);//Punkt: Datentyp konvertieren
        }

        //Punkt: Array deklarieren um die anfallenden Daten der Flächen zu speichern
        Flaeche[] flaechen = new Flaeche[daten.length - 3];

        for(int i= 3; i < daten.length; i++){
            String[] flaechenDaten = daten[i].split(",");//Separator ist hier Komma!
            flaechen[i] = new Flaeche(flaechenDaten[0],
                                      flaechenDaten[1],
                                      flaechenDaten[2]
            );
        }

        this.dachFlaechen = flaechen;
    }
}
