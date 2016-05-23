Programación Orientada a Objetos – Curso 2015/2016
Práctica Obligatoria Grupal POO 2015/2016: "Elecciones"
NOTA:- Respecto al enunciado de la entrega de diseño, la información añadida que hay que tener en cuenta para la implementación aparecerá en cursiva y la información suprimida (que no hay que tener en cuenta) aparecerá tachada.
Se pide realizar el diagrama de clases UML de un proyecto informático que permita la gestión de diferentes partidos políticos, así como su participación en procesos electorales.
 Un partido político tiene un nombre, unas siglas, un logo, un secretario general y un conjunto de votantes. Los votantes se dividen en militantes y simpatizantes. Los simpatizantes pueden pertenecer a más de un partido.
 Los votantes tienen nombre, apellidos y datos personales (edad, profesión, género). Los militantes tienen, además, una cuota a pagar y un carné.
 Los partidos pueden presentarse a elecciones. En cada elección se divide el territorio de voto en diferentes circunscripciones (pudiera ser sólo una). En cada circunscripción se ponen en juego un número determinado de escaños (al menos uno). El resultado de las elecciones corresponderá a la suma de los resultados de cada circunscripción.
o Existirá un número total de escaños a repartir, en todo el territorio. Este número será configurable. El número de escaños asignados a cada circunscripción será proporcional al número de habitantes que la circunscripción tenga.
o Los resultados electorales se podrán introducir a mano, indicando el porcentaje de participación, además del número de votos obtenido por cada formación política, junto con los votos nulos y votos en blanco. También será posible simular estos resultados de forma que se calculen de forma aleatoria.
 En el marco de una elección, de entre los militantes de un partido saldrán las listas de candidatos para cada circunscripción. Estas listas estarán formados, por tantas personas como escaños reparta la circunscripción. Una vez realizado el recuento de votos se calcularán los escaños asignados a cada partido, y las personas que, procedentes de las listas, ocuparán esos escaños, de acuerdo al sistema D´Hondt, usando sólo las candidaturas que alcancen al menos el 3% de los votos válidos (ver anexo al final del documento).
o Las listas de militantes de los partidos (para cada circunscripción) se podrán introducir en el sistema a través de ficheros de texto. Opcionalmente también será posible hacerlo a través de formularios en la interfaz gráfica.
 Los partidos se podrán presentar a las elecciones en coalición. En ese caso se formarán listas conjuntas, utilizando la proporción correspondiente de las listas originales de cada partido1.
1 Si la coalición está formada por dos partidos, la primera mitad de cada lista. Si son tres, el primer tercio, y así sucesivamente.
Programación Orientada a Objetos – Curso 2015/2016
 Debe ser posible consultar los resultados de un proceso electoral (participación, votos, porcentaje y escaños obtenidos por cada formación). Además, de forma adicional debe ser posible consultar los diputados electos concretos, indicando para cada uno de ellos la formación a la que pertenecen y la circunscripción a la que representan. Toda esta información debe poder ser visualizada por pantalla y también en un fichero de texto.
 Debe ser posible consultar los resultados que ha obtenido un partido político o coalición en diferentes procesos electorales, comprobando su evolución. Si un partido se ha presentado en coalición, el sistema ofrecerá los resultados conjuntos, advirtiendo tal circunstancia.
 Debe ser posible, a partir de los resultados de un proceso electoral, ofrecer las combinaciones de partidos o coaliciones que otorgan mayoría absoluta.
 Debe ser posible enviar encuestas a los votantes de un partido. Estas encuestas tendrán preguntas diferenciadas para los simpatizantes y para los militantes del partido. En la práctica bastará con que las encuestas sean simples cadenas de caracteres, eso sí, claramente diferenciadas entre los simpatizantes y los militantes.
La aplicación tendrá que implementar el diagrama de clases que se facilita a continuación:
Programación Orientada a Objetos – Curso 2015/2016
Además de realizar lo especificado se deberá incorporar a la aplicación las siguientes características:
 Presentación de todas las funcionalidades de la aplicación mediante una interfaz gráfica simple. Se aceptará la presentación del programa mediante una interfaz de usuario en modo texto, pero en este último caso el ejercicio sólo podrá alcanzar una nota máxima de 7.
 Guardado y recuperación de todos los datos en disco. Se podrán guardar los datos en un fichero binario (serializado) del que se podrá elegir el nombre. También se permitirá la carga de los datos desde un fichero binario (serializado), del que se podrá elegir el nombre.
Entrega:
 La práctica se realizará en grupos de tres personas (los grupos ya formados).
 La entrega la realizará únicamente el portavoz del grupo, a través del Campus Virtual (sólo se abrirán y corregirán los trabajos enviados por el portavoz) y en el plazo que allí se indique.
Material a entregar:
Se enviará un archivo en formato comprimido que contenga:
- Todos los archivos fuentes (.java y .form).
- Un archivo ejecutable de java (.jar) para lanzar la aplicación.
- Un archivo binario donde se encuentren datos cargados (varios Partidos políticos con Votantes, Militantes y Simpatizantes, varias Coaliciones, varias Elecciones con distintas Circunscripciones, etc.), de cara a hacer simulaciones.
Programación Orientada a Objetos – Curso 2015/2016
ANEXO: LEY D´HONDT
 Explicación Ley D´Hondt: https://es.wikipedia.org/wiki/Sistema_d%27Hondt
 Ejemplo de aplicación Ley D´Hondt: http://cadpea.ugr.es/Doc_AtribucionEsc.aspx
 Simulador Ley D´Hondt: http://icon.cat/util/elecciones#
