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
public abstract class AtacarHechizo {
    
    public void template(Personaje p1, Personaje p2,Hechizo h){
        if(this.verificarMana(p1,h)){
          this.faseAtaque(p1, p2, h);
        }else{
            this.faseAtaqueFallida();
        }
    }
    public boolean verificarMana(Personaje p1, Hechizo h) {
        if (p1.getMana() < h.getGastoMana()) {
            return false;
        } else {
            p1.setMana(p1.getMana() - h.getGastoMana());
            return true;     
        }
    }
    public abstract void faseAtaque(Personaje p1, Personaje p2,Hechizo h);  
    public void faseAtaqueFallida(){
        System.out.println("no hay mana sucificiente");
    } 
}
