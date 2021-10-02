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
public class CreadorDeHechizos {
    
    private HechizoBuilder hechizoBuilder;
    
    public void setHechizoBuilder( HechizoBuilder hb){
        hechizoBuilder = hb;
    }
    public Hechizo getHechizo(){
     return hechizoBuilder.getHechizo();
    }
    
    public void construirHechizo(){
        hechizoBuilder.crearNuevoHechizo();//intento1
        hechizoBuilder.buildCuarción();
        hechizoBuilder.buildEfecto();
        hechizoBuilder.buildEfectoMultiplicador();
        hechizoBuilder.buildFoto();
        hechizoBuilder.buildGastoMana();
        hechizoBuilder.buildSacrificio();
        hechizoBuilder.buildTipo();
    }
    public void nombrarHechizo(String nombre){
        hechizoBuilder.nombrarHechizo(nombre);
    }
    
}
