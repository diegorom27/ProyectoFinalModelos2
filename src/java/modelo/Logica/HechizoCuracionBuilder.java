
package modelo.Logica;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author diego
 */
public class HechizoCuracionBuilder extends HechizoBuilder {

    @Override
    public void buildTipo() {
        hechizo.setTipo("curacion");    
    }

    @Override
    public void buildSacrificio() {
        hechizo.setSacrificio(0);
    }

    @Override
    public void buildCuarción() {
       hechizo.setCuracion(ThreadLocalRandom.current().nextInt(100, 250 + 1));
    }

    @Override
    public void buildEfectoMultiplicador() {
        hechizo.setEfectoMultiplicador(0);
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
        hechizo.setFoto("assets/img/curacion.jpeg");
    }
    
}
