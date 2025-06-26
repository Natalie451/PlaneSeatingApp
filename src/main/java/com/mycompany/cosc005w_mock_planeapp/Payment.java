/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cosc005w_mock_planeapp;

/**
 *
 * @author Natha
 */
public class Payment {

    private String email;
    private int paymentAmount;

    public Payment(String email, int paymentAmount) {
        this.email = email;
        this.paymentAmount = paymentAmount;

    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
    
    public int getPaymentAmount() {
        return this.paymentAmount;
    }
    
    public void printPayment() {
        System.out.println("Email: " + getEmail() + " " + "Payment Amount: " + "£" + getPaymentAmount());
        
    }
}
