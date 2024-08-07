IMPORTANTE:

- CONFIGURAR EL ARCHIVO .ENV:
  
  He dejado un template de mi env por motivos de seguridad. deberas poner tu usuario, contraseña y db_source, lo demás ya esta configurado en el archivo 'aplication.properties'.


  
- MONTAR UNA IMAGEN DE POSTGRES EN DOCKER:
  
  Dejé un archivo YML, para montar una imagen de postgres dentro de un contenedor en docker, usé el puerto 5432(por defecto por postgreSQL).



AL PROBAR EL API.

-Primero se deberá de crear las categorias para que funcione correctamente el crud(Se recomienda usar POSTMAN)
EJEMPLO : 

 
 **** Primer paso. Hacer un post en categorias. ****
 

//POST//

http://localhost:8080/categorias

```
{
    "nombre": "procesadores"
}
```



**** Segundo paso. Hacer un post en productos. ****



//POST//

http://localhost:8080/productos

```
{
    "nombre": "Procesador ryzen 5 5600x",
    "cantidad": 50,
    "precio": 550.90,
    "descripcion": "Nucleos desbloqueados, se vende por promocion a 430.",
    "categoria":{
        "id":1   //En caso que sea 1.
    }
}
```


**** Con esto ya se podría realizar los demás metodos principales HTTP. ****  



Para este proyecto usé TablePlus. para hacer peticiones SQL, ofrece gran flexibilidad.


Herramientas, tecnologias usadas: Spring Boot, Hibernate(JPA ORM), PostgreSQL, TablePlus, Postman y como no... Github:). 
IDE : Intellij IDEA.
