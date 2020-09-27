# registerCompany
Front en angular para registro de empresas
# RegisterCompany

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 8.1.2.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Como Ejecutar el proyecto

El proyecto fue creado en netbeans y esta configurado para ejecutarse en el servidor de aplicaiones `glassfish 5` y el puerto HTTP en el cual probe y esta funcionando el proyecto 
es el `8082`.

Si no se utiliza este puerto, se tendra que cambiar la urlBase del front, para que las peticiones se hagan correctamente al puerto en el que el servidor este 
escuchando. Para eso se debe ir al siguiente archivo: front-angular\src\app\Services\Base\base-service.service.ts y en el archivo cambiar la variable urlBase. 
EL valor actual es private urlBase = `http://localhost:8082/`  y se deberia cambiar el puerto, por el que use el servidor para escuchar las peticiones.

El back fue desarrollado en java ee con el `jdk 1.8` y esta hecho con maven.

En el front se encuentra un login basico y las credenciales son: `usuario = prueba y contraseña = 123456`