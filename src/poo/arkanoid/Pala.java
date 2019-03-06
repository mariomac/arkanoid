package poo.arkanoid;

import info.macias.Ventana;
import java.awt.Color;

/**
 * Clase pala, encargada de golpear la bola para evitar que caiga.
 */
public class Pala {

  private Margen margen; // margen, del que querremos saber las dimensiones
  private double tx, ty; // tamaño
  private double x, y; // posicion
  private double v; // velocidad horizontal
  
  /**
   * Inicializa los valores de una pala nueva.
   * @param margen los márgenes del juego
   */
  public Pala(Margen margen) {
    y = 0; // empieza debajo de la pantalla
    x = 0;
    tx = 1.5;
    ty = 0.5;
    v = 0.3;
    this.margen = margen;
  }
  
  /**
   * Mueve la pala según las teclas del cursor que estén pulsadas, y también
   * las muestra por la ventana.
   * @param vent Objeto Ventana que se usará para leer el teclado y dibujar
   *             la pala.
   */
  public void moverYMostrar(Ventana vent) {
    // movemos a la izquierda o la derecha según
    // la tecla que esté pulsada
    if (vent.isPulsadoIzquierda()) {
      x -= v;
    } else if(vent.isPulsadoDerecha()) {
      x += v;
    }
    // Ajustamos la posición de la pala para que no salga de los márgenes
    // del juego
    if (x < 0) {
      x = 0;
    } else if (x >= margen.getAncho() - tx) {
      x = margen.getAncho() - tx;
    }
    // dibujamos la pala como un rectángulo magenta
    vent.dibujaRectangulo(x, y, tx, ty, Color.MAGENTA);
  }
}
