
package poo.arkanoid;

import info.macias.Ventana;
import java.awt.Color;

/**
 * Clase que simplemente guarda los datos del margen del juego. Se asume que 
 * la esquina inferior izquierda del margen será la posición 0,0 de la ventana
 */
public class Margen {
  private double ancho = 10;
  private double alto = 15;
  private double g = 0.5;   // grosor de la línea a dibujar

  /**
   * Devuelve el ancho de los márgenes del juego
   */
  public double getAncho() {
    return ancho;
  }

  /**
   * Devuelve la altura de los márgenes del juego
   */
  public double getAlto() {
    return alto;
  }
  
  /**
   * Dibuja los márgenes en la ventana dada.
   */
  public void dibujar(Ventana v) {
    // las líneas se desplazan g/2 (la mitad del grosor) para que, al ser
    // gruesas, no se metan dentro del tablero de juego
    // línea izquierda
    v.dibujaLinea(-g/2, -2, -g/2, alto, g, Color.GRAY);
    // línea superior
    v.dibujaLinea(0, alto + g/2, ancho, alto + g/2, g, Color.GRAY);
    // línea derecha
    v.dibujaLinea(ancho + g/2, alto, ancho+g/2, -2, g, Color.GRAY);
            
  }        
}
