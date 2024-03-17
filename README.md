# 📁 Projekt "Java Quiz"

Dieses Projekt diente dazu, uns anzuregen über das was wir bis dahin über Java gelernt haben nachzudenken und speziell die Themen Verzweigungen, Schleifen, Methoden und Strukturgramme zu festigen.

Die Aufgabenstellung habe ich im Ordner src/Aufgabenstellung abgelegt.

# 🧰 Programmiersprache/n:
- `Java`

# ✨ Features
- **Hauptmenü:** Der User wird aufgefordert eine Option auszuwählen (S - Start / H - Highscore / Q - Beenden). Groß- und Kleinschreibung wird ignoriert, bei einer anderen Eingabe als vorgegeben wird das Menü erneut aufgerufen.

- **Quizfrage beantworten:** Nach dem Quiz Start wird eine Frage und die 4 dazugehörigen Antwortmöglichkeiten ausgegeben, die man durch die eingabe des entsprechenden Buchstaben beantworten kann. Die Fragereihenfolge wird zufällig ausgegeben.

- **Punktelogik:** Für jede richtig beantwortete Frage bekommt man einen Punkt dazu (max. 5 Punkte), bei einer falschen Eingabe, darunter zählt auch ein nicht aufgeführtes Zeichen, wird das Quiz beendet, die bisher erreichten Punkte ausgegeben und der User wird aufgefordert einen Namen (max. 15 Zeichen) für die Highscoretabelle einzugeben. Daraufhin kann der User aussuchen, ob das Quiz erneut gestartet oder die Highscoretabelle angezeigt werden soll.

- **Highscoretabelle:** Die Highscoretabelle wird zuerst nach Punkten und im anschluss nach Namen sortiert ausgegeben. Es sind einige Platzhalter einträge bereit vorhanden.

# 🔄 Ablauf
Ich habe als allererstes die Menü-Methode erstellt. Da das Menü mehrere Verzweigungen hat, habe ich mich für ein Switch-Case entschieden.

Als Nächstes habe ich die Fragen in einem 2-Dimensionalem-Array gespeichert.<br>
Speicherreihenfolge:<br>
- `[gruppenNr][antwortNr] = "Inhalt";` <br>
- `[X][0] = Frage` <br>
- `[X][1 - 4] = Antwortmöglichkeit A bis D` <br>
- `[X][5] = richtige Antwortmöglichkeit` <br>

Daraufhin habe ich an der Quiz logik gearbeitet, begonnen habe ich damit die Fragen mithilfe der Random-Methode in einer zufälligen Reihenfolge auszugeben. Nach einigen Startschwierigkeiten und einer Unterhaltung mit einem guten Freund, habe ich einen Weg gefunden es zu verhindern dass, dieselbe Frage mehrmals gestellt wird (Danke Olaf).
Die Punkteverteilung und wie ich mit einer falschen Antwort umgehe, ging weitestgehend problemlos.

Nach der Quiz logik habe ich an einer Methode gearbeitet, die den Namen des Users abfragt, um das Ergebnis dann in der Highscoretabelle anzuzeigen und an der Neustart-Methode um das Quiz erneut spielen zu können oder die Highscoretabelle anzeigen zu lassen.

Mit der Methode zum Anzeigen des Highscores hatte ich etwas zu kämpfen. Die Einträge wurde zwar angezeigt aber es war sehr unübersichtlich bis mir Olaf die formatierte Ausgabe erklärte.

Platzhalter einträge dürfen natürlich nicht fehlen, also hab ich die auch noch schnell aus dem Ärmel gezaubert.

Zu guter Letzt sind wir beim Endgegner angekommen, dem Sortieralgorithmus. Daran habe ich mir echt die Zähne ausgebissen, Stackoverflow und Javapoint haben für mich nichts Logisches oder umsetzbares hergegeben. Die tipps die man mir da gegeben hat, haben mich dann aber auf den richtigen Weg gebracht.

# 📚 Was ich dazugelernt habe
Dieses Projekt hat mir dabei geholfen die Themen, die wir im Unterricht gelernt haben, weiter zu festigen sowie die tipps die man erhält, sei es im Unterricht, im Internet oder sonst wo, besser zu interpretieren und für meine Situation anzuwenden.
- **Random-Methode:** Durch dieses Projekt habe ich zum ersten Mal mit einem Zufallsgenerator gearbeitet.
- **Bubblesort:** Fluch und Segen zugleich, als es dann endlich funktioniert hat, hat es auch sinn ergeben aber bis ich es zum Laufen gekriegt habe, ist einige Zeit vergangen.
- **Formatierte Ausgabe (printf):** Super wie einfach es ist unübersichtliche Daten Formatiert auszugeben.
- **"ANSI escape code":** Bevor ich eine Anleitung für Fluchtsequenzen gefunden habe, war mir nicht bewusst wie viel man damit eigentlich machen kann.

# 💡 Verbesserungsideen
- Die Einträge der Highscoretabelle werden zurückgesetzt, wenn das Programm endet. Umgehen kann man das Problem, indem man die Daten in eine Textdatei auslagert.
- Die Highscoretabelle wird nach Punkten und im anschluss nach Namen sortiert. Um die Sortierung fairer zu gestalten, kann man einen Timer implementieren.
- Aktuell läuft das Programm nur auf dem Terminal aber eine GUI würde mich sehr interessieren.
