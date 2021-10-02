/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Logica;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author diego
 */
public abstract class Personaje {
    
    int id =0;
    protected String nombre;
    protected int vida;
    protected int ataque;
    protected int mana;
    protected String foto;
    protected String estilo;

    public Personaje() {

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

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public abstract void setCaracteristicas(String nombre, String estilo);


    public int ataqueNormal(Personaje p) {
        p.setVida(p.getVida() - this.ataque);;
        return 0;
    }
}
