Beispiel Jenkins-Jobs
======================
 Aus dem Buch "Git - Dezentrale Versionsverwaltung im Team" von René Preißel und Bjorn Stachmann (https://www.dpunkt.de/buecher/12151/Git.html)


Voraussetzungen:
----------------
* Jenkins (getestet mit Version 2.26)
* Git Plugin (getestet mit Version 3.0.0)
* Git Client Plugin (getestet mit Version 2.0.0)
* Job DSL Plugin (getestet mit Version 1.52)
* Stash Notifier Plugin (getestet mit Version 1.11.4)

Jobs erzeugen
-------------
Erzeugen Sie einen einfachen Jenkins-Job, und konfigurieren Sie die Git-URL auf:

https://github.com/kapitel26/jenkins-templates.git

Sie benötigen keinen Build-Trigger, da der Job nur manuell gestartet wird.
Über die Auswahlbox **Build-Schritt hinzufügen** wählen Sie den Eintrag **Process Job-DSLs** aus.
Daraufhin erscheint der entsprechende Abschnitt. Tragen Sie in dem Feld **DSL Scripts** den Wert '*.groovy' ein.

Wenn Sie nun den neuen Jenkins-Job starten, wird das Beispiel-Repository geklont und alle darin enthaltenen Job-Groovy-Skripte werden ausgeführt.
Das wiederum führt dazu, dass alle Beispiel-Jenkins-Projekte angelegt werden.
