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




  



