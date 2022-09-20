# ParchadosApp

> Primera entrega

El programa tiene una interfaz que se encarga de realizar todo el manejo de memoria de una lista con los usuarios, sin embargo,
mediante las mismas funciones, puede también manejar persistencia de la base de datos.

Lastimósamente, el programa no quedó ordenado como sería ideal, pero MAVEN requería de un manejo bastante particular para lograr compilar el programa
así, el paquete intento tiene todos los recursos, ya que el paquete de recursos no era cargado desde el START de la clase MAIN para inicializar el front-end.

En cualquier caso las tres funcionalidades de este programa en su primera parte son:
- Iniciar sesión
- Cerrar sesión
- Registrar nuevo usuario

Es importante aclarar que el programa ya cuenta con el crud completo y que además, implementar 3 funciones más para la segunda entrega es algo viable.

Para ejecutar el .JAR en windows es necesario abrir el cmd e indicar


```
set PATH_TO_FX="path\to\JavaFX\lib"
```

En mi caso se veía así: 

C:\Program Files\JavaFX\openjfx-18.0.1_windows-x64_bin-sdk\javafx-sdk-18.0.1\lib