/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Logica;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author diego
 */
public class HechizoAtaqueBuilder extends HechizoBuilder {

    @Override
    public void buildTipo() {
        hechizo.setTipo("ataque");    
    }

    @Override
    public void buildSacrificio() {
        hechizo.setSacrificio(0);
    }

    @Override
    public void buildCuarción() {
       hechizo.setCuracion(0);
    }

    @Override
    public void buildEfectoMultiplicador() {
        hechizo.setEfectoMultiplicador(0);
    }

    @Override
    public void buildEfecto() {
       hechizo.setEfecto(ThreadLocalRandom.current().nextInt(100, 250 + 1));
       
    }

    @Override
    public void buildGastoMana() {
        hechizo.setGastoMana(ThreadLocalRandom.current().nextInt(100, 250 + 1));
    }

    @Override
    public void buildFoto() {
        hechizo.setFoto("assets/img/hechizoAtaque.jpeg");
    }
    
}
