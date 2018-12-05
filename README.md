# MobileApplicationsWS

In deze repository staat de web server kant van het vak mobile appliaction.
Het is gebouwd met het spring framework en gemanaged door maven.


## Componenten server
Het bestaat uit de volgende componenten:

* Rest voor de mobiele applicatie
* Rest voor interactie met de third party (facebook, google en irail)
* Database connectie voor opslag van onderzoek
* R laten draaien om onderzoek uit te voeren
* model
* Database met mysql?? Nog niet zeker of dit de beste oplossing is. 

## REST functionaliteit
* Idintificatie van de gebruiker
* Opzoeking doen
* Resultaten opvragen van onderzoek

## iRail
* https://irail.be/stations/NMBS/008814001
* https://docs.irail.be/
* begian geotag: http://www.sws.geonames.org/2802361/

## Working with R in Java/Spring
* https://codophile.com/2015/04/15/how-to-integrate-r-with-java-using-rjava/

## Facebook authentication
* https://www.youtube.com/watch?v=KjBNFWKNMOY

## Google authentication
* https://developers.google.com/identity/sign-in/android/start-integrating

## SQLite
* http://code-flow-hjbello.blogspot.com/2017/07/using-sqlite-with-jdbc.html
* Table met user specificaties
* Table met getrackte stations (code)
* Table met station naam naar code maping.
* Table met vertragin resultaten(timestamp, stationscode, total delay).
* Table met opzoekingen per gebruiker.
* Table met resultaten van R analyse. (station, delayID), (dag delayID) (DelayID, gem Delay, piek, dal)

## Project specificaties
* Broadcast message: bepalen van locatie in de app, vervolgens de dichtste 10 stations tonen.
* Content provider: iRail
* Activity: MainActivity in android.
* Third party: iRail
* Authenticatie: Facebook en Google.

## Todo's:
* Lijst met alle namen van de stations moet in de databank zitten, we extrageren dat van de irail server.
* Mapping naar corresponderende codes kan al gebeuren maar weet ik nog niet zeker.
* Thread maken die om de 5 minuten de grote stations checkt op vertragingen.
* Deze vertragingen opslaan in de databank.
* Wanneer data wordt opgevraagd, R gebruiken om statistieken uit te rekenen
* Resultaten kunnen doorsturen naar de applicatie
* Resultaten op de applicatie grafisch weergeven.
* SQLite databank maken.
* Identificatie mechanismes bouwen.