/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadEnum;

/**
 *
 * @author João Victor
 */
public class Principal {

    public static void main(String[] args) {

        Conta a = new Conta ("João Victor",1000);
        Conta p1 = new Conta ("Evertt",1000);
        Conta p2 = new Conta ("Jussimar",1000);
        
        a.depositarValor(500);
        p1.depositarValor(300);
        p2.sacarValor(500);
        p2.depositarValor(300);
        a.sacarValor(1500);
        a.depositarValor(300);
        a.sacarValor(500);
        a.depositarValor(300);
        a.sacarValor(500);
        p2.depositarValor(1300);
        p1.sacarValor(250);
        a.sacarValor(500);
        p1.depositarValor(1300);
        p1.sacarValor(250);
        a.sacarValor(500);
        p2.depositarValor(1300);
        p2.sacarValor(250);
        a.depositarValor(1300);
        a.sacarValor(250);
        

       /* p1.exibirSaldo();
        professor1.depositarValor(500);
        professor1.sacarValor(3000);
        professor1.sacarValor(350.56);*/
    }
    
}
