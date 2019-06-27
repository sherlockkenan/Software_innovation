# Thème [developpez.com](https://www.developpez.com/) pour les [JSON resume](https://github.com/jsonresume) [![npm version](https://badge.fury.io/js/jsonresume-theme-developpez.svg)](http://badge.fury.io/js/jsonresume-theme-developpez)

## Sources

Basé sur le thème [Stack Overflow](https://github.com/francescoes/jsonresume-theme-stackoverflow) de Francesco Esposito.

## Exemple

Mon CV personnel utilise ce thème. Il est consultable sur [cv.marc-loupias.fr](http://cv.marc-loupias.fr/).

## Usage

Ce thème est à utiliser dans votre propre projet de création de CV en tant que dépendance de développement conjointement avec le [CLI de jsonresume](https://github.com/jsonresume/resume-cli).

```bash
npm i -D jsonresume-theme-developpez
```

### installation du CLI

**Important**, on parle ici de l'installation du CLI dans votre projet de création de CV, pas pour contribuer à ce thème.

Le CLI du projet [jsonresume](https://github.com/jsonresume) est utilisé en version `1.1.1`.
 
Le mainteneur du CLI n'a pas tag cette version dans le repository de [jsonresume](https://github.com/jsonresume) mais le livrable correspondant est disponible [sur le registre npm](https://www.npmjs.com/package/resume-cli/v/1.1.1). 

La bonne méthode d'installation du CLI re-devient donc normale :

```bash
npm i -D resume-cli
```

L'export PDF est actif dans cette version via par exemple `npx -p node@latest -- node node_modules/.bin/resume export cv.pdf --format pdf --theme developpez`.

## Contribuer

### Installation

```bash
npm install
```

### Serveur de développement

Il s'agit ici de développer ce thème et non votre propre CV.

```bash
npm start
```

Vous devriez voir ce message :

```bash
Preview: http://localhost:4000
Press ctrl-c to stop
```

Le site est généré dans le répertoire `public/` lors du premier accès via votre navigateur.

### Les données du CV

Un fichier `resume.json` est situé à la racine du projet. Il respecte la structure du [schéma json](https://jsonresume.org/schema/).

La commande `npm test` permet de valider le fichier `resume.json` avec le schéma json.

Ce fichier est présent à des fins de tests et de développement, il n'est présent que dans le repository et pas dans le livrable du registre npm.

### Icônes des réseaux sociaux

**Profils supportés avec leurs couleurs :**

github, stack overflow, linkedin, dribbble, twitter, facebook, pinterest, instagram, soundcloud, wordpress, youtube, flickr, google plus, tumblr, foursquare.

La propriété `network` de la section `profiles` permet de définir le réseau social.

#### Support de propriétés supplémentaires

Les ajouts du [jsonresume-theme-stackoverflow](https://github.com/francescoes/jsonresume-theme-stackoverflow) ont été conservés :

- `keywords` pour chaque objet `work`, `publication` et `volunteer`
- `summary` pour chaque objet `interests`, `education`
- `location` pour chaque objet `work`, `education` et `volunteer`
- `birth` pour `basics`

Exemple avec l'objet `location` : 

```json
"location": {
  "city": "Paris",
  "countryCode": "FR",
  "region": "France"
} 
```

Exemple avec l'objet `birth` :

```json
"birth": {
  "place": "Paris",
  "state": "France",
  "date": "1988"
}
```

### i18n

Le thème d'origine a été modifié pour supporter le français (et uniquement le français, le thème d'origine ne supportant qu'une seule langue).

*French resume*

## License

[MIT license](http://opensource.org/licenses/mit-license.php).
