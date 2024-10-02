import java.nio.file.Files;

public class CSVAnfrage extends Anfrage {

    public CSVAnfrage( String pfad){

       String[] daten = Files.readString(pfad).split(';');

       int nr = Integer.parseInt(daten[0]);




    }
}
