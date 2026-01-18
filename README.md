# Visor de Imágenes (Image Viewer) 📸

Una aplicación de escritorio robusta desarrollada en Java (Swing) para visualizar imágenes locales. Este proyecto implementa **Arquitectura Limpia** y el patrón **MVP (Modelo-Vista-Presentador)**, garantizando un código desacoplado, mantenible y escalable.

## Características Principales

* **Navegación Fluida:** Botones para avanzar y retroceder entre imágenes.
* **Redimensionado Inteligente:** Las imágenes se ajustan automáticamente al tamaño de la ventana manteniendo su relación de aspecto (aspect ratio), sin deformarse.
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
    * **Single Responsibility Principle (SRP):** Clases especializadas como `Resizer` (solo matemáticas de ajuste) y `SwingImageDeserializer` (solo conversión de bytes).

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
