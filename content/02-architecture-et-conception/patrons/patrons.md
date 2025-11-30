+++
pre = '<b>2.4 </b>'
title = "Les patrons de conceptions"
weight = 4
draft = false 
+++

Les **patrons de conception GoF** (Gang of Four) sont des solutions **réutilisables** à des problèmes récurrents de conception logicielle, classées par **création**, **structure** et **comportement**. Ils offrent un vocabulaire commun (noms, intentions) pour rendre le code **plus clair**, **testable** et **évolutif**.

Les plus connus classés en patrons de création (comment créer les objets : Singleton, Factory Method, Abstract Factory, Builder, Prototype), patrons structurels (comment composer/relier les objets : Adapter, Decorator, Facade, Composite, Proxy, Bridge, Flyweight), et patrons comportementaux (comment les objets collaborent/échangent : Strategy, Observer, Command, Template Method, Iterator, Mediator, Memento, Visitor, Chain of Responsibility, Interpreter).
Ils offrent un vocabulaire commun pour rendre le code plus clair, testable et évolutif.
<!-- Les plus connus : ***Singleton***, ***Factory Method***, ***Abstract Factory***, ***Prototype***, ***Adapter***, ***Decorator***, ***Facade***, ***Composite***, ***Proxy***, ***Strategy***, ***Observer***, ***Command***, ***Template Method***, ***Iterator***, ***Mediator***, ***Memento***, ***Chain of Responsibility***. -->

À travers ce module, nous allons **mettre en place** les patrons suivants :
- *Singleton* : garantir **une seule instance** partagée.
- *Factory Method* : **créer le bon objet** selon un **type**.
- *Strategy* : **changer d’algorithme** sans toucher au code client.

---

### 1) Singleton
**Idée** : on veut **une et une seule instance** d’une classe (ex. configuration, registre, cache).

**Quand c’est utile ?**
- **État unique** global (ex. *registry*, *config*).
- Gestion de **ressources coûteuses** (ex. client externe).
<!-- **Attention (pièges)**
- **Global mutable state** → difficile à tester, peut créer des couplages cachés.
- En **Spring**, on préfère **laisser le conteneur** gérer le singleton (scope par défaut). -->

<!-- > Contexte Spring : par défaut, un `@Service` / `@Repository` est un **singleton Spring** (une instance par application). On verra la différence entre **singleton “code”** (pattern) et **singleton “contexte”** (scope Spring). -->

##### UML (référence)
{{< figure
    src="https://refactoring.guru/images/patterns/diagrams/singleton/structure-fr.png"
    alt="Structure du patron Singleton"
    caption="[Refactoring.Guru — Singleton (FR)](https://refactoring.guru/fr/design-patterns/singleton)"
>}}

##### Implémentation (pseudo-code)
*Adapté du tutoriel :* **Refactoring.Guru — Singleton (FR)**  

```java
// La classe Database expose la méthode statique `getInstance`
// qui donne accès à LA MÊME instance de connexion partout
// dans le programme.
class Database is
    // Le champ qui stocke l'instance du singleton doit être `static`.
    private static field instance: Database

    // Le constructeur est privé pour empêcher l'usage de `new`.
    private constructor Database() is
        // Initialisation (ex.: connexion au serveur de BD, pool, etc.)
        // ...

    // La méthode statique qui contrôle l'accès à l'instance unique.
    public static method getInstance() is
        if (Database.instance == null) then
            acquireThreadLock() and then
                // Une fois le verrou acquis, re-vérifier que
                // l'instance n'a pas été créée par un autre thread.
                if (Database.instance == null) then
                    Database.instance = new Database()
        return Database.instance

    // Le singleton peut également embarquer une logique "métier".
    public method query(sql) is
        // Ici, toutes les requêtes passent : idéal pour logs,
        // limitations, cache, métriques, etc.
        // ...

class Application is
    method main() is
        Database foo = Database.getInstance()
        foo.query("SELECT ...")
        // ...
        Database bar = Database.getInstance()
        bar.query("SELECT ...")
        // Note : `bar` référence le MÊME objet que `foo`.

```

##### En démo “compte en banque” : pourquoi une instance partagée ?
Le **problème (naïf)** : deux contrôleurs/services instancient chacun un `BankAccount` → deux **soldes divergents**. On impose donc une seule instance partagée pour garantir un état unique.
<!-- code ? -->

<!-- donner l'exemple du catalogue dans le TP et le montrer en diag -->

--- 

### 2) Factory Method (ou Simple Factory)
**Idée** : centraliser la **création d’objets** selon un **type** pour **éviter des `if/else`** partout et **découpler** le code client de la construction concrète.

**Quand c’est utile ?**
- Lorsque qu'il faut choisir une implémentation selon un paramètre (ex. un niveau de difficulté).
- Afin de **masquer la logique de construction** (mapping, validations, dépendances) et **simplifier le client**.
- Quand de **nouvelles variantes** de produit apparaissent régulièrement (ou par plugin).

##### UML (référence)
{{< figure
    src="https://refactoring.guru/images/patterns/diagrams/factory-method/structure-2x.png?id=9ea3aa8a47f8be22e12e523c15b448fd"
    alt="Patron Factory Method — UML (Refactoring.Guru)"
    caption="[Refactoring.Guru — Factory Method (FR)](https://refactoring.guru/fr/design-patterns/factory-method)"
>}}

##### Implémentation (pseudo-code)
*Adapté du tutoriel :* **Refactoring.Guru — Factory Method (FR)**  
<!-- ici code template  -->
**Version “Factory Method” (classe abstraite + surcharge)**
```java
// 1) Le "Produit" : interface commune aux variantes
interface Product is
    method use()

// 2) Produits concrets
class ConcreteProductA implements Product is
    method use() is
        // ...

class ConcreteProductB implements Product is
    method use() is
        // ...

// 3) Le "Créateur" : déclare la factoryMethod que les sous-classes redéfinissent
abstract class Creator is
    // La factoryMethod retourne un Product (mais pas la variante concrète)
    abstract method factoryMethod(): Product

    // Logique commune qui s'appuie sur le contrat Product
    method doWork() is
        Product p = this.factoryMethod()
        p.use()
        // ... (pipeline commun)

// 4) Créateurs concrets : décident QUEL produit instancier
class ConcreteCreatorA extends Creator is
    method factoryMethod(): Product is
        return new ConcreteProductA()

class ConcreteCreatorB extends Creator is
    method factoryMethod(): Product is
        return new ConcreteProductB()
```
**Version “Simple Factory” (centralisation dans une fonction)**
```java 
// Variante plus simple : une fonction/fabrique qui choisit l'implémentation
class SimpleFactory is
    static method of(type: string): Product is
        switch (type.toUpperCase())
            case "A": return new ConcreteProductA()
            case "B": return new ConcreteProductB()
            default: throw new Error("Type inconnu: " + type)

```

<!-- Voir video : https://www.youtube.com/watch?v=EdFq_JIThqM -->
<!-- Ennemies example ; https://www.youtube.com/watch?v=lLvYAzXO7Ek -->

##### En démo “type de prêt”
Une factory `LoanFactory` reçoit un type (MORTGAGE, AUTO, PERSONAL) et **instancie le bon produit** (Loan) avec ses règles (APR, frais) pour **éviter des if/else** partout.

--- 

### 3) Strategy
**Idée** : extraire un **algorithme** derrière une **interface** ; on choisit la **stratégie** au *run-time* (paramètre, config) sans modifier le code client.

**Quand c’est utile ?**
- Lorsqu’une **règle varie** selon un **contexte** (ex. frais, remise, pénalité, tri, sérialisation).

##### UML (référence)
{{< figure
    src="https://refactoring.guru/images/patterns/diagrams/strategy/structure-2x.png"
    alt="Patron Strategy — UML (Refactoring.Guru)"
    caption="[Refactoring.Guru — Strategy (FR)](https://refactoring.guru/fr/design-patterns/strategy)"
>}}

##### Implémentation (pseudo-code)
*Adapté du tutoriel :* **Refactoring.Guru — Strategy (FR)**

```java
// 1) Contrat des stratégies (algorithmes interchangeables)
interface Strategy is
    method execute(input): Output

// 2) Stratégies concrètes (variantes)
class ConcreteStrategyA implements Strategy is
    method execute(input) is
        // Algorithme A ...
        return resultA

class ConcreteStrategyB implements Strategy is
    method execute(input) is
        // Algorithme B ...
        return resultB

// 3) Contexte : utilise une stratégie, injectable et remplaçable
class Context is
    private field strategy: Strategy

    constructor Context(s: Strategy) is
        this.strategy = s

    method setStrategy(s: Strategy) is
        this.strategy = s

    method doWork(input): Output is
        // Logique commune + délégation de l'algorithme à la stratégie
        return strategy.execute(input)

```

##### En démo “méthodes de paiement”
Une interface `PaymentProcessor` (contrat) et plusieurs stratégies (CARD, CASH, PAYPAL) ; **le contexte choisit la stratégie au run-time** sans modifier le code client.
<!-- Le client dépend du contrat (Strategy), pas des implémentations concrètes.
On peut ajouter de nouvelles stratégies sans modifier le code client (OCP).
Choix au run-time (paramètre, config, plugin) ou par un factory en amont. -->

<!-- https://www.youtube.com/watch?v=ub0DXaeV6hA -->