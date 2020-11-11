/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author João Victor
 */
package ThreadEnum;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conta extends Thread {
   private String nome;
   private double saldo;
   private String operacao;
   double valor;
   
   public Conta (String nome, double saldo) {
       this.nome = nome;
       this.saldo = saldo;
       this.operacao = "Consulta";
       double valor;
   } 

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getOperacao() {
        return this.operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    void exibirSaldo() {
        Thread consulta = new Thread(this);
        consulta.start();
       try {
           consulta.join();
       } catch (InterruptedException ex) {
           Logger.getLogger(Conta.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public void depositarValor(double valor) {
        this.valor = valor;
        this.setOperacao("Deposito");
        Thread deposito = new Thread(this);
        deposito.start();
       try {
           deposito.join();
       } catch (InterruptedException ex) {
           Logger.getLogger(Conta.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public void sacarValor(double valor){
        this.valor = valor * (-1);
        this.setOperacao("Saque");
        Thread saque = new Thread(this);
        saque.start();
       try {
           saque.join();
       } catch (InterruptedException ex) {
           Logger.getLogger(Conta.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public void run() {
        
        DateFormat dateFormat = new SimpleDateFormat ("dd-MM-yyyy hh:mm:ss:ms");
        Date data = new Date();
        System.out.println(dateFormat.format(data));
        
        try {
        System.out.println("Titular: " + this.nome);
        if (this.operacao == "Consulta") {
            System.out.println("Checando seu saldo...");
            Thread.sleep(1500);
            System.out.println("Saldo Atual: R$ " + this.getSaldo());
            System.out.println("===========================");
          
        }
        
        else if (this.operacao == "Deposito"){
            System.out.println("Realizando deposito...");
            Thread.sleep(1500);
            this.setSaldo(this.getSaldo() + this.getValor());
            System.out.println("Deposito: R$ " + this.getValor());
            System.out.println("Saldo Atual: R$ " + this.getSaldo());
            System.out.println("===========================");
          
        }
        
        else{
            System.out.println("Verificando Saldo...");
            Thread.sleep(1500);
            if(this.getSaldo()>=(this.getValor()*(-1))) {
            
                System.out.println("Realizando saque...");
                Thread.sleep(1500);
                this.setSaldo(this.getSaldo() + this.getValor());
                System.out.println("Saque: R$ " + this.getValor()); 
                System.out.println("Retire seu Dinheiro");
                System.out.println("Saldo Atual: R$ " + this.getSaldo());
                System.out.println("===========================");
            }
            else{
                System.out.println("Saldo Insuficiente!!");
                Thread.sleep(1500);
                System.out.println("Operação não realizada!");
                Thread.sleep(1500);
                System.out.println("Saldo Atual: R$ " + this.getSaldo());
                System.out.println("===========================");
            }
        } 
        this.valor = 0;
    } 
    catch (InterruptedException ex) {
                Logger.getLogger(Conta.class.getName()).log(Level.SEVERE, null, ex);
            }
    }   
}
