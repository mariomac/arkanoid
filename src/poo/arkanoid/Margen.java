
package poo.arkanoid;

import info.macias.Ventana;
import java.awt.Color;

/**
 * Clase que simplemente guarda los datos del margen del juego. Se asume que 
 * la esquina inferior izquierda del margen será la posición 0,0 de la ventana
 */
public class Margen {
  public static final double ANCHO = 10;
  public static final double ALTO = 15;
  private static final double GROSOR = 0.5;   // grosor de la línea a dibujar
  public static final double ALTO_FOSO = 2;

  
  /**
   * Dibuja los márgenes en la ventana dada.
   */
  public void dibujar(Ventana v) {
    // las líneas se desplazan g/2 (la mitad del grosor) para que, al ser
    // gruesas, no se metan dentro del tablero de juego
    // línea izquierda
    v.dibujaLinea(-GROSOR/2, -ALTO_FOSO,
                  -GROSOR/2, ALTO,
                  GROSOR, Color.GRAY);
    // línea superior
    v.dibujaLinea(0, ALTO + GROSOR/2,
                  ANCHO, ALTO + GROSOR/2,
                  GROSOR, Color.GRAY);
    // línea derecha
    v.dibujaLinea(ANCHO + GROSOR/2,
                  ALTO, ANCHO+GROSOR/2,
                  -ALTO_FOSO, GROSOR, Color.GRAY);
            
  }        
}
