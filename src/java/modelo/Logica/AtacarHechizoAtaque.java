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
public class AtacarHechizoAtaque extends AtacarHechizo {

    @Override
    public void faseAtaque(Personaje p1, Personaje p2, Hechizo h) {
        p2.setVida(p2.getVida() - h.getEfecto());
    }
  
}
