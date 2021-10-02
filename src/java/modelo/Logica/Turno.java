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
public class Turno {

    Personaje p1;
    Personaje p2;
    Hechizo hechizo;
    int opcion;

    AtacarHechizo a;

    public Turno() {

    }

    public void TurnoHechizo(Personaje p1, Personaje p2, Hechizo hechizo) {
        switch (hechizo.tipo) {
            case "ataque":
                a = new AtacarHechizoAtaque();
                a.template(p1, p2, hechizo);
            break;
            case "curacion":
                a = new AtacarHechizoCuracion();
                a.template(p1, p2, hechizo);
            break;
            case "sacrificio":
                a = new AtacarHechizoSacrificio();
                a.template(p1, p2, hechizo);
            break;
        }
    }
    public void TurnoAtaque(Personaje p1, Personaje p2){
        p1.ataqueNormal(p2);
    }
    
    

}
