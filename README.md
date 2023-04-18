## Página principal

- **Nombre del proyecto**: _Digital Booking - Viaja como quieras_
- **Un resumen:**
  - Estamos emocionados de presentar nuestro sitio web de reserva de carros, Digital Booking, una plataforma innovadora que satisface las necesidades de usuarios con diferentes requerimientos. Nuestro sitio web ofrece una experiencia sin interrupciones para usuarios no registrados, registrados y administradores, siendo la única condición el registro y el inicio de sesión para hacer reservas. Durante el registro, se envía un correo electrónico para confirmar la inscripción. Nuestro sitio web cuenta con varios filtros que permiten a los usuarios buscar carros según la ubicación, la categoría y el rango de fechas. Nos enorgullece prestar atención a los detalles, y nuestras páginas de productos son un ejemplo de ello. Con un enfoque en la experiencia del usuario y la interfaz de usuario, nuestra galería de imágenes, el calendario de disponibilidad, los mapas de ubicación y los detalles de la política proporcionan a los usuarios toda la información necesaria para tomar decisiones informadas. El sitio web también incluye una sección de favoritos y una función de historial de reservas para usuarios recurrentes. Nuestro sitio web está construido con tecnologías modernas y utilizamos servicios de AWS para garantizar escalabilidad y confiabilidad. Dockerizamos tanto el front-end como el back-end y ejecutamos los contenedores en una instancia de EC2. Nuestros datos se almacenan en una instancia de RDS, y las imágenes se guardan en un bucket de S3. Seguimos la metodología Agile bajo Scrum para garantizar una eficiente colaboración en equipo, y nuestra pila tecnológica incluyó HTML, CSS, JavaScript y la biblioteca React para el desarrollo de front-end. Para el back-end, utilizamos Java, Spring Framework, Spring Boot Security, Spring Boot Mail, Spring Boot JPA, Spring Doc, Hibernate ORM, JWT, log4j y Maven. Nuestra base de datos funciona con MySQL, y utilizamos JUnit, Jest, Postman, React Testing Library y pruebas manuales para garantizar la calidad de nuestro producto. Nuestra infraestructura está gestionada con Terraform, Docker y AWS (con proveedores de recursos como EC2, RDS MySQL, S3 y Route 53).
- **Objetivo:**
  * Nuestro principal objetivo es brindarle al cliente la mayor satisfacción y comodidad mediante este gran proyecto, creado con el fin de cumplir cada una de sus necesidades y ofrecer un servicio enfocado en llegar a cualquier tipo de persona debido a la accesibilidad y claridad para el uso del producto, la confianza generada por su mayor seguridad y un diseño que muestre un alto interés en el cliente.

    Además, desde otro punto de vista resaltamos el objetivo de encontrar la forma de entendernos como equipo para llegar a un mismo acuerdo y avanzar constantemente en el proyecto, teniendo en cuenta que no es algo sencillo trabajar de esta forma ya que es muy común que se presenten diferencias en un grupo de trabajo pero siempre tratamos de sostener un equilibrio que nos llevo a superar este gran reto.
- Link de <span dir="">nuestro proyecto </span><http://bucket-grupo2-frontend.s3-website.us-east-2.amazonaws.com/>

## Equipo

#### Emilio Pino

- Rol: Desarrollador Frontend , Asistente de Infraestructura.

Me desempeñe laboralmente alrededor de 15 años como supervisor ​​de seguridad en las industrias de la construcción, petróleo y gas. En 2021, decidí seguir una carrera en tecnología, temática que desde siempre llamó mi atención, pero que por diversos factores nunca antes había tenido la oportunidad de aprender de manera sistemática. Al iniciar la carrera tenía conocimientos muy básicos de HTML, CSS y Javascript.

Durante el 1mer y 2do sprint me enfoque 100% en el front end de nuestra app y en el desarrollo de tests unitarios. En el 3cer sprint preste soporte en el área de infraestructura principalmente en la configuración del pipeline que integrará los tests, el build de la app y posterior deployment al bucket alojado en servidor de AWS. Finalmente, durante 4to y último spring estuve abocado a detalles finales del front end, como la organización de los archivos, buenas practicas, ajuste de tests según modificación en nuestra api y test automatizados con la herramienta Selenium.
| Tecnología | Fortaleza |
|------------|-----------|
| Front end | :large_blue_circle: :large_blue_circle: :large_blue_circle: |
| Back end | :large_blue_circle: :white_circle: :white_circle: |
| Infraestructura | :large_blue_circle: :large_blue_circle: :white_circle: |
| Testing / QA | :large_blue_circle: :large_blue_circle: :white_circle: |
| Bases de datos | :large_blue_circle: :white_circle: :white_circle: |


## Metodología de trabajo

Como equipo de trabajo logramos entendernos de una forma eficaz debido a la comunicación y el apoyo, por esto mismo llegamos a distribuir nuestros roles en cada ámbito del proyecto teniendo en cuenta las mayores fortalezas y habilidades de cada uno. Le dimos el mayor provecho a programas de trabajo como Discord y GitLab principalmente para asignar las tareas, informar los avances de cada integrante y comunicar al equipo cuando se presentaban inconvenientes o dudas.

A lo largo del proyecto afortunadamente obtuvimos por lo general resultados positivos gracias a la buena comunicación, el respeto, la responsabilidad y colaboración, resaltando el empeño que se dedico para realizar el producto de la mejor calidad. También cabe recalcar pequeños inconvenientes que tuvimos que se presentaban mas que todo a la hora de exponer nuestro trabajo ya que nos enfocábamos solo en avanzar el proyecto y nos quedaba corto el tiempo para organizar la presentación. De igual forma como equipo le sacamos el mayor provecho a los encuentros de las retros para buscar solución a estos puntos negativos que se estaban presentando y finalmente logramos equilibrar estos factores.

## Bitácora del proyecto

El proceso de creación del proyecto resulto ser un gran aprendizaje llevando a la practica todos aquellos conocimientos que adquirimos en los anteriores bimestres. Cada sprint tuvo sus diferentes niveles de complejidad, algunos mas enfocados en el campo de Front-End y otros en el de Back-End. El punto de Infraestructura nos generó inconvenientes en algunos casos debido a que no tuvimos la capacitación de esta materia y la solución fue investigar por fuera del acompañamiento de docentes; al igual que en el último sprint por parte del Back-End con el concepto de Spring Security JWT siendo algo nuevo para nosotros pero finalmente afrontamos estos problemas y resaltando que estas situaciones nos ayudan a crecer más a nivel de experiencia.

A modo de ejemplo podemos mencionar algunas de las decisiones / reflexiones que hicimos en algunas de las ceremonias de retrospectiva:

#### Retrospective Spring 1:

**Cosas a mejorar:**

* mejorar el nivel de conocimiento sobre lo que está haciendo cada uno en su respectiva área.
* mejorar la asignación de tareas y revisar bien el alcance de cada requisito. Por ejemplo asignamos todo pero olvidamos los casos de tests en base a las historias de usuario.
* mejorar la calidad de la presentación del review y durante la misma dar preponderancia al producto / app desarrollada.

**Cosas buenas:**

* nos pusimos de acuerdo rápidamente en los roles que cada uno iba a cumplir.
* durante la primera semana cumplimos con buena parte de los requisitos (75% aprox).

#### Retrospective Spring 2 / Start - Stop - Continue Template

**Start:**

* Realizar daily diariamente, independientemente se está no scrum master.
* Planificación del json antes de avanzar desde front-end / back-end para evitar incompatibilidad posteriormente.
* Usar grupo de whatsapp para coordinación de reuniones.
* Usar únicamente el canal de discord para recursos / links relacionados al proyecto.

**Stop:**

* Preparar presentación a último momento.

**Continue:**

* Ajustándose a los 10 minutos para el review.
* Actualizando progreso en cada disciplina en el canal de discord.
* Mantener un buen nivel de comunicación.
* Buen manejo del git.
* Mostrar el progreso del back relacionándolo con el funcionamiento del front end.

## Tecnologías utilizadas

Completar esta sección respondiendo a las siguientes consignas:

* Qué servicios / herramientas emplearon a la hora de realizar el desarrollo.
  * Gestión del proyecto.
    * GitLab
    * Zoom
    * Discord
    * WhatsApp
    * Slides
  * Desarrollo del proyecto:
    * IDEs
      * IntelliJ
      * Visual Studio Code
    * Sistemas de control de versiones
      * Git
      * GitLab
    * Simulación / Virtualización
      * Instancia EC2 AWS
* Qué tecnologías utilizaron para el desarrollo del sitio
  * Front end
    * "json-server": "^0.17.1",
    * "leaflet": "^1.9.3", "react": "^18.2.0",
    * "react-date-range": "^1.4.0",
    * "react-dom": "^18.2.0",
    * "react-image-gallery": "^1.2.11",
    * "react-leaflet": "^4.2.1",
    * "react-multi-date-picker": "^3.3.4",
    * "react-router-dom": "^6.8.1",
    * "react-share": "^4.4.1",
    * "sweetalert2": "^11.7.3",
    * "yup": "^1.0.0"
    * "axios": "^1.3.3",
    * "date-fns": "^2.29.3",
    * "dayjs": "^1.11.7",
    * "formik": "^2.2.9",
    * "material UI"
    * "Jest"
    * "JSDOM"
    * Vite
    * Vitest
  * Back end
    * UML
    * Java Spring
    * Java Springboot
    * Java sprinboot data (JPA)
    * Java Springboot seciruty
    * Java Springboot MVC
    * DAO (Data accès object)
    * Postman
    * Junit
    * JWT
    * Log4j
    * Swagger
    * REST API
    * ORM Hibernate
    * Maven
  * Base de datos
    * MySQL
  * Infraestructura
  * Testing

  ### **<span dir="">Infraestructura</span>**

  <span dir="">Para la realización de la infraestructura, utilizamos las siguientes tecnologías:</span>
  * <span dir="">GitLab Pipelines CI/CD</span>
  * <span dir="">GitLab CI/CD Variables</span>
  * <span dir="">GitLab Runners</span>
  * <span dir="">AWS EC2, S3 Buckets y RDS (Endpoint brindado por Digital House)</span>
  * <span dir="">emailJS (Email personalizado).</span>

  ### **<span dir="">Testing</span>**

  <span dir="">Para el testeo de nuestra app se utilizaron diversas tecnologías y técnicas. Podemos mencionar casos de prueba, tests funcionales y no funcionales, test exploratorio, smoke tests, test de regresión, test de la  API con Postman, tests automáticos con Selenium IDE y además se incorporaron test unitarios con Jest y Vitest para en frontend y para el caso del backend con JUnit.</span>

## Documentación técnica del proyecto
  * Buenas prácticas / convenciones / acuerdos a la hora de desarrollar:
     1. Escribe código limpio y legible: Utiliza nombres de variables y funciones descriptivos y comenta tu código cuando sea necesario para facilitar su comprensión.
     2. Usa consistencia en tu código: Usa la misma convención de nomenclatura, estilo de escritura y estructura en todo tu código para facilitar su lectura.
     3. Usa funciones y módulos pequeños y modulares: Divide tu código en pequeñas funciones y módulos que realicen una tarea específica para facilitar el mantenimiento y la escalabilidad.
     4. No repitas código: Evita duplicar código innecesariamente. Si encuentras que estás escribiendo el mismo código varias veces, considera crear una función que lo encapsule.
     5. Usa control de versiones: Usa un sistema de control de versiones como Git para mantener un historial de los cambios realizados en tu código y para colaborar con otros desarrolladores.
     6. Prueba tu código: Antes de enviar tu código a producción, asegúrate de que ha sido probado y validado. Utiliza pruebas unitarias y pruebas de integración para garantizar que tu código funciona como se espera.
     7. Documenta tu código: Documenta tu código para ayudar a otros desarrolladores a comprender cómo funciona tu código y cómo utilizarlo.
     8. Usa comentarios descriptivos: Utiliza comentarios descriptivos para explicar partes de tu código que puedan ser difíciles de entender o para resaltar problemas potenciales.
     9. Haz uso de los estándares de codificación: Asegúrate de seguir los estándares de codificación que se utilizan en tu equipo o comunidad para facilitar la colaboración.
    10. Usa herramientas de análisis de código: Utiliza herramientas de análisis de código estático para identificar errores y posibles problemas de seguridad en tu código.
    11. Implementa seguridad en tu código: Considera la seguridad desde el principio del desarrollo y utiliza las prácticas de seguridad recomendadas para evitar vulnerabilidades en tu código.
    12. Mantén actualizado tu software: Asegúrate de mantener actualizadas las bibliotecas y frameworks que utilizas para asegurarte de que estás utilizando la última versión con las últimas correcciones de errores y mejoras de seguridad.
    13. Haz uso de los patrones de diseño: Utiliza patrones de diseño para estructurar tu código de manera que sea fácil de entender y mantener.
    14. Realiza pruebas de rendimiento: Realiza pruebas de rendimiento en tu código para identificar posibles cuellos de botella y para asegurarte de que tu código es eficiente.
    15. Practica la refactorización: Refactoriza tu código de forma regular para mantenerlo limpio y eficiente. La refactorización te permite mejorar la estructura y la legibilidad de tu código sin cambiar su funcionalidad.
* Base de datos
  * Estructura y diagramas

    ![image](uploads/a75d2ae6d80f03e4b25d50d28ce66d3b/image.png)
* Pruebas y ejemplos de uso de los endpoints

  <https://app.getpostman.com/join-team?invite_code=2894fc70c004c3bad03ef7cbc9355a05&target_code=5365dd3bbfe726de789640f54b2576b7>
* Componentes y diagramas de la aplicación
  * Principales partes de la aplicación y cómo se conectan
  * APIs disponibles y su documentación (pueden linkear a un sitio externo)
* Infraestructura

  ![](https://lh4.googleusercontent.com/uHa14iUBaW8qH0YKv23IHOeOTGAwIwX2WljTmU3LHRD28AALW1k61OYVtbcmq4nt3ncO-KHPNlpK5TJ818nxESM-MqkYUuaPSYYaJoDbMnbHhIw5MUnWeIvccZjhOnYBQtXcXySxWkSC4jTb6nvocjohyg=s2048)
* ![](https://lh5.googleusercontent.com/oxvZO3-7nkUr_B4iS_738r1HgTIPA-wXxbgEW0_2Rd2rHHoCqOpHreGlk1rLJUV21RrR9Ts9a1saWGA0I-XQ4SVvMwGU_7KhJlL_qsb9slIqn7HFX2dy7lgmKtuiutdEIuzHR8IUQbKNys1WUXe1-a9yzA=s2048)

  ![](https://lh6.googleusercontent.com/FKeAnt9_CGdlG2JvlbzNAHDn8V9aqAYnRK2WZm3-gGk8xNe-hlr_BXt0x2whVx3TIMejZXsy-Lb3MKfUrXzPKBqcMHY0cbDwC-TCxP0VXI9tp6alMcfCQE91gQG2RRzUlORQYmC7ZzLAh9LP0noI5o7VYA=s2048)

  **<span dir="">Write Code</span>**


- Fue creada una puerta de enlace de Internet y asociada a la VPC
- Agregamos una ruta a la tabla de enrutamiento de la subred que dirija el tráfico vinculado a Internet a la puerta de enlace de Internet.
- Las instancias de su subred tienen una dirección IPv4 pública.
- Las reglas de los grupos de seguridad y las listas de control de acceso a la red permiten el envío de tráfico de Internet deseado desde o hacia la instancia.


* Testing y calidad:

Informe de testing:

<https://docs.google.com/document/d/15mmeEbIsYTP5cXs3UE3CbLrD3b6DtviN-tT8G1a3DWQ/edit?usp=sharing>

## 
