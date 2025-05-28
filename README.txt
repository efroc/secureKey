/=========================== C'est quoi ? ==========================/
Une application de gestion de mots de passe, pour retenir les mots de 
passe en un seul fichier .txt 
On utilise la console et on suit les instructions

/========================== C'est pas safe ? =======================/
=> enregistrement dans un fichier texte quelconque en local
=> "cryptage" du fichier en sauvegarde
=> "décryptage" du fichier en lecture 

/============================ Structure ============================/
Sous forme de ArrayList<Triple<String,String,String>>
Exemple :
=> <(Capgemini,username, password)>
ArrayList à l'avantage d'être très simple à manipuler.

/======================= Outils java utilisés ======================/ 
=> Scanner pour l'utilisation de la console
=> ArrayList et Triple pour la structure de données
=> Lecture et Ecriture (InputStream, OutputStream) pour la manipulation
    des fichiers
=> File pour accès aux fichiers et répertoires locaux

/==================== Fonctionnalités à ajouter ====================/ 
=> cryptage et décryptage des données en fichier de sauvegarde
=> création d'un nouveau fichier de sauvegarde (autre que data.txt par défaut)
=> interface graphique (un peu chiant à faire, Swing c'est pas fun)

/======================= Cryptage, décryptage ======================/
Ps : ce n'est toujours pas implémenté
Ce sera sûrement un décalage dans le code ASCII pour convertir chaque
caractère en un autre.
A voir...