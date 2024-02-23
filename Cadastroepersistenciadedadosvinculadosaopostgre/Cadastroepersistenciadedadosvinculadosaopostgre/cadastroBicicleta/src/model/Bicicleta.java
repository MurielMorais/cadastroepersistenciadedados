/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
        

/**
 *
 * @author User
 */


public class Bicicleta {
    
 private int Id;
 private String freio;
 private String tipo;
 private int estoque;
 private int aro;
public Bicicleta() {
}
    public Bicicleta(int Id, String freio, String tipo, int estoque, int aro) {
        this.Id = Id;
        this.freio = freio;
        this.tipo = tipo;
        this.estoque = estoque;
        this.aro = aro;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getFreio() {
        return freio;
    }

    public void setFreio(String freio) {
        this.freio = freio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getAro() {
        return aro;
    }

    public void setAro(int aro) {
        this.aro = aro;
    }
 
 





 
}
