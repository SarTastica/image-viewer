# Image Viewer

Este repositorio refleja el trabajo de la asignatura Ingenieria del Software 2 de la carrera Ingenieria Infórmatica de la ULPGC donde muestra un proyecto que trata de la carga de una serie de imagenes en la carpeta "fotos" que se muestran al ejecutar el Main. Dichas imagenes son reescalables al tamaño de la ventana que se quiera usar.


## Modo de ejecución

---
* Ejecutar el Main.java que esta en la carpeta src/main/java/software/ulpgc/imageviewer
---


## Características Principales

* **Navegación Fluida:** Botones para avanzar y retroceder entre imágenes.
* **Redimensionado Inteligente:** Las imágenes se ajustan automáticamente al tamaño de la ventana manteniendo su relación de aspecto, sin deformarse.
* **Sistema de Caché:** Implementación de *Memoización* para almacenar imágenes ya cargadas en memoria, eliminando tiempos de carga al volver a visitarlas.
* **Filtrado de Archivos:** Detecta y carga automáticamente solo formatos válidos (`.jpg`, `.png`), ignorando archivos ocultos o de sistema.
* **Diseño Portable:** Funciona mediante ruta relativa, permitiendo ejecutar el proyecto en cualquier ordenador sin configurar rutas absolutas.

## Arquitectura y Diseño

El proyecto sigue estrictamente los principios **SOLID**:

1.  **MVP (Model-View-Presenter):**
    * **Modelo:** Gestiona los datos (`Image`, `FileImageLoader`).
    * **Vista:** Interfaz gráfica pasiva (`MainFrame`, `SwingImageDisplay`). No contiene lógica de negocio.
    * **Presentador:** Intermediario que reacciona a eventos y actualiza la vista (`ImagePresenter`).

2.  **Patrones de Diseño utilizados:**
    * **Command Pattern:** Desacopla la invocación de la acción (botones) de la ejecución (`NextCommand`, `PreviousCommand`).
    * **Proxy/Caching:** Optimización en la carga de imágenes (`SwingImageDeserializer`).
    * **SRP:** Clases especializadas como `Resizer` (solo matemáticas de ajuste) y `SwingImageDeserializer` (solo conversión de bytes).

## Estructura del Proyecto

```text
src/software/ulpgc/imageviewer
├── control/       # Comandos y Presentador
├── io/            # Carga de archivos (FileImageLoader)
├── model/         # Definición de la entidad Imagen
├── view/          # Interfaces de la vista
│   └── swing/     # Implementación gráfica (MainFrame, Resizer...)
└── Main.java      # Punto de entrada (Composition Root)
```
