# Proyecto: arkanoid

Proyecto colectivo de la asignatura de Programación Orientada a Objetos de la
ETSETB-UPC.

## Diseño inicial

* Clase Pelota
    - Atributos
        - vx, vy (velocidad)
        - x, y (posicion)
        - radio
        - color
        - estado (pegajoso, etc...)
    - Métodos
        - rebotar
        - moverse
        - chocar contra ladrillo (quizás no va aqui)
        - salir de pantalla

* clase Ladrillo
    - Atributos
        - tamaño
        - color
        - tipo de ladrillo
        - posición x,y
        - numero de golpes
    * Métodos
        - golpear

* clase Pala
    * Atributos
        - tx, ty (tamaño)
        - x,y (posicion)
        - velocidad
    * Métodos
        - moverse
        - lanzar_bola
        - golpear_bola

* clase Margen
    - Atributos
        - coord_superior
        - coord_izquierda
        - coord_derecha
    * Métodos
        - golpear_bola

	









