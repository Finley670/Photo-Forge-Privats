Autumn Biomes - Fabric-Mod-Projekt (Quellcode) fuer Minecraft 26.3

Voraussetzungen: JDK 25, Gradle 9.3+ (oder Gradle-Wrapper aus der Fabric-Vorlage)
1. Ordner entpacken, im Ordner "gradle wrapper" ausfuehren (falls kein gradlew vorhanden)
2. ./gradlew runClient   -> testen
3. ./gradlew build       -> fertige .jar in build/libs/ (die Datei OHNE -sources)
Versionen stehen in gradle.properties.

Ohne Installation: Projekt in ein neues GitHub-Repository hochladen. Unter "Actions" laeuft
der Build automatisch; die fertige .jar steht danach unter "Artifacts" (autumnbiomes-jar).
