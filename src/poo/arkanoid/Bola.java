
package poo.arkanoid;

import info.macias.Ventana;
import java.awt.Color;

public class Bola {
  
  // constantes que configuran el juego: radio, módulo de la velocidad y
  // ángulo inicial de la bola
  private static final double R_INICIAL = 0.3;
  private static final double V_INICIAL = Pala.VELOCIDAD_INICIAL;
  private static final double A_INICIAL = Math.PI / 4;
 
  // para saber si choca con la pala, debemos conocer su posición
  private Pala pala;
  
  private Color color = Color.ORANGE;
  // radio de la bola
  private double r = R_INICIAL;
  // posición de la bola
  private double x, y;
  // velocidad en coordenadas polares (v: módulo, a: ángulo)
  private double v = V_INICIAL;
  private double a = A_INICIAL;
  
  public Bola(Pala pala) {
    this.pala = pala;
    iniciarValores();
  }
  
  // inicia los valores de la bola:
  // posición: encima de la pala, en su mitad
  // velocidad inicial
  private void iniciarValores() {
    x = pala.getAncho() / 2 + pala.getX();
    y = pala.getY() + r; 
    v = V_INICIAL;
    a = A_INICIAL;
  }
  
  public void moverYDibujar(Ventana v) {
    actualizaCoordenadas();
    v.dibujaCirculo(x, y, r, color);
  }

  /**
   * Función interna (private) que actualiza las coordenadas de la bola, y
   * modifica su ángulo de velocidad si detectamos que ha chocado contra las
   * paredes o la pala.
   */
  private void actualizaCoordenadas() {
    // actualizamos posición pasando de velocidad polar a cartesiana
    double dx = v * Math.cos(a);
    double dy = v * Math.sin(a);
    x = x + dx;
    y = y + dy;
    
    // verificar choque margen derecho
    if (x + r >= Margen.ANCHO) {
      a = Math.PI - a;
      x = Margen.ANCHO - r; // ajustamos a margen derecho
    }
    // verificar choque arriba
    if (y + r >= Margen.ALTO) {
      a = 2*Math.PI -a;
      y = Margen.ALTO -r; // ajustamos a margen superior
    }
    // verificar choque izquierda
    if (x - r <= 0) {
      a = 3*Math.PI -a;  
      x = r; // ajustamos a margen izquierdo
    }
    // verificar choque pala: chocará cuando la bola esté a una determinada
    // altura, y cuando su posición esté dentro de los márgenes de la pala
    if (y - r <= 0
            && y >-r
            && x >= pala.getX()
            && x <= pala.getX() + pala.getAncho()) {
      a = (2 * Math.PI - a);
      y = +r;
    }
    // si cae al foso, reiniciamos los valores
    if (y < -Margen.ALTO_FOSO) {
      iniciarValores();
    }
    
  }
  
}
