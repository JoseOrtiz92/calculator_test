Para generar un jar del proyecto seguir los siguientes pasos:
-Situarse dentro de la carpeta del proyecto (al mismo nivel donde se encuentra el pom.xml)
-Dentro de esta carpeta abrir el cmd y ejecutar el siguiente comando: mvn clean install
-Esto generará un archivo .jar dentro de la carpeta de target (la carpeta se encuentra al mismo nivel de donde estamos)

Para ejecutar el .jar, podemos ejecutarlo desde el cdm de windows:
-Nos situaremos dentro de la carpeta target del proyecto
-Desde esta carpeta ejecutamos el CMD
-Escribimos java -jar calculatormicro-0.0.1-SNAPSHOT.jar
-Pulsamos enter y se ejecutará el microservicio