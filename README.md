# SuperDuo
This is the repository for the Alexandria and Football Scores apps.
## Building Football Scores
You need to fill in your own API key to access the web services provided by football-data.org. Once you fill out the form on their web site to get your own API key, you will need to get this API key into the source code so that it can be seen as a string resource.

the way that I am doing it is that my gradle.properties file is not in the source code repository, so like me you can go into your gradle.properties file and create a line like this, where you replace INSERT_YOUR_API_KEY_HERE with the actual API key you get from the web site:

```
FOOTBALL_DATA_API_KEY=INSERT_YOUR_API_KEY_HERE
```
