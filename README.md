# Activitat A02 UF4: Cambiem l'accés a dades de l'aplicació MVC library
## Documentació les proves

## Algunes preguntes:
### Per què al servei estem utilitzant mètodes que no hem declarat explícitament al repositori? Com és possible?
Spring ja té mètodes CRUD, llavors quan extenem CrudRepository podem fer ús d'ells sense tenir que declarar la seva lògica al codi.
També es poden crear mètodes seguint els noms dels querys comuns (query methods), com findByTitol() o findByAutor() (els que es van utilitzar al codi). Per tant,
Spring llegeix el nom del mètode i genera la consulta automàticament.

### El repositori pot elegir fer l’extends de les interfícies PagingAndSortingRepository o de JpaRepository. En què es diferencien aquestes dues amb la interfície CrudRepository?
El CrudRepository dona quearys CRUD que son create, read, update i delete. Per l'altre banda PagingAndSortingRepository extén de CrudRepository i afegeix els mètodes per paginació i ordenació.
I JpaRepository extén PagingAndSortingRepository i afegeix funcionalitats específiques de JPA. Per tant una pot utilitzar les funcionaalitats de l'altre ja que extenen entre elles.

### Què significa Optional<Classe> i per a què serveix?
És basicament un contenidor que pot o no contenir un valor no nul. Això vol dir que amb aquest valor es pot evitar excepcions de valors nulls. 
És a dir, que es gestiona el cas que no hi hagi un valor.

### Per què el controlador utilitza el servei i no la seva implementació? 
Perquè permet fer injeccions de dependències. Basicament perquè el controlador depèn d'altres interfícies en lloc d'implementacions de codi quan no fa falta.
