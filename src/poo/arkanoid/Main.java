package poo.arkanoid;

import info.macias.Ventana;

public class Main {
  public static void main(String[] args) {
    // Creamos los objetos que se necesitan, de momento:
    // una ventana, un margen y una pala
    Margen m = new Margen();
    Pala p = new Pala(m);

    Ventana vent = new Ventana("Palas!");
    // centramos y ajustamos la cámara para que muestre mejor el espacio del
    // juego
    vent.setCamara(5, 7.5, 17);
    
    // el bucle del juego se repetirá hasta que se pulse la tecla Escape
    while(!vent.isPulsadoEscape()) {
      // para cada fotograma, movemos y dibujamos los elementos del juego
      p.moverYMostrar(vent);
      m.dibujar(vent);
      // y mostramos el fotograma actualizado en la ventana
      vent.actualizaFotograma();
    }
    vent.cerrar();
  }
}
