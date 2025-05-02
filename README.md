# Challenge app - PinApp

App solicitada para el challenge como parte del proceso de recruting.

## Tabla de Contenidos

- [Descripción](#descripción)
- [Funciones Principales](#funciones-principales)
- [Start_up](#start-up)
- [Uso](#uso)

## Descripción

Esta aplicación tiene como dominio el manejo de cliente, cuenta con un endpoint para crear un cliente, otro para recuperar
todos los clientes con sus datos, y un endpoint para metricas de clientes.

## Funciones Principales

* Create cliente 
* Get All clientes
* Metricas

## Start up
La aplicación puede ejecutarse a través del archivo ejecutable de la clase ChallengeAppApplication.java

## Prerrequisitos
Es necesario contar con la versión 17 de Java y gradle (versión recomendada 8.13)

## Uso
Para conectarse a la instancia EC2 y utilizar la aplicación debe realizar peticiones a la IP http://3.142.208.82

los endpoints habilitados son:

[POST] http://3.142.208.82/clientes
[GET] http://3.142.208.82/clientes/get-all
[GET] http://3.142.208.82/clientes/metricas
Para consumir la api debe enviar las peticiones con autenticación Basic, el usuario y password son:
Username: pinapp
Password: challenge

Los endpoints se encuentra explicados en la documentación que se puede acceder al siguiente url: http://3.142.208.82/swagger-ui