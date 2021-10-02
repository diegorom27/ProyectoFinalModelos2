/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Logica;

/**
 *
 * @author diego
 */
public class AtacarHechizoSacrificio extends AtacarHechizo {

    @Override
    public void faseAtaque(Personaje p1, Personaje p2, Hechizo h) {
        p1.setVida(p1.getVida() - h.getSacrificio());
        p2.setVida((int) (p2.getVida() - h.getEfectoMultiplicador()*p1.getAtaque()));
    }
  
}
