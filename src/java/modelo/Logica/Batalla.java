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
public class Batalla {

    int i = 1;
    Turno t = new Turno();
    Personaje p1 = new MagoBlanco();
    Personaje p2 = new MagoBlanco();

    private static Batalla batalla1;

    private Batalla() {
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public Turno getT() {
        return t;
    }

    public void setT(Turno t) {
        this.t = t;
    }

    public Personaje getP1() {
        return p1;
    }

    public void setP1(Personaje p1) {
        this.p1 = p1;
    }

    public Personaje getP2() {
        return p2;
    }

    public void setP2(Personaje p2) {
        this.p2 = p2;
    }

    public synchronized static Batalla getBatalla() {
        if (batalla1 == null) {
            batalla1 = new Batalla();
        }
        return batalla1;
    }

    public void BatallarHechizo(Hechizo h) {
        if (this.p1.getVida() > 0 & this.p2.getVida() > 0) {
            if (i % 2 != 0) {
                Turno turno = new Turno();
                turno.TurnoHechizo(this.p1, this.p2, h);
            } else {
                Turno turno = new Turno();
                turno.TurnoHechizo(this.p2, this.p1, h);
            }
            setI(getI() + 1);
        }
    }

    public void BatallarAtaqueNormal() {
        if (this.p1.getVida() > 0 & this.p2.getVida() > 0) {
            if (i % 2 != 0) {
                Turno turno = new Turno();
                turno.TurnoAtaque(p1, p2);
            } else {
                Turno turno = new Turno();
                turno.TurnoAtaque(p2, p1);
            }
            setI(getI() + 1);
        }
    }
}
