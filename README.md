# Test_Scala

Le projet se base sur le repository https://github.com/playframework/play-scala-rest-api-example
Le serveur se lance à l'adresse suivante: http://localhost:9000/ après avoir lancer le projet `sbt run`

## Envoi d'un résultat

* Utilisation du script `./script/addResult.sh`
* EXEMPLE: `./script/addResult.sh ./script/json/multiple_result.json`

## Lecture de mes résultats (PATIENTS)

* Utilisation de la commande curl ou via le navigateur internet
* EXEMPLE: `curl http://localhost:9000/result/patient/92010201867`
* http://localhost:9000/result/patient/92010201867

## Lecture de mes résultats correspondants

* Utilisation de la commande curl ou via le navigateur internet
* EXEMPLE: `curl http://localhost:9000/result/correspondent/Correspondent1`
* http://localhost:9000/result/correspondent/Correspondent1

## Bonus

* Il n'y a pas de bonus.
