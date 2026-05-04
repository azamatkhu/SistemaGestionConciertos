# PRACTICA GLOBAL PARA LA 2ª EVALUACIÓN

**Descripción: Desarrolla una aplicación en Java que permita gestionar los
conciertos ofrecidos por artistas y grupos musicales a lo largo de un año. La
aplicación debe permitir gestionar información sobre artistas, conciertos y ventas
de entradas utilizando una base de datos Oracle.**

## Explicacion

El programa pide por el teclado los datos de usuario. Podemos acceder al menu atraves de la consola, poniendo numeros de opciones.

Luego, el programa lee este numero y con un switch redirige el bucle whule hacia las tres seccions como Artistas, Conciertos o Entradas.

He hecho tres metodos, como ManejarArtista(), ManejarConcierto() y ManejarEntrada(), que estan encargados en manejar las operaciones con tabla, como
Insercion, eliminacion y listar.

Para cada uno de operacion se utiliza otro switch dentro del metodo, para manejar mejor los statements con consultas, que estan encargados en los manejos especificos
y en listar registros se utiliza Resultset, para mostrar los resultados.

## Como Ejecutar?

Al principio necesitamos tener creado las tablas ARTISTA, CONCIERTO y ENTRADA con su estructura en la base de datos.

1. Por el teclado, nos pide elegir la seccion, utilizando numeros de opciones (1. Artista, 2. Concierto, 3. Entradas, 0. Salir). Elegimos uno de esas opciones.
2. En la seccion elegida pide otras opciones de manejo (1. Añadir, 2. Eliminar, 3. Listar). Elegimos uno de esas opciones.
3. Dependiendo de la opcion elegida, seguir las instrucciones que nos dice el programa, introduciendo los datos necesarios.
4. Al final, nos muestra el resultado querido.
