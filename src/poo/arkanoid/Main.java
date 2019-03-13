package poo.arkanoid;

import info.macias.Ventana;

public class Main {
  public static void main(String[] args) {
    // Creamos los objetos que se necesitan, de momento:
    // una ventana, un margen y una pala
    Margen m = new Margen();
    Pala p = new Pala();
    Bola b = new Bola(p);

    Ventana vent = new Ventana("Palas!");
    // si te va lento, ponlo a false
    vent.setSuavizado(true);
    
    // centramos y ajustamos la cámara para que muestre mejor el espacio del
    // juego
    vent.setCamara( Margen.ANCHO/2, Margen.ALTO/2, // centrada en el centro del Margen
                    Margen.ALTO + Margen.ALTO_FOSO);
    
    // el bucle del juego se repetirá hasta que se pulse la tecla Escape
    while(!vent.isPulsadoEscape()) {
      // para cada fotograma, movemos y dibujamos los elementos del juego
      p.moverYMostrar(vent);
      m.dibujar(vent);
      b.moverYDibujar(vent);
      // y mostramos el fotograma actualizado en la ventana
      vent.actualizaFotograma();
    }
    vent.cerrar();
  }
}
