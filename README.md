# README – Taller N°3 Programación Orientada a Objetos

# TaskForge – Sistema de Gestión de Proyectos y Tareas
Taller N°3 – Programación Orientada a Objetos (POO)
Universidad Católica del Norte – Ingeniería en Tecnología de la Información (ITI)

## Descripción General del Proyecto
TaskForge es un sistema de gestión de proyectos y tareas desarrollado en Java. Implementa principios avanzados de Programación Orientada a Objetos (POO) y patrones de diseño solicitados, incluyendo Factory, Strategy, Visitor y Singleton. Además, utiliza persistencia en archivos de texto y documentación completa con JavaDoc.

## Integrantes
### Ramiro Alvarado Durán
Carrera: ITI  
RUT: 19.428.146-3  
GitHub: https://github.com/RamiroAlvaradoD

### Patricio Alvarado Durán
Carrera: ITI  
RUT: 20.955.249-3  
GitHub: https://github.com/Garaxlight

## Funcionamiento del Sistema
### Administrador
- Crear y eliminar proyectos.
- Crear y eliminar tareas.
- Ordenar tareas (Strategy).
- Generar reporte externo reporte.txt.
- Ver todas las tareas y proyectos.

### Colaborador
- Ver lista de proyectos.
- Ver solo sus tareas asignadas.
- Actualizar estado de tareas.
- Ejecutar visitors sobre sus tareas.

## Estructura del Proyecto
/src  
 ├── archivos/  
 ├── factory/  
 ├── strategy/  
 ├── visitor/  
 ├── sistema/  
 └── taller/

## Patrones de Diseño Utilizados
### Singleton
Implementado en la clase Sistema.

### Factory
Para creación de tareas en TareaFactory y TareaFactoryImpl.

### Strategy
Para ordenar tareas por fecha, complejidad o tipo.

### Visitor
Para ejecutar comportamientos específicos según el tipo de tarea.

## Persistencia en Archivos
El sistema utiliza usuarios.txt, proyectos.txt, tareas.txt y reporte.txt.  
Clases en /archivos manejan la lectura y escritura usando File, FileWriter, Scanner e IOException.

## Reporte
El administrador genera reporte.txt con detalles de proyectos y tareas.

## Instrucciones de Ejecución
1. Importar el proyecto en un IDE Java.
2. Verificar la existencia de usuarios.txt, proyectos.txt y tareas.txt en la raíz.
3. Ejecutar sistema.App.
4. Iniciar sesión con un usuario válido.

## JavaDoc
Todo el código está completamente documentado con JavaDoc.

## UML
<img width="1148" height="1054" alt="Diagrama sin título-Página-2 drawio" src="https://github.com/user-attachments/assets/ce77b323-426f-48fe-97cc-8c75bd352c53" />
PDF del UML (https://github.com/user-attachments/files/23667170/Diagrama.sin.titulo-Pagina-2.drawio.pdf)


