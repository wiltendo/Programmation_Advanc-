# Rapport TP1 :

## Séance du 20/09/2024

Objectif de la Séance :
- Commencer le TP1

Déroulé su Cour :
- Création Shéma de class grace à StarUML ()


## Séance du 27/09/2024

### Objectif de la Séance :
- Finir le Tp1 :
  
  - Faire àparraitre une fenetre avec un carré alant à droite
  - Permettre au Carré d'aller dans le sens inverse quand il touche une bordure

### Cour :
thread : permet d'effectuer plusieurs action / programme en même temps.<br>
Ressource critique : Ressource utiliser que par 1 processus à la fois. Ex: Zone Mémoire, imprimante <br>
Section critique : Portion de code n'executant que 1 thread. (Mais plusisuer thread cherche à y asséder)<br>
Verrou MUTEX : verrou permettant de bloquer un thread durant une Exclusion Mutuelle<br>


## Séance du 28/09/2024

### Objectif de la Séance :

- Finir le TP1 :
  - Possibilité d'apparaitre plusieur Mobile en même temps
  - Changement des vittesse pour chaque Mobile
- Commancer le TP2 :
  - lock ressources pour permettre de mettre en ordre différents thread indépendant
  - semaphore binaire
  

### Cour
à la maniére d'un sémaphore on bloque l'accée pour que 1 thread passe à la fois
Wait() = stop l'accée à la ressource
Signal() = donne l'information que la ressource est libérrer 



### Information
CemaphoreBinaire : 
- on bloque la valeur Initiale à 1 pour indiquer que la Ressource est libre
- quand on passe la valeur à 0 la Ressource est Utilisé donc on bloque l'acces
- Pour lié tout le monde on initialise le Semaphore avant les Thread et on leur donne l'acces
- quand on finit l'utilisation de la Ressource le thread utilise syncSignal pour réveiller les autres et le premier récupére l'acces de la ressource
- SyncWait permet de bloquer l'acces (mettre une file d'attente)

## 11/10/2024

### Cour 
Les differents modules cherche à avancer mais il sont bloquer par le Cemaphore ,
Il est possible que un module ne puisse pas avancer durant un long momment car le cemaphore ne lui lesse pas l'acces

### Les Moniteurs
objet de syncronisation permettant l'exclusion mutuelle entre opérateur sur des données et d'attendre qu'une condition soit validé puis donner l'accées

Dans un moniteur on retrouve :
- Un attribut qui à la ressources partagé
- Un attribut qui à la variable de syncronisation
- Une méthode write
- Une méthode read



## 18/10/2024

### Objectif de la Séance :

- Faire le TP3 en mode BlockingQueue :
  - Possibilité d'apparaitre plusieur Mobile en même temps
  - Changement des vittesse pour chaque Mobile

### Cour
CM3 

## 25/10/2024

### Objectif de la Séance :
- Faire le Cour CM3                                             
- Faire le TP4 (Mc -> Monte Carlo (et non Main Character))      ✕
- Faire des Math (Voir le Fichier Math.md)                      ✕
### Cour
CM3 -> 10 à 17


# Voir Dossier Monté Carlo
## 08/11/2024

### Objectif de la Séance :
- Faire le TP4 Exercice 3
- Controle + Corection (durée de 2h car 40min controle + 70min correction + 10min pause)
- Faire Cour CM4
### Cour 
CM4


## 15/11/2024

### Objectif de la Séance : 
- Faire Cour CM4

### Cour
CM4 (6 - 17):
- Executor
  - Executor peut être exécuter soit avec des Runnable , soit avec des Callables

## 22/11/2024

Voir discord mp _**Mathieu**_ (class)
et discord resumer cour dans discution FI thomas dufaud

## 29/11/2024

1. Executer le code distribué
   - WorkerSocket -> Attribut: port
   - MasterSocket -> (Avoir lancé des Worker avant)
2. Modifier
  - Worker pour calculer π
    - ajouter MonterCarlo à la ligne compute soit par fonction ,soit direct dans main
3. Est-ce que WorkerSocket peut appeler une bib externe/un autre code Mc?/un autre composant?

```
(Ms) -> ((Ws))
          M -> (W)
            -> (W) 
     -> ((Ws))
          M -> (W)
            -> (W)
```
Version pour utiliser Pi.java
```
(Ms) -> ((Ws))
         call Pi.java with Aw
     -> ((Ws))
```

4. Formatage des sorties
5. Mise en place exp   Stabilité forte et faible

   | Number Worker M1/M2 | 1 /1     | 2/1      | 3 /1     | 1/10     | 2/ 10    | 3/10     | 1/100    | 2/100    | 3/100    | 1/1000   |
   |---------------------|----------|----------|----------|----------|----------|----------|----------|----------|----------|----------|
   | Temps d'execution   | 504ms    | 530ms    | 564ms    | 815ms    | 1070ms   | 1700ms   | 5100ms   | 11100ms  | 14900ms  | 50000ms  |
   | totalCount          | 16000000 | 16000000 | 16000000 | 16000000 | 16000000 | 16000000 | 16000000 | 16000000 | 16000000 | 16000000 |

6. Tracer scalabilité forte et faible

![image](TempsCalcul.png)

7. Comparer avec le code Pi.java

   | Number Worker M1/M2 | 1 /1     | 2/1      | 3 /1     | 1/10     | 2/ 10    | 3/10     | 1/100    | 2/100    | 3/100    | 1/1000   |
   |---------------------|----------|----------|----------|----------|----------|----------|----------|----------|----------|----------|
   | Temps d'execution   | 655ms    | 710ms    | 724ms    | 936ms    | 1155ms   | 1653ms   |          |          |          |          |
   | totalCount          | 16000000 | 16000000 | 16000000 | 16000000 | 16000000 | 16000000 | 16000000 | 16000000 | 16000000 | 16000000 |


<br>


Quand on run un fichier ('on le run' |>), on crée une chaine de compilation qui:
- génére un fichier de configuration        |argument d'entrée port 25545
  - avec dépendence                         |
  -> Run -> Configuration Run -> program argument
                              -> Allow multiple intance
- compile
- execute

## 06/12/2024

On fait le Rapport

On installe JAVA sur Centos pour pourvoir faire des en Mémoire distribué entre 2 ordi



  




  



