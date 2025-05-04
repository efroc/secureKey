/============ C'est quoi ? ===========/
Une application de gestion de mots de passe

/============= Utilité ? =============/
Pour éviter de s'en souvenir et de les perdre

/=========== C'est pas safe ==========/
=> enregistrement dans un fichier texte quelconque en local
=> "cryptage" du fichier en sauvegarde
=> "décryptage" du fichier en lecture 

/============= Structure =============/
Sous forme de Map<String, Pair<String, String>>
Exemple :
=> <Capgemini, (username, password)>