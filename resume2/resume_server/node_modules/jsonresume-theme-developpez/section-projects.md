# section `projects`

Cette section n'existe pas dans le schéma json officiel et [l'ajout de propriétés à la racine est interdit par le schéma](https://github.com/jsonresume/resume-schema/blob/v1.0.0/schema.json#L5). 

Cette [pull request](https://github.com/francescoes/jsonresume-theme-stackoverflow/issues/15) ajoute son support mais la présence des données correspondantes dans le `resume.json` le rend invalide.

Pour tester cette section, ajouter le bloc ci-dessous au `resume.json` :

```json
"projects": [
        {
            "name": "LE projet",
            "startDate": "2013-01-02",
            "location": {
                "city": "Paris",
                "countryCode": "FR",
                "region": "France"
            },
            "url": "http://www.le-projet.com",
            "keywords": [
                "blablabla",
                "bliblibliblibli"
            ],
            "summary": "Le projet n'est pas un projet mais LE projet ...",
            "highlights": [
                "Récompensé 'projet du mois'"
            ]
        },
        {
            "name": "LE projet",
            "startDate": "2013-01-02",
            "endDate": "2013-01-01",
            "location": {
                "city": "Paris",
                "countryCode": "FR",
                "region": "France"
            },
            "url": "http://www.le-projet.com",
            "keywords": [
                "blablabla",
                "bliblibliblibli"
            ],
            "summary": "Le projet n'est pas un projet mais LE projet ...",
            "highlights": [
                "Récompensé 'projet du mois'"
            ]
        }
    ],
```
