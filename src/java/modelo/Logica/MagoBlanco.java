/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Logica;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author diego
 */
public class MagoBlanco extends Personaje {
    @Override
    public void setCaracteristicas(String nombre, String estilo) {
        setNombre(nombre);
        setFoto("assets/img/magoBlanco.jpeg");
        setVida(ThreadLocalRandom.current().nextInt(1000, 1500 + 1));
        setAtaque(ThreadLocalRandom.current().nextInt(190, 250 + 1));
        setMana(ThreadLocalRandom.current().nextInt(1000, 1200 + 1));
        setEstilo(estilo); 
    }

}
