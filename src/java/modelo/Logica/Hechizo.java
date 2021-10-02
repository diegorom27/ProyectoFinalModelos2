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
public class Hechizo { // implementar hechizos pasivos
    
    protected int id;
    protected String nombre;
    protected String tipo;
    protected int gastoMana;
    private int sacrificio;
    private int curacion;
    private float efectoMultiplicador;
    int efecto;
    protected String foto;
    

    public Hechizo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGastoMana() {
        return gastoMana;
    }

    public void setGastoMana(int gastoMana) {
        this.gastoMana = gastoMana;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getSacrificio() {
        return sacrificio;
    }

    public void setSacrificio(int sacrificio) {
        this.sacrificio = sacrificio;
    }

    public int getCuracion() {
        return curacion;
    }

    public void setCuracion(int curacion) {
        this.curacion = curacion;
    }

    public float getEfectoMultiplicador() {
        return efectoMultiplicador;
    }

    public void setEfectoMultiplicador(float efectoMultiplicador) {
        this.efectoMultiplicador = efectoMultiplicador;
    }

    public int getEfecto() {
        return efecto;
    }

    public void setEfecto(int efecto) {
        this.efecto = efecto;
    }

}
