/*
 * Murat Bakici
 * 1. Java Projekt: Java Quiz
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    // benötigtes global gesetzt z.B. um nicht mehrere Scanner zu erzeugen / zu schließen.
    static Scanner scan = new Scanner(System.in);
    static String[][] listeDerFragen = new String[6][6];
    static ArrayList<String> highscoreTblName = new ArrayList<>();
    static ArrayList<Integer> highscoreTblPunkte = new ArrayList<>();
    static ArrayList<Integer> gezogeneZahl = new ArrayList<>();

    /**
     * - Startmethode. Die Überschrift wird ausgegeben und das Menü wird aufgerufen.
     */
    public static void main(String[] args) {
        // \033[4m ist ein "ANSI escape code" oder auch "ANSI Fluchtsequenz" genannt, welches den Text unterstreicht. Diese ANSI Sequenzen ermöglichen es Text in jeder Terminal-Anzeige die, diese ANSI Codes unterstützen, formatiert und umgestaltet anzuzeigen.
        System.out.println("\033[4m\nWillkommen im Java-Quiz!\033[0m");
        menue();
    }

    /**
     * - Diese Methode gibt dem User Auswahlmöglichkeiten.
     * - Eingabe des Users wird per Scanner übernommen und in Großbuchstaben umgewandelt.
     * - Je nach wahl wird eine andere Methode aufgerufen, bei falscher Eingabe wird das Menü erneut aufgerufen. Q beendet das Quiz.
     */
    public static void menue() {

        System.out.println("\033[4m\nHauptmenü\033[0m");
        System.out.print("\nS - Start \nH - Highscore \nQ - Quiz beenden \nBitte triff eine auswahl: ");
        switch (scan.nextLine().toUpperCase()) {
            case "S":
                System.out.println("\nDas Quiz wird gestartet...\n\n\033[4mQuiz\033[0m\n");
                quiz();
                break;
            case "H":
                System.out.println("\nHighscore wird aufgerufen...");
                highscoreAnzeigen();
                System.out.println();
                menue();
                break;
            case "Q":
                System.out.println("\nDas Quiz wurde beendet...");
                System.exit(0);
                break;
            default:
                System.out.println("\nDu hast einen falschen Eintrag gemacht.");
                menue();
                break;
        }
    }

    /**
     * Fragen und die dazugehörigen Antwortmöglichkeiten in ein Zweidimensionales Array gespeichert.
     * Speicherreihenfolge:
     *  -[gruppenNr][antwortNr] = "Inhalt";
     *  -[X][0] = Frage
     *  -[X][1 - 4] = Antwortmöglichkeit A bis D
     *  -[X][5] = richtige Antwortmöglichkeit
     */

    public static void fragenSpeichern(){
        listeDerFragen[0][0] = "Was ist While für eine Schleife?";
        listeDerFragen[0][1] = "A)\tKopfgesteuert";
        listeDerFragen[0][2] = "B)\tFußgesteuert";
        listeDerFragen[0][3] = "C)\tComputergesteuert";
        listeDerFragen[0][4] = "D)\tKI-gesteuert";
        listeDerFragen[0][5] = "A";

        listeDerFragen[1][0] = "Welches „String“ ist im folgendem Codeabschnitt der Variablenname? \nString string = \"String\";";
        listeDerFragen[1][1] = "A)\t1";
        listeDerFragen[1][2] = "B)\t2";
        listeDerFragen[1][3] = "C)\t3";
        listeDerFragen[1][4] = "D)\talle drei";
        listeDerFragen[1][5] = "B";

        listeDerFragen[2][0] = "Was ist String für ein Datentyp?";
        listeDerFragen[2][1] = "A)\tPrimitiv";
        listeDerFragen[2][2] = "B)\tNicht-Primitiv";
        listeDerFragen[2][3] = "C)\tMethode";
        listeDerFragen[2][4] = "D)\tBetriebsübergreifend";
        listeDerFragen[2][5] = "B";

        listeDerFragen[3][0] = "Welcher Datentyp passt zu 366,99?";
        listeDerFragen[3][1] = "A)\tboolean";
        listeDerFragen[3][2] = "B)\tDouble";
        listeDerFragen[3][3] = "C)\tdouble";
        listeDerFragen[3][4] = "D)\tint";
        listeDerFragen[3][5] = "C";

        listeDerFragen[4][0] = "Wofür steht void?";
        listeDerFragen[4][1] = "A)\tWeltraum :)";
        listeDerFragen[4][2] = "B)\tKEIN Rückgabewert erwartet";
        listeDerFragen[4][3] = "C)\tUnendlich viele ArrayList Einträge";
        listeDerFragen[4][4] = "D)\tvoid in Voidwalker";
        listeDerFragen[4][5] = "B";

        listeDerFragen[5][0] = "Was bedeutet \"Initialisierung\"?";
        listeDerFragen[5][1] = "A)\tErstmalige Vergabe eines Wertes";
        listeDerFragen[5][2] = "B)\tDer PC wird hochgefahren";
        listeDerFragen[5][3] = "C)\tFingerabdruck wird gescannt";
        listeDerFragen[5][4] = "D)\tEin String wird  verarbeitet und ausgegeben";
        listeDerFragen[5][5] = "A";

    }
    /**
     * - Methodenaufruf von "fragenSpeichern" und Hilfsvariablen erzeugt.
     * - Mithilfe der Random Methode Zufallszahlen generiert, um Fragen durchzumischen.
     * - Die generierten Zahlen in eine ArrayList gespeichert, um Dopplung zu verhindern.
     * - For-Schleife gibt Frage und Antwortmöglichkeiten aus, stoppt bevor die richtige Antwort (Index [X][5]) ausgegeben wird. als Letztes wird dem User eine Eingabeaufforderung angezeigt.
     * - If-Verzweigung: User Eingabe wird in Großbuchstaben umgewandelt und verglichen, ob sie NICHT mit der richtigen Antwort (Index [X][5]) übereinstimmt.
     *    (anderes Zeichen als vorgegeben oder keine Eingabe / Leerzeichen wird als falsch gewertet)
     *      - ist das der Fall, wird eine Ausgabe an der User gemacht, die Hilfsvariable auf false gesetzt und eine Methode aufgerufen, um aus der Do While-Schleife zu kommen.
     *      - war die Antwort richtig, wird der Punktezähler inkrementiert und eine Ausgabe an den User gemacht.
     * - Die Do-While Schleife wird beendet, wenn der Punktezähler 5 erreicht oder die Hilfsvariable auf false gesetzt wird (durch eine falsche Antwort).
     *      - bei 5 Punkten wird eine Methode aufgerufen
     * - Wenn das Quiz erneut gespielt wird, wird der Inhalt der Zufallszahl ArrayList gelöscht.
     */
    public static void quiz() {
        fragenSpeichern();
        boolean istAntwortRichtig = true;
        Random zufallszahl = new Random();
        int gruppenNr;
        int punktezaehler = 0;
        gezogeneZahl.clear();

        do {
            do {
                gruppenNr = zufallszahl.nextInt(5);
            }
            while (gezogeneZahl.contains(gruppenNr));
            gezogeneZahl.add(gruppenNr);

            for (int antwortNr = 0; antwortNr < 5 ; antwortNr++) {
                System.out.println(listeDerFragen[gruppenNr][antwortNr]);
            }
            System.out.print("\nBitte gebe deine Antwort an: ");

            if (!scan.nextLine().toUpperCase().equals(listeDerFragen[gruppenNr][5])) {
                System.out.println("\nDie Antwort war leider falsch! Deine punktzahl lautet: " + punktezaehler);
                istAntwortRichtig = false;
                highscoreEintragen(punktezaehler);
            }
            else {
                punktezaehler++;
                System.out.println("\nRichtig! Du hast einen Punkt dazubekommen. Dein Punktestand: " + punktezaehler + "\n");
            }

        }
        while (istAntwortRichtig && punktezaehler < 5);
        System.out.println("Du hast 5 richtige Antworten gegeben und damit " + punktezaehler + " Punkte erzielt. Super!");
        highscoreEintragen(punktezaehler);
    }

    /** Diese Methode gibt dem User etwas aus und speichert dessen Eingabe, sowie die Punkte in jeweils eine ArrayListe. Am Ende wird eine Methode aufgerufen.
     * Die IF-Verzweigung prüft, ob die Namenseingabe über 15 Zeichen liegt und kürzt es ggfls. auf die ersten 15 Zeichen.
     */
    public static void highscoreEintragen(int punktezaehler) {
        System.out.print("\nBitte gib deinen Namen für die Highscore-Tabelle ein (max. 15 Zeichen): ");
        String name = scan.nextLine();
        if (name.length() >15) {name = name.substring(0,15);}
        highscoreTblName.add(name);
        highscoreTblPunkte.add(punktezaehler);
        neustart();
    }

    /**
     * Diese Methode gibt eine Ausgabe an den User und speichert dessen antwort in eine Variable.
     * Diese Variable wird in einer If Else Verzweigung geprüft, ob sie einen der beiden Optionen entspricht. Groß- und Kleinschreibung wird dabei ignoriert.
     * In den jeweiligen Optionen werden dann ausgaben an den User gemacht, Methoden aufgerufen, das Quiz beendet oder bei falscher eingabe die Methode wiederholt.
     */
    public static void neustart() {
        System.out.print("\nMöchtest du eine neue Quiz-Runde starten (S) oder die Highscore-Tabelle anzeigen und das Quiz beenden (H)?: ");
        String auswahlNeustart = scan.nextLine();

        if (auswahlNeustart.equalsIgnoreCase("S")) {
            System.out.println("\nDas Quiz wird neugestartet...\n\n\033[4mQuiz\033[0m\n");
            quiz();
        } else if (auswahlNeustart.equalsIgnoreCase("H")) {
            System.out.println("\nDie Highscore-Tabelle wird angezeigt...");
            highscoreAnzeigen();
            System.exit(0);
        } else {
            System.out.println("\n Du hast einen falschen Eintrag gemacht.");
            neustart();
        }
    }

    /**
     *Ruft die DummySpeichern Methode auf, wenn 1 bzw. kein Eintrag für die Highscoretabelle existiert und gibt diese sortiert sowie formatiert aus.
     */
    public static void highscoreAnzeigen() {
        if (highscoreTblPunkte.size() <=1){dummysSpeichern();}
        highscoreSortieren();
        System.out.println("\033[4m\nHighscore\033[0m\n");
        String platz = "Platz";
        String name = "Name";
        String punkte = "Punkte";

        /*
         * Erklärung damit ich es mir merken kann:
         *
         * - printf = formatierte Systemausgabe
         * - %Xs = ein vorgemerkter Platz der egal, ob darin etwas steht oder nicht diesen Platz reserviert (ähnlich spaltenbreite bei Excel)
         * - das "-" heißt Linksbündig (z.B. bei %-20s)
         * - das "s" steht für String
         * - man benötigt entsprechend dem was ausgegeben werden soll, die exakte Anzahl an %Xs (3 ausgaben, 3 Reservierungen etc.)
         * - For-Schleife um die Spaltennamen und Inhalte mit "=" Symbolen zu trennen (40 da 7 + 20 + 7 + 6 (2 * 3 durch " | ") 40 ergibt)
         */
        System.out.printf("%5s | %-20s | %7s\n", platz, name, punkte);
        for (int listenTrenner=1; listenTrenner<=38; listenTrenner++) {
            System.out.print("=");
        }
        for (int positionsZaehler = 0; positionsZaehler < highscoreTblPunkte.size(); positionsZaehler++) {
            System.out.printf("\n%5s | %-20s | %7s ", (positionsZaehler+1), highscoreTblName.get(positionsZaehler), highscoreTblPunkte.get(positionsZaehler));
        }
    }

    /**
     * Dummyeinträge in ArrayListen speichern*/
    public static void dummysSpeichern(){
        highscoreTblName.add("King Julian");
        highscoreTblPunkte.add(2);
        highscoreTblName.add("Mort");
        highscoreTblPunkte.add(-1);
        highscoreTblName.add("Private");
        highscoreTblPunkte.add(3);
        highscoreTblName.add("Skipper");
        highscoreTblPunkte.add(5);
        highscoreTblName.add("Rico");
        highscoreTblPunkte.add(0);
        highscoreTblName.add("Kowalski");
        highscoreTblPunkte.add(999999);
    }
    /**
     * Daten werden sortiert, temporär in eine Variable und am Ende in den jeweiligen ArrayList gespeichert.
     */
    public static void highscoreSortieren(){

        /*
         * Erklärung damit ich es mir merken kann:
         *
         * Äußere For-Schleife zählt von 0 (erster Eintrag Namensliste) bis zum vorletzten Eintrag der ArrayList.
         * Innere For-Schleife zählt von 1 bis zum letzten Eintrag der Namensliste
         * In der If-Verzweigung wird geprüft, ob die Punktzahl der inneren Schleife größer ist als die Punktzahl der äußeren Schleife oder ob beide gleich groß sind.
         * Trifft eine der beiden Bedingungen zu, wird der Inhalt der äußeren Liste in eine temporäre Variable gespeichert, der innere Wert nimmt nun diesen Platz ein. Zum Schluss wird der Wert der in der temporären Variable ist, in die innere Liste übertragen.
         * Dies wird für den Spielernamen und für die erreichte Punktzahl gemacht.
         */

        // Bubble Sort
        for (int aussen = 0; aussen < highscoreTblName.size() - 1; aussen++) {
            for (int innen = aussen + 1; innen < highscoreTblName.size(); innen++) {
                if (highscoreTblPunkte.get(innen) > highscoreTblPunkte.get(aussen) || (highscoreTblPunkte.get(innen).equals(highscoreTblPunkte.get(aussen)))) {

                    // Vertauschen der Spielernamen
                    String tempName = highscoreTblName.get(aussen);
                    highscoreTblName.set(aussen,highscoreTblName.get(innen));
                    highscoreTblName.set(innen, tempName);

                    // Vertauschen der Spielerpunkte
                    int tempScore = highscoreTblPunkte.get(aussen);
                    highscoreTblPunkte.set(aussen,highscoreTblPunkte.get(innen));
                    highscoreTblPunkte.set(innen, tempScore);
                }
            }
        }
    }
}