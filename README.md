🧪 Resumen General de la Prueba Técnica
Este proyecto consistió en el desarrollo de un sistema de registro por medio de un formulario con frontend, backend y base de datos, para el cual me inspiré en el estilo visual de Americanino. A continuación, se detalla el proceso técnico realizado:

🗄️ 1. Creación de la Base de Datos
- Se diseñó una base de datos sencilla en SQL Server Management Studio.
- Se crearon tablas para:
- Marcas
- Países (solo Colombia)
- Departamentos
- Ciudades
- Se establecieron relaciones entre tablas para permitir selects dinámicos en el frontend:
- Al seleccionar un país → aparecen sus departamentos
- Al seleccionar un departamento → aparecen sus ciudades
- Herramientas utilizadas: SQL Server Management Studio, IntelliJ

🔧 2. Desarrollo del Backend
- Se implementó el backend en Java usando IntelliJ.
- Se realizó la conexión con la base de datos.
- Se probaron los endpoints con Postman para verificar su correcto funcionamiento.

🔁 3. CRUD + Swagger
- Se desarrolló un CRUD completo para gestionar los datos.
- Se integró Swagger UI para visualizar y probar los endpoints de forma gráfica.

🎨 4. Desarrollo del Frontend
- Se creó el formulario de registro con:
- HTML
- CSS
- Bootstrap
- El diseño se inspiró en la estética y colores de la marca Americanino, buscando una experiencia visual profesional y coherente.

⚠️ 5. Problemas de Integración
- Se presentaron dificultades al conectar el frontend con el backend.
- Finalmente, no se logró establecer la conexión directa entre ambos.
- Por lo tanto, los datos ingresados en el formulario no se almacenan en la base de datos.
- A pesar de esto, se hizo el mayor esfuerzo por entregar una solución funcional y visualmente cuidada.

🙌 Conclusión
Aunque la integración final no se logró, el proyecto demuestra habilidades en diseño de base de datos, desarrollo backend con Java, pruebas de endpoints, y construcción de interfaces visuales alineadas con una marca. ¡Gracias por la oportunidad!
