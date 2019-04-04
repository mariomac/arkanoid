
package poo.arkanoid;

import info.macias.Ventana;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Muro {
  private Set<Ladrillo> ladrillos = new HashSet<>();
  
  public Muro(Bola b) {
    ladrillos.add(new Ladrillo(0, 4, b));
    ladrillos.add(new Ladrillo(4, 4, b));
    ladrillos.add(new Ladrillo(6, 4, b));
  }

  public void dibujar(Ventana vent) {
    Iterator<Ladrillo> it = ladrillos.iterator();
    while(it.hasNext()) {
      Ladrillo l = it.next();
      if (l.compruebaChoque()) {
        it.remove();
      }
      l.dibujar(vent);
    }    
  }
}
