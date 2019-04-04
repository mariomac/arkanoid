
package poo.arkanoid;

import info.macias.Ventana;
import java.awt.Color;

public class Ladrillo {
  
  private static final double ANCHO = 2; 
  private static final double ALTO = 1;
  private double x, y;
  
  private Bola bola;

  public Ladrillo(double x, double y, Bola bola) {
    this.x = x;
    this.y = y;
    this.bola = bola;
  }
  
  public void dibujar(Ventana v) {
    v.dibujaRectangulo(x, y + ALTO, ANCHO, ALTO, Color.yellow);
    
  }
  
  public boolean compruebaChoque() {
    double xbola, ybola;
    // arriba
    ybola = bola.getY() + bola.getR();
    xbola = bola.getX();
    if (estaDentro(xbola, ybola)) {
      bola.rebotarAbajo();
      return true;
    }
    return false;
  }
  
  private boolean estaDentro(double bx, double by) {
    return bx >= x && bx <= x + ANCHO
            && by >= y && by <= y + ALTO;
  }
  
}
