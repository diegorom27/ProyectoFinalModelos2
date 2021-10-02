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
public abstract class HechizoBuilder {
    protected Hechizo hechizo;
    
    public Hechizo getHechizo(){
        return hechizo;
    }
    public void crearNuevoHechizo(){
        hechizo = new Hechizo(); 
    }
    public void nombrarHechizo(String nombre){
        hechizo.setNombre(nombre);
    
    }

    public abstract void buildTipo();
    public abstract void buildSacrificio();
    public abstract void buildCuarción();
    public abstract void buildEfectoMultiplicador();
    public abstract void buildEfecto();
    public abstract void buildGastoMana();
    public abstract void buildFoto();

    
    
    
    
}
