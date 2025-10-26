+++
pre = '<b>2.3 </b>'
title = "MVC"
weight = 3
draft = false 
+++

**MVC** signifie **Model – View – Controller**.
C’est un **patron architectural** qui **sépare les responsabilités** d’une application :

- **Modèle (Model)** : représente les **données** et les **règles métier** du domaine (entités, validations, calculs).
- **Vue (View)** : s’occupe de la **présentation** pour l’utilisateur (page HTML, JSON en REST, PDF, etc.).
- **Contrôleur (Controller)** : reçoit la **requête**, **valide** les entrées, **orchestre** le traitement vers le modèle (via un service), puis **choisit** la vue/réponse.

Idée clé : le **contrôleur n’embarque pas** la logique métier, la **vue n’accède pas** à la base de données, et le **modèle** est **indépendant** de la présentation.
<!-- L’idée : **le contrôleur ne contient pas la logique métier**, la **vue ne parle pas à la BD**, et le **modèle** ne connaît pas la présentation. -->

![MVC](/420-310/images/mvc.png)

**Le cycle d’une requête (exemple)**
1. Le **client** envoie `GET /produits?categorie=camera`.  
2. Le **Controller** correspond à la route et **valide** les paramètres.  
3. Il appelle le **Model** (souvent via un **service métier**) pour exécuter la règle.  
4. Le **Model** lit/écrit en BD (via un composant d’accès aux données).  
5. Le **Model** retourne un **résultat** (ex. liste de produits).  
6. Le **Controller** choisit la **View** qui formate la sortie (**HTML** ou **JSON** en **REST**) et renvoie la **réponse HTTP** (codes 200/201/404…).


### Pourquoi utiliser MVC ?
- **Lisibilité** : on sait **où** mettre le code (cloisonnement clair).
- **Testabilité** : tester le **Model** sans HTTP, tester le **Controller** avec des **mocks** du service.
- **Évolutivité** : on peut faire évoluer l’**UI** sans casser le **métier**, et inversement.
  
**Les bonnes pratiques (niveau cours)**
- Conserver un **flux à sens unique** : `Controller → Service/Model → (Données)` → **View**.  
- Introduire un **service métier** quand les règles deviennent nombreuses.  
- **Jamais** d’accès BD dans la **View** ; **peu** de logique dans le **Controller** (orchestration seulement).

### Où se place MVC selon l’architecture ?**
- **Monolithique** : tout est déployé ensemble, **MVC** structure l’intérieur (couches claires).
- **N-tiers** : l’**API REST** est la frontière **Frontend ↔ Backend** ; **à l’intérieur du backend**, on applique **MVC**.
- **Microservices** : **chaque service** applique son **mini-MVC** (contrôleur REST, service/métier, accès données).

> À suivre : mise en place de **Spring Boot (Spring Web MVC)** avec un contrôleur REST, un service métier et un repository JPA.

--- 
### En pratique 

**Spring** est un écosystème Java (injection de dépendances, AOP, données, web…) pour **structurer** proprement une application. **Spring Boot** en est la version « turbo » : il fournit l’**auto-configuration**, des dépendances **starters** et une exécution **prête à l’emploi** (*embedded* Tomcat), ce qui permet de lancer un service web REST en quelques fichiers.

Avec **Spring Web MVC**, les rôles MVC se mappent à des annotations simples :
- `@Controller` / `@RestController` → **controller** (reçoit la requête et renvoie la réponse avec les **codes HTTP**)
- `@Service` → **service métier** (règles et orchestration)
- `@Repository` → **accès aux données** (via JPA/Hibernate)

1) Le **Model** (côté Spring)<br>
À travers ce cours, on appelle **Model** tout ce qui représente le **domaine** :  
les **entités** persistées (JPA), parfois des **DTO** pour l’API, et les **règles** implémentées en **services**.

- **Entité JPA** : classe Java mappée à une table BD (id, colonnes).
- **Repository** : interface pour CRUD (hérite de `JpaRepository`).
- **Service** : où résident les **règles métier** (validation, scénarios).

2) Le **Contrôleur** (côté Spring)<br>
Le **Contrôleur** reçoit la **requête HTTP**, **valide** les entrées, appelle le **service métier** puis **renvoie la réponse** (corps + **code HTTP**).<br>
**Annotations clés** : 
  - `@RestController` + `@RequestMapping("/api/…")` : contrôleur REST (réponse JSON par défaut).
  - `@GetMapping`, `@PostMapping`, `@PutMapping`, `@PatchMapping`, `@DeleteMapping` : routes par verbe HTTP.
  - `@PathVariable`, `@RequestParam`, `@RequestBody`, `@Valid` : lier et valider les données d’entrée.
  - `ResponseEntity<?>` : contrôler le **code** (200/201/204/404…) et les **en-têtes** (ex. `Location`).

1) La **Vue** (côté Spring)<br>
La Vue est ce que l’on renvoie au client.
Avec une API REST, la vue est généralement du JSON ; dans une app serveur rendue côté serveur, ce sera un template (ex. Thymeleaf).

<!-- > MVC en REST : la « **View** » est généralement le **JSON** renvoyé par le contrôleur. -->
<!-- 
EXEMPLE : 
## 3) Exemple guidé : « Items de catalogue »

### 3.1 Entité (Model)
```java
package com.example.catalog.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
public class Item {
  @Id @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @NotBlank private String name;
  private String category;

  @NotNull @PositiveOrZero
  private BigDecimal price;

  @PositiveOrZero
  private int stock;

  // getters/setters (ou Lombok @Data)
}

3.2 Repository
package com.example.catalog.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, String> {
  List<Item> findByCategoryIgnoreCase(String category);
  List<Item> findByNameContainingIgnoreCase(String q);
}

3.3 Service métier
package com.example.catalog.service;

import com.example.catalog.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemService {
  private final ItemRepository repo;
  public ItemService(ItemRepository repo) { this.repo = repo; }

  public List<Item> list(String q, String category){
    if (q != null && !q.isBlank()) return repo.findByNameContainingIgnoreCase(q);
    if (category != null && !category.isBlank()) return repo.findByCategoryIgnoreCase(category);
    return repo.findAll();
  }
  public Item get(String id){ return repo.findById(id).orElseThrow(); }
  public Item create(Item in){ return repo.save(in); }
  public Item update(String id, Item in){
    Item it = get(id);
    it.setName(in.getName());
    it.setCategory(in.getCategory());
    it.setPrice(in.getPrice());
    it.setStock(in.getStock());
    return repo.save(it);
  }
  public void delete(String id){ repo.deleteById(id); }
}

3.4 Contrôleur REST (Controller)
package com.example.catalog.api;

import com.example.catalog.domain.Item;
import com.example.catalog.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {
  private final ItemService service;
  public ItemController(ItemService service) { this.service = service; }

  @GetMapping
  public List<Item> list(@RequestParam(required=false) String q,
                         @RequestParam(required=false) String category){
    return service.list(q, category);
  }

  @GetMapping("/{id}")
  public Item get(@PathVariable String id){ return service.get(id); }

  @PostMapping
  public ResponseEntity<Item> create(@Valid @RequestBody Item in){
    Item saved = service.create(in);
    return ResponseEntity.created(URI.create("/api/items/" + saved.getId())).body(saved);
  }

  @PutMapping("/{id}")
  public Item update(@PathVariable String id, @Valid @RequestBody Item in){
    return service.update(id, in);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id){
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}

4) Config rapide (H2 mémoire pour le TP)

src/main/resources/application.properties

spring.datasource.url=jdbc:h2:mem:catalogdb;MODE=PostgreSQL;DB_CLOSE_DELAY=-1
spring.datasource.driverClassName=org.h2.Driver
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
spring.jpa.open-in-view=false

5) Remplir des données de test avec Mockaroo (a.k.a. « emocaroo »)

Pour avoir un jeu d’items réaliste sans tout saisir à la main :

Va sur mockaroo.com (générateur de données).

Crée des champs : name (Product Name), category (Custom List : Camera, Lens, Audio…),
price (Number / Decimal 2), stock (Number 0–500).

Exporte CSV (ex. items.csv).

Option A — Script d’initialisation SQL
Place un fichier data.sql dans src/main/resources/ :

INSERT INTO item(id, name, category, price, stock) VALUES
  (RANDOM_UUID(), 'Caméra 4K', 'Camera', 1299.99, 12),
  (RANDOM_UUID(), 'Micro shotgun', 'Audio', 199.00, 35);
-- Pour gros volumes, préfère Option B











<!-- 
### En pratique (avec Spring boot)

model cest java class
## Transition vers **Spring Boot**
  

Dans la **prochaine page**, on met en place **pas à pas** :  
1) contrôleur REST minimal, 2) service métier, 3) repository JPA, 4) codes HTTP corrects (200/201/204/404), 5) test rapide.

**MVC** = **Model – View – Controller**  
- **Controller** : reçoit la requête HTTP, valide, choisit le code de statut, appelle le service.  
- **Service (métier)** : applique les règles, orchestre les opérations.  
- **Repository (accès données)** : lit/écrit en BD (via JPA).  
> En REST, la *View* est souvent un **JSON** renvoyé par le contrôleur.

TP Spring Boot MVC (mains dedans)

@RestController → Service → Repository ; validations, codes HTTP.

### Spring 


c'est quoi Spring : framework pour build java application en components 
Spring boot layer sur le frame work pour faciliter le lancement donc avc des ready to use 
pleins d'autres sprigs come data etc

en place 
latest version of jdk 
intelig avc maven build in 
2 manière de start : sur le site start.spring.io et choisir les proprriétés 
ou direct sur intellij

strcutrue du projet 
.idea configuration à ne pas toucher 
.mvn wrapper pr run le proejt sans l'avoir sur la machine, assure onsisten maven build sur plsuieurs env (machines)
help pr instruction pr demarrer
pom.xml (comme html) pr config 
src 
- main notre code 
  - java et 
    - fichier qui esr un entry point de l'app 
  - ressosurces config 
- tests 

parler de maven central pour les dependecies 
spring-boot starter web 
ajouter ca : <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <version>4.0.0-RC1</version>
</dependency>

reload maven project 

ou ctrl + n 


Les stéréotypes des composants Spring
Stéréotype  	Description                         
@Component	Un type générique pour tous les composants gérés par Spring (beans).
@service	Méta-annotation des marqueurs pour les composants de la couche de service. Actuellement, Spring traite cela de la même manière que @Component, sans fonction spéciale.
@Repository	Utilisé comme DAO dans votre couche de persistance. Les bibliothèques Spring Data fournissent des fonctionnalités supplémentaires.
@Controller	Gère les points de terminaison Web MVC afin de traiter les requêtes HTTP mappées vers des URL spécifiques.
@RestController	Un contrôleur spécialisé pour les services Web RESTful, qui fait partie de Web MVC. C'est une méta-annotation qui combine @Controller et @ResponseBody. --> 
