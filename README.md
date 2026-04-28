# PRACTICA GLOBAL PARA LA 2ª EVALUACIÓN

**Descripción: Desarrolla una aplicación en Java que permita gestionar los
conciertos ofrecidos por artistas y grupos musicales a lo largo de un año. La
aplicación debe permitir gestionar información sobre artistas, conciertos y ventas
de entradas utilizando una base de datos Oracle.**

El programa pide por el teclado los datos de usuario. Podemos acceder al menu atraves de la consola, poniendo numeros de opciones.

Luego, el programa lee este numero y con un switch redirige el bucle whule hacia las tres seccions como Artistas, Conciertos o Entradas.

He hecho tres metodos, como ManejarArtista(), ManejarConcierto() y ManejarEntrada(), que estan encargados en manejar las operacione con tabla, como
Insercion, eliminacion y listar.

Para cada uno de operacion se utiliza otro switch dentro del metodo, para manejar mejor los statements con consultas, que estan encargados en los manejos especificos
y en listar registros se utiliza Resultset, para mostrar los resultados.
