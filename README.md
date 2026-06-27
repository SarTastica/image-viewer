---
title: "Image Viewer - Ingeniería del Software II"
author: "Salwa Madani Lazaar"
---

# Image Viewer

Este repositorio contiene el proyecto desarrollado para la asignatura **Ingeniería del Software II** del Grado en Ingeniería Informática de la ULPGC. 

El proyecto consiste en una aplicación de escritorio diseñada en Java para la visualización de imágenes. Se ha construido con un fuerte enfoque en la calidad del código, aplicando metodologías de diseño de software profesional, patrones de diseño y los principios SOLID.

---

## Modo de Ejecución

Para probar la aplicación en tu entorno local, sigue estos pasos:

1. **Preparación del entorno:** Asegúrate de tener una carpeta llamada `fotos` en el directorio raíz del proyecto.
2. **Añadir imágenes:** Coloca las imágenes que desees visualizar dentro de la carpeta `fotos` (formatos soportados: `.jpg`, `.png`).
3. **Ejecución:** Ejecuta la clase principal `Main.java` ubicada en la siguiente ruta:
   > `src/main/java/software/ulpgc/imageviewer/Main.java`

---

## Características Principales

* **Navegación Fluida:** Controles intuitivos integrados para avanzar y retroceder fácilmente entre las imágenes del directorio.
* **Redimensionado Inteligente:** Las imágenes se adaptan dinámicamente al tamaño de la ventana manteniendo su relación de aspecto original, evitando cualquier tipo de deformación visual.
* **Sistema de Caché (Memoización):** Almacena en memoria las imágenes previamente cargadas. Esto elimina los tiempos de recarga al volver a visitar una imagen, garantizando una experiencia de usuario instantánea.
* **Filtrado Automático de Archivos:** El sistema escanea el directorio y carga exclusivamente los formatos válidos (`.jpg`, `.png`), ignorando de forma segura archivos ocultos o del sistema.
* **Diseño Portable:** Construido utilizando rutas relativas. Esto permite clonar y ejecutar el proyecto en cualquier ordenador sin necesidad de reconfigurar rutas absolutas locales.

---

## Arquitectura y Diseño del Sistema

El desarrollo de este software sigue rigurosamente los **principios SOLID** para garantizar un código mantenible, escalable y limpio.

### Arquitectura MVP (Model-View-Presenter)
El proyecto está desacoplado en tres capas fundamentales:
* **Modelo:** Responsable de la gestión de datos y la lógica de negocio puramente conceptual (`Image`, `FileImageLoader`).
* **Vista:** Interfaz gráfica completamente pasiva (`MainFrame`, `SwingImageDisplay`). No contiene lógica de negocio, limitándose a mostrar lo que el presentador le dicta.
* **Presentador:** Actúa como el cerebro intermediario (`ImagePresenter`). Reacciona a los eventos de la vista y actualiza la interfaz basándose en las interacciones con el modelo.

### Patrones de Diseño Implementados
* **Command Pattern:** Desacopla la invocación de una acción (como hacer clic en un botón) de su ejecución real (`NextCommand`, `PreviousCommand`), facilitando la escalabilidad de la interfaz.
* **Proxy / Caching:** Optimización de recursos y mejora de rendimiento en la carga de imágenes (`SwingImageDeserializer`).
* **Principio de Responsabilidad Única (SRP):** Uso de clases altamente especializadas. Por ejemplo, `Resizer` se encarga exclusivamente de las matemáticas de ajuste de imagen, y `SwingImageDeserializer` gestiona únicamente la conversión de arrays de bytes.

---

## Estructura del Proyecto

El código fuente está organizado de forma semántica para facilitar su comprensión:

```text
src/software/ulpgc/imageviewer
├── control/       # Comandos de usuario y Presentador (Lógica de mediación)
├── io/            # Gestión de entrada/salida y carga de archivos (FileImageLoader)
├── model/         # Definición de las entidades del dominio (Imagen)
├── view/          # Contratos e interfaces de la vista
│   └── swing/     # Implementación gráfica concreta (MainFrame, Resizer...)
└── Main.java      # Punto de entrada de la aplicación (Composition Root)
