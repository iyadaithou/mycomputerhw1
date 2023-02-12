/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.teama.computer;

/**
 *
 * @author Awesome team 1
 */
public class Computer {

    public static void main(String[] args) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Simulator().setVisible(true);
            }
            
        });
        
        
        
    }
}
