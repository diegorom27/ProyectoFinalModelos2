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
public class PersonajeFactory {
    
    static Personaje a;
    
    private static void liskov(Personaje per, String nombre, String estilo) {
        per.setCaracteristicas(nombre, estilo);
        a= per;
    }
    
    public Personaje getPersonaje(String tipo, String nombre, String estilo){
        if(tipo.equals("mago oscuro")){
            liskov(new MagoOscuro(),nombre, estilo);
            return a;
        }
        if(tipo.equals("mago blanco")){
            liskov(new MagoBlanco(),nombre, estilo);
            return a;
        }
        return null;
    }
    
}
