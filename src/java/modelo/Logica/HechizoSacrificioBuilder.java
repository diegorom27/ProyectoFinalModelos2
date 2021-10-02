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
public class HechizoSacrificioBuilder extends HechizoBuilder {

    @Override
    public void buildTipo() {
        hechizo.setTipo("sacrificio");
        
    }

    @Override
    public void buildSacrificio() {
        hechizo.setSacrificio(ThreadLocalRandom.current().nextInt(100, 150 + 1));
    }

    @Override
    public void buildCuarción() {
       hechizo.setCuracion(0);
    }

    @Override
    public void buildEfectoMultiplicador() {
        hechizo.setEfectoMultiplicador(2+ThreadLocalRandom.current().nextFloat()+ThreadLocalRandom.current().nextFloat());
    }

    @Override
    public void buildEfecto() {
       hechizo.setEfecto(0);
       
    }

    @Override
    public void buildGastoMana() {
        hechizo.setGastoMana(ThreadLocalRandom.current().nextInt(100, 250 + 1));
    }

    @Override
    public void buildFoto() {
        hechizo.setFoto("assets/img/sacrificio.jpeg");
    }
    
}
