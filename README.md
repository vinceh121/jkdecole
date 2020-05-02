# jkdecole
![GitHub](https://img.shields.io/github/license/vinceh121/jkdecole)

Unofficial Java library to interact with Kdecole instances through the mobility API

## How to use

Add the dependency to your Maven-compatible build system using [Jitpack](https://jitpack.io/#vinceh121/jkdecole)

And use the following example to get your homeworks

```java
final JKdecole jk = new JKdecole();

jk.login("username", "password", true);
jk.sendStarting(); // recommended for certain endpoints but not necessary

List<Article> news = jk.getNews();
System.out.println(news);
```
## Notes on developement

Kdecole is proprietary software, as such I do not have all the required ressources to map the API endpoints.
A draft of the API specification is available on the [wiki](https://github.com/vinceh121/jkdecole/wiki/API-Definiton)
