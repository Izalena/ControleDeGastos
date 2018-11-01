/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

/**
 *
 * @author PTBR05
 */
public class Gastos {
//    private int id;
    private String data;
    private String lugar;
    private Float valor;

    public Gastos() {
        
    }
    public Gastos(String data, String lugar, Float valor){
        this.data= data;
        this.lugar = lugar;
        this.valor = valor;
    }
   /* public int getId() {
        return id;
    }*/



    /*public void setId(int id) {
        this.id = id;
    }*/
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
  
    
}
