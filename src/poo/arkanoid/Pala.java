package poo.arkanoid;

import info.macias.Ventana;
import java.awt.Color;

/**
 * Clase pala, encargada de golpear la bola para evitar que caiga.
 */
public class Pala {

  private static final double ANCHO_INICIAL = 1.5;
  private static final double ALTO_INICIAL = 0.5;
  public static final double VELOCIDAD_INICIAL = 0.3;
  
  private double tx, ty; // tamaño
  private double x, y; // posicion
  private double v; // velocidad horizontal
  
  public double getX() {
    return x;
  }

  public double getAncho() {
    return tx;
  }

  public double getY() {
    return y;
  }
  
  
  
  /**
   * Inicializa los valores de una pala nueva.
   */
  public Pala() {
    y = 0; // empieza debajo de la pantalla
    x = 0;
    tx = ANCHO_INICIAL;
    ty = ALTO_INICIAL;
    v = VELOCIDAD_INICIAL;
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
    } else if (x >= Margen.ANCHO - tx) {
      x = Margen.ANCHO - tx;
    }
    // dibujamos la pala como un rectángulo magenta
    vent.dibujaRectangulo(x, y, tx, ty, Color.MAGENTA);
  }
}
