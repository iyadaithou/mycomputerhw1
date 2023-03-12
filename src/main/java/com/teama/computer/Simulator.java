/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/*Naming the package of the project
*/
package com.teama.computer;

/*Importing the main elements that we will be using in this code
*/
import com.sun.tools.javac.Main;
//Importing the color class that will be used for the buttons and other elements in the code 
import java.awt.Color;
//Importing the file class as well/
import java.io.File;
//We will be using a hashmap to store the values in the code
//Importing this to handle errors
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.util.concurrent.ConcurrentHashMap;
import java.util.*;

/**
 *
 * @author Awesome Team 1;
 */
public class Simulator extends javax.swing.JFrame {

 
    public Simulator() {
        // this is where we initate the components of the simulator
        initComponents();
        
             
    }
   int MAX_ENTRIES=16;
   //create a memory to store value and its address
   LinkedHashMap<String, String> Cache = new LinkedHashMap<String, String>(MAX_ENTRIES + 1, .75F, false) { //Define cache
         protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {   //remove first entry when the cache exceeds 16 line limit
            return size() > MAX_ENTRIES;}
         };
    
    //Here we set up the hashmap that will be used to store the values when we click on store and then to fetch the values when we click on load. 
   HashMap<String, String> memorya= new HashMap<String, String>(); 
  
   HashMap<String, String> instruct = new HashMap<String, String>();
 // initiatlizing the program counter of  operations. 
    int programcounter=0; 
    
    //Set of t registers
    String r="";
    //Set of toggle bit that are used for operations ranging from 0 to15 
    String x15= "0";
    String x14= "0";//
    String x13= "0";
    String x12= "0";
    String x11= "0";
    String x10= "0";
    String x9= "0";
    String x8= "0";
    String x7= "0";
    String x6= "0";
    String x5= "0";
    String x4= "0";
    String x3= "0";
    String x2= "0";
    String x1= "0";
    String x0= "0";
// we are adding and setting the other elements
    String ix="";
    String i="";
    String address="0000";
    String Halt="Start";
    
    
// Here we have initiated the general repository
    
    String gpr0="0";
    String gpr1="0";
    String gpr2="0";
    String gpr3="0";
    
    //We initalize the general registers; 
    String ixr1="0";
    String ixr2="0";
    String ixr3="0";
      String hexaValue;
      
      
    boolean pc1=true;
    boolean negative=false;//undeflow
    int cc=0;
    int cc1=0; //overflow
    int cc2=0;//underflow
    int cc3=0; //divide by zero
    int cc4=0;//equal
      String hex;
      
      
      // The following is a basic implemenation of the Hashmap, the data structure we have used to serve as a memory for the project to store values in it, given the naturer of the key and fetching; 
      //Note that the size reuqired is outlined later on by setting the size of 2048
      
      public static final HashMap<String, String> Mapping = new HashMap<String, String>();//Mapping pushes lements in the dictionary 
    static {
            
        Mapping.put("000000", "HLT");
        Mapping.put("011110", "TRAP");
        Mapping.put("000001", "LDR");
        Mapping.put("000010", "STR");
        Mapping.put("000011", "LDA");
        Mapping.put("101001", "LDX");
        Mapping.put("101010", "STX");
             
                Mapping.put("000100", "AMR");
                Mapping.put("000101", "SMR");
                Mapping.put("000110", "AIR");
                Mapping.put("000111", "SIR");
        Mapping.put("001000", "JZ");
                Mapping.put("001001", "JNE");
                Mapping.put("001010", "JCC");
                Mapping.put("001011", "JMA");
                Mapping.put("001100", "JSR");
                Mapping.put("001101", "RFS");
                Mapping.put("001110", "SOB");
                Mapping.put("001111", "JGE");
                Mapping.put("010000", "MLT");
                Mapping.put("010001", "DVD");
                Mapping.put("010010", "TRR");
                Mapping.put("010011", "AND");
                Mapping.put("010100", "ORR");
                Mapping.put("010101", "NOT");
          
                Mapping.put("011001", "SRC");
                Mapping.put("011010", "RRC");
                Mapping.put("110001", "IN");
                Mapping.put("110010", "OUT");
                Mapping.put("110011", "CHK");
                
        
                System.out.println(Mapping);
    }
// Code to genereate GUI
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        GPR = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        GPR0 = new javax.swing.JTextField();
        GPR1 = new javax.swing.JTextField();
        GPR2 = new javax.swing.JTextField();
        GPR3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        IXR = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        IXR1 = new javax.swing.JTextField();
        IXR2 = new javax.swing.JTextField();
        IXR3 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        PC = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        MAR = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        MBR = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        IR = new javax.swing.JTextField();
        MFR = new javax.swing.JTextField();
        Priviledged = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        Address = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jToggleButton8 = new javax.swing.JToggleButton();
        jToggleButton9 = new javax.swing.JToggleButton();
        jToggleButton11 = new javax.swing.JToggleButton();
        jToggleButton10 = new javax.swing.JToggleButton();
        jToggleButton12 = new javax.swing.JToggleButton();
        I = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jToggleButton17 = new javax.swing.JToggleButton();
        IXR_input = new javax.swing.JPanel();
        jToggleButton15 = new javax.swing.JToggleButton();
        jToggleButton14 = new javax.swing.JToggleButton();
        jLabel17 = new javax.swing.JLabel();
        GPR_input = new javax.swing.JPanel();
        jToggleButton16 = new javax.swing.JToggleButton();
        jToggleButton7 = new javax.swing.JToggleButton();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jToggleButton6 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        console = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        printer1 = new javax.swing.JTextArea();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        keyboard1 = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        cache1 = new javax.swing.JTextArea();
        jLabel28 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        GPR.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("GPR A");

        jLabel2.setText("GPR B");

        jLabel3.setText("GPR C");

        jLabel4.setText("GPR D");

        jButton1.setText("LD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("LD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("LD");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("LD");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GPRLayout = new javax.swing.GroupLayout(GPR);
        GPR.setLayout(GPRLayout);
        GPRLayout.setHorizontalGroup(
            GPRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GPRLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GPRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(GPRLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(GPR0, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GPRLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(GPR3))
                    .addGroup(GPRLayout.createSequentialGroup()
                        .addGroup(GPRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(GPRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GPR1)
                            .addComponent(GPR2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(GPRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GPRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton3)
                        .addComponent(jButton2)
                        .addComponent(jButton4))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        GPRLayout.setVerticalGroup(
            GPRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GPRLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(GPRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(GPR0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(GPRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(GPR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(GPRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(GPR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(GPRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(GPR3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)))
        );

        IXR.setBackground(new java.awt.Color(204, 255, 255));

        jLabel5.setText("IXR A");

        jLabel6.setText("IXR B");

        jLabel7.setText("IXR C");

        jButton5.setText("LD");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("LD");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("LD");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout IXRLayout = new javax.swing.GroupLayout(IXR);
        IXR.setLayout(IXRLayout);
        IXRLayout.setHorizontalGroup(
            IXRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IXRLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(IXRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(IXRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(27, 27, 27)
                .addGroup(IXRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(IXR1)
                    .addComponent(IXR2)
                    .addComponent(IXR3, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(IXRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        IXRLayout.setVerticalGroup(
            IXRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IXRLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(IXRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(IXR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(IXRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(IXR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addGroup(IXRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(IXR3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addGap(15, 15, 15))
        );

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel8.setText("PC");

        jLabel9.setText("MAR");

        jLabel10.setText("MBR");

        jLabel11.setText("IR");

        jLabel12.setText("MFR");

        jLabel13.setText("Priviledged");

        jButton8.setText("LD");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("LD");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("LD");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PC)
                    .addComponent(MAR)
                    .addComponent(MBR)
                    .addComponent(IR)
                    .addComponent(MFR)
                    .addComponent(Priviledged, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton8)
                        .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(PC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(MAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(MBR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(IR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(MFR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(Priviledged, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLabel15.setText("Address");

        jToggleButton8.setText("0");
        jToggleButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton8ActionPerformed(evt);
            }
        });

        jToggleButton9.setText("1");
        jToggleButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton9ActionPerformed(evt);
            }
        });

        jToggleButton11.setText("2");
        jToggleButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton11ActionPerformed(evt);
            }
        });

        jToggleButton10.setText("3");
        jToggleButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton10ActionPerformed(evt);
            }
        });

        jToggleButton12.setText("4");
        jToggleButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddressLayout = new javax.swing.GroupLayout(Address);
        Address.setLayout(AddressLayout);
        AddressLayout.setHorizontalGroup(
            AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddressLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToggleButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddressLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddressLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        AddressLayout.setVerticalGroup(
            AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddressLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jToggleButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jToggleButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jToggleButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jToggleButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addContainerGap())
        );

        jLabel16.setText("I");

        jToggleButton17.setText("5");
        jToggleButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ILayout = new javax.swing.GroupLayout(I);
        I.setLayout(ILayout);
        ILayout.setHorizontalGroup(
            ILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ILayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jToggleButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ILayout.setVerticalGroup(
            ILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ILayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToggleButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(12, 12, 12))
        );

        jToggleButton15.setText("7");
        jToggleButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton15ActionPerformed(evt);
            }
        });

        jToggleButton14.setText("6");
        jToggleButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton14ActionPerformed(evt);
            }
        });

        jLabel17.setText("IXR");

        javax.swing.GroupLayout IXR_inputLayout = new javax.swing.GroupLayout(IXR_input);
        IXR_input.setLayout(IXR_inputLayout);
        IXR_inputLayout.setHorizontalGroup(
            IXR_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IXR_inputLayout.createSequentialGroup()
                .addComponent(jToggleButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
            .addGroup(IXR_inputLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        IXR_inputLayout.setVerticalGroup(
            IXR_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IXR_inputLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(IXR_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToggleButton16.setText("8");
        jToggleButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton16ActionPerformed(evt);
            }
        });

        jToggleButton7.setText("9");
        jToggleButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton7ActionPerformed(evt);
            }
        });

        jLabel18.setText("GPR");

        javax.swing.GroupLayout GPR_inputLayout = new javax.swing.GroupLayout(GPR_input);
        GPR_input.setLayout(GPR_inputLayout);
        GPR_inputLayout.setHorizontalGroup(
            GPR_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GPR_inputLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToggleButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jToggleButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GPR_inputLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(31, 31, 31))
        );
        GPR_inputLayout.setVerticalGroup(
            GPR_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GPR_inputLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(GPR_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToggleButton16, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jToggleButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addGap(24, 24, 24))
        );

        jToggleButton6.setText("10");
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });

        jToggleButton5.setText("11");
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });

        jToggleButton4.setText("12");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jToggleButton3.setText("13");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("14");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton1.setText("15");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel14.setText("Operation");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton6)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jToggleButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        console.setColumns(20);
        console.setRows(5);
        jScrollPane1.setViewportView(console);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GPR_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IXR_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(I, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GPR_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(IXR_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(I, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));

        jButton11.setText("Save/Store");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("ST");

        jButton13.setText("Load");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Initialize");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("Single Step ");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("Run");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel19.setText("Halt");

        jLabel20.setText("Run");

        jButton17.setText("Load Program 1");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton16))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton17, javax.swing.GroupLayout.Alignment.LEADING))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jButton13)
                    .addComponent(jButton14)
                    .addComponent(jButton12))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton15)
                            .addComponent(jButton16))
                        .addGap(18, 18, 18)
                        .addComponent(jButton17)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("TEAM A GUI");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel24.setText("Console Developper");

        jLabel27.setText("Cache");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addContainerGap(287, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        printer1.setColumns(20);
        printer1.setRows(5);
        jScrollPane7.setViewportView(printer1);

        jLabel25.setText("Console Printer");

        keyboard1.setColumns(20);
        keyboard1.setRows(5);
        jScrollPane8.setViewportView(keyboard1);

        jLabel26.setText("Keyboard");

        cache1.setColumns(20);
        cache1.setRows(5);
        jScrollPane9.setViewportView(cache1);

        jLabel28.setText("Cache");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(515, 515, 515)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(GPR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel24))))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane7)
                                    .addComponent(jScrollPane8)
                                    .addComponent(jScrollPane9)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel26)
                                            .addComponent(jLabel25)
                                            .addComponent(jLabel28))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IXR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(412, 412, 412))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(619, 619, 619)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(619, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(GPR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28)
                                .addGap(1, 1, 1)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(IXR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(117, 117, 117)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(191, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>                        

    private void jToggleButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        boolean selected = jToggleButton8.getModel().isSelected();
       //This function sets the color and change the value of the x0 to 1, which means that the button is clicked on 
        if (selected){
            x0="1";
    jToggleButton8.setForeground(Color.GREEN);
           
       }
       else{
           x0="0";
           jToggleButton8.setForeground(Color.BLACK);
       }
       
    }                                              

    private void jToggleButton9ActionPerformed(java.awt.event.ActionEvent evt) {                                               

     // This function sets operations  switched it when it's clicked 
          boolean selected = jToggleButton9.getModel().isSelected();
       if (selected){
           x1="1";
            
    jToggleButton9.setForeground(Color.GREEN);     
       }
       else{
           x1="0";
           jToggleButton9.setForeground(Color.BLACK);
       }
    }                                              

    private void jToggleButton11ActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // This function sets operations  switched it when it's clicked 
          boolean selected = jToggleButton11.getModel().isSelected();
       if (selected){
            x2="1";
        // this changes the color of the button 
    jToggleButton11.setForeground(Color.GREEN);
           
       }
       else{
           x2="0";
           jToggleButton11.setForeground(Color.BLACK);
       }
    }                                               

    //this function displays if the button is selected 
    private void jToggleButton10ActionPerformed(java.awt.event.ActionEvent evt) {                                                

        // // This function sets operations  switched it when it's clicked 
         boolean selected = jToggleButton10.getModel().isSelected();
       if (selected){
            x3="1";
    jToggleButton10.setForeground(Color.GREEN);
           
       }
       else{
           x3="0";
           jToggleButton10.setForeground(Color.BLACK);
       }
    }                                               

    private void jToggleButton12ActionPerformed(java.awt.event.ActionEvent evt) {                                                
         // This function sets operations  switched it when it's clicked 
         boolean selected = jToggleButton12.getModel().isSelected();
       if (selected){
            x4="1";
    jToggleButton12.setForeground(Color.GREEN);
           
       }
       else{
           x4="0";
           jToggleButton12.setForeground(Color.BLACK);
       }
    }                                               

    private void jToggleButton17ActionPerformed(java.awt.event.ActionEvent evt) {                                                
        
        //This code changes the value of the selected element to 1
         boolean selected = jToggleButton17.getModel().isSelected();
       if (selected){
            x5="1";
    jToggleButton17.setForeground(Color.GREEN);
           
       }
       else{
           x5="0";
           jToggleButton17.setForeground(Color.BLACK);
       }
    }                                               

    private void jToggleButton14ActionPerformed(java.awt.event.ActionEvent evt) {                                                
        
        //This code changes the value of the selected element to 1
         boolean selected = jToggleButton14.getModel().isSelected();
       if (selected){
           x6="1";
            
    jToggleButton14.setForeground(Color.GREEN);
           
       }
       else{
           x6="0";
           jToggleButton14.setForeground(Color.BLACK);
       }
    }                                               

    private void jToggleButton15ActionPerformed(java.awt.event.ActionEvent evt) {                                                
        
        //This code changes the value of the selected element to 1
         boolean selected = jToggleButton15.getModel().isSelected();
       if (selected){
            x7="1";
    jToggleButton15.setForeground(Color.GREEN);
           
       }
       else{
           x7="0";
           jToggleButton15.setForeground(Color.BLACK);
       }
    }                                               

    private void jToggleButton16ActionPerformed(java.awt.event.ActionEvent evt) {                                                
        
        //This code changes the value of the selected element to 1
         boolean selected = jToggleButton16.getModel().isSelected();
       if (selected){
            x8="1";
    jToggleButton16.setForeground(Color.GREEN);
           
       }
       else{
           x8="0";
           jToggleButton16.setForeground(Color.BLACK);
       }
    }                                               

    private void jToggleButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        
        //This code changes the value of the selected element to 1
         boolean selected = jToggleButton7.getModel().isSelected();
       if (selected){
            x9="1";
    jToggleButton7.setForeground(Color.GREEN);
           
       }
       else{
           x9="0";
           jToggleButton7.setForeground(Color.BLACK);
       }
    }                                              

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        
        //This code changes the value of the selected element to 1
         boolean selected = jToggleButton6.getModel().isSelected();
       if (selected){
            x10="1";
    jToggleButton6.setForeground(Color.GREEN);
           
       }
       else{
           x10="0";
           jToggleButton6.setForeground(Color.BLACK);
       }
    }                                              

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        
        //This code changes the value of the selected element to 1
         boolean selected = jToggleButton5.getModel().isSelected();
       if (selected){
            x11="1";
    jToggleButton5.setForeground(Color.GREEN);
           
       }
       else{
           x11="0";
           jToggleButton5.setForeground(Color.BLACK);
       }
    }                                              

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        
        //This code changes the value of the selected element to 1
         boolean selected = jToggleButton4.getModel().isSelected();
       if (selected){
            x12="1";
    jToggleButton4.setForeground(Color.GREEN);
           
       }
       else{
           x12="0";
           jToggleButton4.setForeground(Color.BLACK);
       }
    }                                              

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        
        //This code changes the value of the selected element to 1
         boolean selected = jToggleButton3.getModel().isSelected();
       if (selected){
            x13="1";
    jToggleButton3.setForeground(Color.GREEN);
           
       }
       else{
           x13="0";
           jToggleButton3.setForeground(Color.BLACK);
       }
    }                                              

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        
        //This code changes the value of the selected element to 1
         boolean selected = jToggleButton2.getModel().isSelected();
       if (selected){
            x14="1";
    jToggleButton2.setForeground(Color.GREEN);
           
       }
       else{
           x14="0";
           jToggleButton2.setForeground(Color.BLACK);
       }
    }                                              

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        
        //This code changes the value of the selected element to 1
         boolean selected = jToggleButton1.getModel().isSelected();
       if (selected){
            x15="1";
    jToggleButton1.setForeground(Color.GREEN);
           
       }
       else{
           x15="0";
           jToggleButton1.setForeground(Color.BLACK);
       }
    }                                              
    public void sTringToHexa(){
       // This function converts a string to hexadeicmal format after first concatenating the elements fetched from the operations
       //he we combine all the strins values
        String finals=x15+x14+x13+x12+x11+x10+x9+x8+x7+x6+x5+x4+x3+x2+x1+x0;
        int binary= Integer.parseInt(finals,2);
        // After combining them, we need to convert the string into a binary string using the following method below
         hexaValue = Integer.toString(binary,16).toUpperCase();
         // 
        if (hexaValue.length() < 4)//add trailing zeroes
    hexaValue = "000".substring(hexaValue.length() - 1) + hexaValue;
        
    }
     
    String EffectiveAddress (String address, String bin){
    
    sTringToHexa();
         String add= address;
       
              i = bin.substring(10, 11);
               ix = bin.substring(8, 10);
               if ("0".equals(i)){
                   if ("00".equals(ix)){
                       return add;
                   }
                   else if ("01".equals(ix)){
                       int decimal1=Integer.parseInt(add,16); 
                       int decimal2=0;
                       if(IXR1.getText() == null || "".equals( IXR1.getText())){
                       decimal2=0;
                   }else{
                        decimal2=Integer.parseInt(IXR1.getText(),16); 
                       }
                       int sum = decimal1+decimal2;
                     
                       
                       return DecimaltoHexa(sum);
                   }
                   else if ("10".equals(ix)){
                       int decimal1=Integer.parseInt(add,16); 
                       int decimal2=0;
                       if(IXR2.getText() == null || "".equals( IXR2.getText())){
                       decimal2=0;
                   }else{
                        decimal2=Integer.parseInt(IXR2.getText(),16); 
                       }
                       int sum = decimal1+decimal2;
                     
                       
                       return DecimaltoHexa(sum);
                   }
                   else if ("11".equals(ix)){
                       int decimal1=Integer.parseInt(add,16); 
                       int decimal2=0;
                       if(IXR3.getText() == null || "".equals( IXR3.getText())){
                       decimal2=0;
                   }else{
                        decimal2=Integer.parseInt(IXR3.getText(),16); 
                       }
                       int sum = decimal1+decimal2;
                     
                       
                       return DecimaltoHexa(sum);
                   }
               }
               else {
                    if ("00".equals(ix)){
                        
                        return memorya.get(add);
                        
                    }
                   else if ("01".equals(ix)){
                       int decimal1=Integer.parseInt(memorya.get(add),16); 
                       int decimal2=0;
                       if(memorya.get(IXR1.getText()) == null || "".equals( memorya.get(IXR1.getText()))){
                       decimal2=0;
                   }else{
                        decimal2=Integer.parseInt(memorya.get(IXR1.getText()),16); 
                       }
                       int sum = decimal1+decimal2;
                     
                       
                       return DecimaltoHexa(sum);
                       
                       
                      
                   }
                   else if ("10".equals(ix)){
                        int decimal1=Integer.parseInt(memorya.get(add),16); 
                       int decimal2=0;
                       if(memorya.get(IXR2.getText()) == null || "".equals( memorya.get(IXR2.getText()))){
                       decimal2=0;
                   }else{
                        decimal2=Integer.parseInt(memorya.get(IXR2.getText()),16); 
                       }
                       int sum = decimal1+decimal2;
                     
                       
                       return DecimaltoHexa(sum);
                   }
                   else if ("11".equals(ix)){
                         int decimal1=Integer.parseInt(memorya.get(add),16); 
                       int decimal2=0;
                       if(memorya.get(IXR3.getText()) == null || "".equals( memorya.get(IXR3.getText()))){
                       decimal2=0;
                   }else{
                        decimal2=Integer.parseInt(memorya.get(IXR3.getText()),16); 
                       }
                       int sum = decimal1+decimal2;
                     
                       
                       return DecimaltoHexa(sum);
                   }
               
               }
              
              return address;
    }
     String DecimaltoHexa(int dec){
       
         hexaValue = Integer.toString(dec,16).toUpperCase();
        if (hexaValue.length() < 4)
    hexaValue = "000".substring(hexaValue.length() - 1) + hexaValue;
        return hexaValue;
        
    }
   String Hexa(String hexas){
   
        int binary= Integer.parseInt(hexas,2);
         hexaValue = Integer.toString(binary,16).toUpperCase();
        if (hexaValue.length() < 4)
    hexaValue = "000".substring(hexaValue.length() - 1) + hexaValue;
        return hexaValue;
        
    }
     String hexToBinary(String hex)
    {
        
        String binary = "";
 

        hexaValue = hexaValue.toUpperCase();
 
        // initializing the HashMap class
        HashMap<Character, String> hashMap
            = new HashMap<Character, String>();
 
        // storing the key value pairs
        hashMap.put('0', "0000");
        hashMap.put('1', "0001");
        hashMap.put('2', "0010");
        hashMap.put('3', "0011");
        hashMap.put('4', "0100");
        hashMap.put('5', "0101");
        hashMap.put('6', "0110");
        hashMap.put('7', "0111");
        hashMap.put('8', "1000");
        hashMap.put('9', "1001");
        hashMap.put('A', "1010");
        hashMap.put('B', "1011");
        hashMap.put('C', "1100");
        hashMap.put('D', "1101");
        hashMap.put('E', "1110");
        hashMap.put('F', "1111");
 
        int i;
        char ch;
 
      
        for (i = 0; i < hexaValue.length(); i++) {
            
            ch = hexaValue.charAt(i);
 
           
            if (hashMap.containsKey(ch))
 
                
                binary += hashMap.get(ch);
 
            
            else {
                binary = "Invalid Hexadecimal String";
                return binary;
            }
        }
 
        
        return binary;
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
      
       sTringToHexa();
        
        GPR1.setText(hexaValue);
        gpr1=GPR1.getText();
        
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
   
         sTringToHexa();
        GPR2.setText(hexaValue);
        gpr2=GPR2.getText();
        
    }                                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        sTringToHexa();
        
        GPR0.setText(hexaValue);
        gpr0=GPR0.getText();
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
   
        sTringToHexa();
        
        GPR3.setText(hexaValue);
        gpr3=GPR3.getText();
    }                                        

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        
        sTringToHexa();
        
        IXR1.setText(hexaValue);
        ixr1=IXR1.getText();
    }                                        

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        
        sTringToHexa();
        
        IXR2.setText(hexaValue);
        ixr2=IXR2.getText();
    }                                        

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
       
        sTringToHexa();
        
        IXR3.setText(hexaValue);
        ixr3=IXR3.getText();
    }                                        

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
       
        sTringToHexa();
        
        PC.setText(hexaValue);
    }                                        

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        //Setting value to MAR
         sTringToHexa();
        
        MAR.setText(hexaValue);
    }                                        

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        sTringToHexa();
      
        
        MBR.setText(hexaValue);
    }                                         

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        //init button 
        
        //set all text fields,memory,registers and program counters to null/0
        programcounter=0;
     GPR0.setText("");
     GPR1.setText("");
     GPR2.setText("");
     GPR3.setText("");
     IXR1.setText("");
     IXR2.setText("");
     IXR3.setText("");
     MAR.setText("");
     MBR.setText("");
     IR.setText("");
        PC.setText("0000");
        console.setText("Initialization successful \n");
        printer.setText("");
        keyboard.setText(""); 

     Halt="Start";
      jLabel19.setForeground(Color.BLACK); 
     
        
        String[] tokens;
       
        try{
            
        File myObj = new File("IPL.txt"); 
      Scanner myReader = new Scanner(myObj);
        
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
         tokens = data.split(" ");
         if(memorya.size() == 2048){          
             JOptionPane.showMessageDialog(null,"Word memory reached");
           
       }else{
         memorya.put(tokens[0],tokens[1]);
         updateCache(tokens[0],tokens[1]);
         displayCache();
         }
         
        
      }
   
       System.out.println(memorya);
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    }                                         

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        

        // Get the address value from MAR
        String add= MAR.getText(); 

        // Retrieve the value stored at the address in memorya
        String res = memorya.get(add);  

        // Set the value of MBR to the retrieved value
        MBR.setText(res);

        // Print out the retrieved value
        System.out.println(res);
    }                                         

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
    // Store the value of MBR in the memorya map with the key as the value of MAR
    memorya.put(MAR.getText(),MBR.getText());

    // Print out the entire memorya map
    System.out.println(memorya);

    }                                         

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {                                          
  // Call the method to convert string to hexadecimal
        sTringToHexa();
        
        try{
            while (true){
                
                int programcounter= Integer.parseInt(PC.getText(),16);
            // Convert the hexadecimal value of memorya to binary
                String bin =hexToBinary(memorya.get(i)); 
            
            // Increment the program counter
                programcounter++;
            
            // Print out the value of "i" and "value" in binary format, along with the program counter
                System.out.println("i" + hexToBinary(i)+" " +"value" + hexToBinary(memorya.get(i))+ programcounter); 
                System.out.println(bin);
            
            // Call the execute method with the current iteration's key and binary value
                execute(i,bin); 
            
            // Set the value of IR to the binary value
                 IR.setText(bin); 
            
            // Set the value of PC to the key of the current iteration
                 PC.setText(i); 
            
            // Put the key-binary value pair into the instruct map
                 instruct.put(i,bin); 
    }}catch(NullPointerException e)
     {    
         // Set the foreground color of jLabel19 to red
         jLabel19.setForeground(Color.red); 
          
    }                                         
    }

public void execute(String prc,String bin) {

    // Extracting the instruction code from the binary string
    String Mapper = bin.substring(0, 6); 
    // Extracting the register code from the binary string
    r = bin.substring(6, 8); 
    // Extracting the index code from the binary string
    ix = bin.substring(8, 10); 
    // Extracting the indirect bit from the binary string
    i = bin.substring(10, 11);
    // Extracting the address from the binary string
    address = bin.substring(11, 16);
    // Calculating the effective address
    String add=  EffectiveAddress(Hexa(address),bin); 
    
    int p = Integer.parseInt(prc,16)-1; //reduce program counter by 1 to get current program counter
               prc=DecimaltoHexa(p); // conver back to hexa decimal

    // Retrieving the instruction from the instruction map
    String instr=Mapping.get(Mapper); 

    if ("LDX".equals(instr) ||"STX".equals(instr) ){
                 if("0".equals(i)){
             console.append(prc + " : "+ instr + " "+ ix+" "+ Hexa(address)+"\n");
                 }else{
                      console.append(prc + " : "+instr + ", "+ ix+", "+ Hexa(address)+"," +i+"\n");
                 }
             }
             else if ("MLT".equals(instr) ||"DVD".equals(instr) ||"TRR".equals(instr)||"AND".equals(instr)||"ORR".equals(instr) ){
                 console.append(prc + " : "+instr + ", "+ r+", "+ ix+"\n");
             }
             else if("NOT".equals(instr)){
                 console.append(prc + " : "+instr + ", "+ r+"\n");
             }
               else if("HLT".equals(instr)){
                    console.append(prc + " : "+instr +"\n");
               }
             else{
                 if("0".equals(i)){
             console.append(prc + " : "+instr + ", "+ r+", "+ Hexa(address)+"\n");
                 }else{
                      console.append(prc + " : "+instr + ", "+ r+", "+ Hexa(address)+"," +i+"\n");
                 }
             }
    
    
    
    
    
    
    
    
    if(instr == "HLT"){
        System.out.println("null"); // halt
        Halt="end";
    }
    else{
         //instruction execution
     switch (instr){
                 case "LDR":
                   LDR(Mapper,r, ix,i,address, add) ;
                   
                     
                     break;
                 case "LDA":
                     LDA(Mapper,r, ix,i,address, add) ;
                      break;
                case "HLT":
                     System.out.println("HLT");
                      Halt="end";
                      break;
                  case "STR":
                      STR(Mapper,r, ix,i,address, add) ;
                     
                      break;
                      
                  case "LDX":
                      LDX(Mapper,r, ix,i,address, add) ;
                     
                     break;
                      
                case "STX":
                    STX(Mapper,r, ix,i,address, add) ;
                                          
                      break;
                      
                case "JZ":
                     JZ(Mapper,r,ix,i,address,add);
                     
                      break;
                
                      
                  case "JNE":
                      JNE(Mapper,r,ix,i,address,add);
                      
                      break;
                      
                      
                    case "JCC":
                        JCC(Mapper,r,ix,i,address,add);
                         
                      break;
                    
                    case "JMA":
                        JMA(Mapper,r,ix,i,address,add);
                       
                        break;
                        
                        
                    case "JSR":  
                        JSR(Mapper,r,ix,i,address,add);
                        
                        break;
                        
                    case "RFS":
                        RFS(Mapper,r,ix,i,address,add);

                        break;
                        
                        
                    case "SOB":
                        SOB(Mapper,r,ix,i,address,add);
                     
                      break;
                
                      
                      case "JGE":
                          JGE(Mapper,r,ix,i,address,add);
                     
                      break;
                    
                    case "AMR":
                         AMR(Mapper,r,ix,i,address,add);
                     break;      
                    
                      case "SMR":
                            SMR(Mapper,r,ix,i,address,add);
                     break;  
                     
                     
                    case "AIR":
                        AIR(Mapper,r,ix,i,address,add);
                        
                    
                     break;  
                     
                     
                     
                         case "SIR":
                             SIR(Mapper,r,ix,i,address,add);
                        
                     break; 
                     
                     
                     
                    case "MLT":
                        MLT(Mapper,r,ix,i,address,add);
                            
                     break;
                     
                     
                      case "DVD":
                           DVD(Mapper,r,ix,i,address,add);
                          
                     
                     break;      
                     
                     case "TRR":
                         TRR(Mapper,r,ix,i,address,add);
                         
                        
                     
                     break;      
                        
                     
                   
                     case "AND":
                        
                            AND(Mapper,r,ix,i,address,add);
                      
                     break; 
                     
                     case "ORR":
                        ORR(Mapper,r,ix,i,address,add);
                           
                    
                     break; 
                     
                      case "NOT":
                        NOT(Mapper,r,ix,i,address,add);
                           
                  
                     break; 
                     
                     
                 case "SRC":
                        
                        SRC(bin,r);   
                     
                       
                     break;     
                     
                case "RRC": 
                     RRC(bin,r);   
                   
                        break;
                        
                case "IN":
                    IN(r,address);
                    break;
                    
                case "OUT":
                    OUT(r,address);
                    break;    
                 default:
                     System.out.println("b");
                      break;
                     
    
    
        
    }
     }
 
 }

public void OUT(String r,String address){
    //OUT opcode
    if("00001".equals(address)){
        int x = getRxyc(r);
         if ("00".equals(r)){
                     
                       printer.append("\nHexadecimal: "+DecimaltoHexa(x)+ " Decimal :" +x); //prints both hexa decimal and ineteger value
                      
                     }
                     else if("01".equals(r)){
                        
                        printer.append("\nHexadecimal: "+DecimaltoHexa(x)+ " Decimal :" +x);//prints both hexa decimal and ineteger value
                       
                     }
                      else if("10".equals(r)){
                       
                        printer.append("\nHexadecimal: "+DecimaltoHexa(x)+ " Decimal :" +x);//prints both hexa decimal and ineteger value
                    
                     }
                      else if("11".equals(r)){
                    
                       printer.append("\nHexadecimal: "+DecimaltoHexa(x)+ " Decimal :" +x);//prints both hexa decimal and ineteger value
                      
                     }
    }
}
public void IN(String r,String address){
    if("00000".equals(address)){
        String S = keyboard.getText(); //get input from keyboard
         if ("00".equals(r)){
                     
                        GPR0.setText(S); //set input to GPR0
                      
                     }
                     else if("01".equals(r)){
                        
                        GPR1.setText(S);//set input to GPR1
                       
                     }
                      else if("10".equals(r)){
                       
                        GPR2.setText(S);//set input to GPR2
                    
                     }
                      else if("11".equals(r)){
                    
                        GPR3.setText(S);//set input to GPR3
                      
                     }
    }
}
public void LDR(String opcode,String r, String ix,String i, String address,String add){
    //LDR implementation
    if ("00".equals(r)){
                     
                        GPR0.setText(memorya.get(add)); //set GPR0 with c(EA)
                        MAR.setText(add);//set MAR with EA
                        MBR.setText(memorya.get(add));//set MBR with c(EA)
                     }
                     else if("01".equals(r)){
                        
                        GPR1.setText(memorya.get(add));//set GPR1 with c(EA)
                        MAR.setText(add);//set MAR with EA
                        MBR.setText(memorya.get(add));//set MBR with c(EA)
                     }
                      else if("10".equals(r)){
                       
                        GPR2.setText(memorya.get(add));//set GPR2 with c(EA)
                        MAR.setText(add);//set MAR with EA
                        MBR.setText(memorya.get(add));//set MBR with c(EA)
                     }
                      else if("11".equals(r)){
                    
                        GPR3.setText(memorya.get(add));//set GPR3 with c(EA)
                        MAR.setText(add);//set MAR with EA
                        MBR.setText(memorya.get(add));//set MBR with c(EA)
                     }
}

public void LDA(String opcode,String r, String ix,String i, String address,String add){
    //LDA implementation
                     if ("00".equals(r)){
                     
                        GPR0.setText(add); //set GPRO with EA
                        MAR.setText(add);//set MAR with EA
                        MBR.setText(memorya.get(add));//set MAR with c(EA)
                     }
                     else if("01".equals(r)){
                        
                        GPR1.setText(add);//set GPR1 with EA
                        MAR.setText(add);//set MAR with EA
                        MBR.setText(memorya.get(add));//set MAR with c(EA)
                     }
                      else if("10".equals(r)){
                       
                        GPR2.setText(add);//set GPR2 with EA
                        MAR.setText(add);//set MAR with EA
                        MBR.setText(memorya.get(add));//set MAR with c(EA)
                     }
                      else if("11".equals(r)){
                    
                        GPR3.setText(add);//set GPR3 with EA
                        MAR.setText(add);//set MAR with EA
                        MBR.setText(memorya.get(add)); //set MAR with c(EA)
                     }
}


public void STR(String opcode,String r, String ix,String i, String address,String add){
//STR Implementation
if ("00".equals(r)){
                     
                        String temp = GPR0.getText();
                        memorya.put(add,temp);//store value of GPR0 to the effective address
                        System.out.println(add+temp);
                        MAR.setText(add);//set MAR as EA
                        MBR.setText(memorya.get(add));//set MBR as c(EA) 
                     }
                     else if("01".equals(r)){
                        
                        String temp = GPR1.getText();//store value of GPR1 to the effective address
                        memorya.put(add,temp);
                        MAR.setText(add);
                        MBR.setText(memorya.get(add));
                     }
                      else if("10".equals(r)){
                       
                        String temp = GPR2.getText();//store value of GPR2 to the effective address
                        memorya.put(add,temp);
                        MAR.setText(add);
                        MBR.setText(memorya.get(add));
                     }
                      else if("11".equals(r)){//store value of GPR3 to the effective address
                    
                        String temp = GPR3.getText();
                        memorya.put(add,temp);
                        MAR.setText(add);
                        MBR.setText(memorya.get(add));
                     }
                     

}
public void LDX(String opcode,String r, String ix,String i, String address,String add){
    //LDX Implementation
     if ("01".equals(ix)){
                         System.out.println("hello");
                        IXR1.setText(memorya.get(add)); //Store IXR1 with c(EA)
                        MAR.setText(add);//set MAR to EA
                        MBR.setText(memorya.get(add));
                     }
                     else if("10".equals(ix)){  
                        System.out.println("hello");
                        IXR2.setText(memorya.get(add));//Store IXR2 with c(EA)
                        MAR.setText(add);//set MAR to EA
                        MBR.setText(memorya.get(add));
                     }
                      else if("11".equals(ix)){ 
                       System.out.println("hello");
                        IXR3.setText(memorya.get(add));//Store IXR3 with c(EA)
                        MAR.setText(add);//set MAR to EA
                        MBR.setText(memorya.get(add));//set MBR to c(EA)
                     }
}
public void STX(String opcode,String r, String ix,String i, String address,String add){
    
    //STX implementation
   if("01".equals(ix)){
                        
                        String temp = IXR1.getText(); 
                        memorya.put(add,temp); //Store IXR1 in EA
                        MAR.setText(add);//set MAR to EA
                        MBR.setText(memorya.get(add));//set MBR to c(EA)
                     }
                      else if("10".equals(ix)){
                       
                        String temp = IXR2.getText();
                        memorya.put(add,temp); //Store IXR2 in EA
                        MAR.setText(add);//set MAR to EA
                        MBR.setText(memorya.get(add));//set MBR to c(EA)
                     }
                      else if("11".equals(ix)){
                    
                        String temp = IXR3.getText();//Store IXR3 in EA
                        memorya.put(add,temp);
                        MAR.setText(add);//set MAR to EA
                        MBR.setText(memorya.get(add));//set MBR to c(EA)
                     }
 
}

public void JZ(String opcode,String r, String ix,String i, String address,String add){
    //JZ implementation
     if ("00".equals(r)){
                     
                        String temp = GPR0.getText();
                        
                        if("0000".equals(temp)){  //if GPR0 is 0, change program counter to effective address
                            pc1=false;
                            PC.setText(add);
                     
                            System.out.println(add);
                        }
                        
                     
                     }
                     else if("01".equals(r)){ 
                        
                        String temp = GPR1.getText();
                        
                        if("0000".equals(temp)){//if GPR1 is 0, change program counter to effective address
                            pc1=false;
                            PC.setText(add);
                     
                            System.out.println(add);
                        }
                        
                     }
                      else if("10".equals(r)){ 
                       
                        String temp = GPR2.getText();
                     if("0000".equals(temp)){//if GPR2 is 0, change program counter to effective address
                            pc1=false;
                            PC.setText(add);
                     
                            System.out.println(add);
                        }
                     }
                      else if("11".equals(r)){  
                    
                        String temp = GPR3.getText();
                       if("0000".equals(temp)){//if GPR3 is 0, change program counter to effective address
                            pc1=false;
                            PC.setText(add);
                     
                            System.out.println(add);
                        }
                     }
                    
}
public void JNE(String opcode,String r, String ix,String i, String address,String add){
    if ("00".equals(r)){
                     
                        String temp = GPR0.getText();
                        
                        if(!"0000".equals(temp)){//if GPR0 is not equal to 0, change program counter to effective address
                            pc1=false;
                            PC.setText(add);
                     
                            System.out.println(add);
                        }
                        
                     
                     }
                     else if("01".equals(r)){
                        
                        String temp = GPR1.getText();
                        
                        if(!"0000".equals(temp)){//if GPR1 is not equal to 0, change program counter to effective address
                            pc1=false;
                            PC.setText(add);
                     
                            System.out.println(add);
                        }
                        
                     }
                      else if("10".equals(r)){
                       
                        String temp = GPR2.getText();
                     if(!"0000".equals(temp)){//if GPR2 is not equal to 0, change program counter to effective address
                            pc1=false;
                            PC.setText(add);
                     
                            System.out.println(add);
                        }
                     }
                      else if("11".equals(r)){//if GPR3 is not equal to 0, change program counter to effective address
                    
                        String temp = GPR3.getText();
                       if(!"0000".equals(temp)){
                            pc1=false;
                            PC.setText(add);
                     
                            System.out.println(add);
                        }
                     }    
                     
}
public void JCC(String opcode,String r, String ix,String i, String address,String add){
    //JCC implementation
   if ("00".equals(r)){//if cc1=1, set program counter to EA
    if(cc1!=0){
                         PC.setText(add);
                      System.out.println(add);
                         }
   }
   else if ("01".equals(r)){//if cc2=1, set program counter to EA
    if(cc2!=0){
                         PC.setText(add);
                      System.out.println(add);
                         }
   }
   else if ("10".equals(r)){//if cc3=1, set program counter to EA
    if(cc3!=0){
                         PC.setText(add);
                      System.out.println(add);
                         }
   }
   else if ("11".equals(r)){//if cc4=1, set program counter to EA
    if(cc4!=0){
                         PC.setText(add);
                      System.out.println(add);
                         }
   }
}
public void JMA(String opcode,String r, String ix,String i, String address,String add){
    //JMA implementation
     PC.setText(add);//Unditionally set PC to EA
}
public void JSR(String opcode,String r, String ix,String i, String address,String add){
    //JSR implementation
    String temp=PC.getText();
                    
                        int temp1=Integer.parseInt(temp,16);
                        System.out.println(temp1);
                      GPR3.setText (DecimaltoHexa( temp1)) ; //increment program counter by 1 and store it in GPR3
                      PC.setText(add);//set PC to EA
}
public void RFS(String opcode,String r, String ix,String i, String address,String add){
    //                        String hex1 = Integer.toString(Integer.parseInt(address),16).toUpperCase();
//                        if (hex1.length() < 4)
//                        hex1 = "000".substring(hex1.length() - 1) + hex1;
                        
                        //RFS imsplementation
                        GPR0.setText(add);//Store address to GPR0
                        PC.setText(GPR3.getText()); //set program counter to c(GPR3)
    
}
public void SOB(String opcode,String r, String ix,String i, String address,String add){
    //SOB Implementation
   if ("00".equals(r)){ 
                     
                        String temp2 = GPR0.getText();
                        
                        int temp3=Integer.parseInt(temp2,16)-1; 
                       
                      GPR0.setText (DecimaltoHexa( temp3)) ;//c(r)=c(r)-1
                     
                      if(temp3>0){
                          PC.setText(add);//set program to EA if c(r)>0
                      }
                     
                        
                     
                     }
                     else if("01".equals(r)){
                        
                       String temp2 = GPR1.getText();
                        
                        int temp3=Integer.parseInt(temp2,16)-1;
                       
                      GPR1.setText (DecimaltoHexa( temp3)) ;//c(r)=c(r)-1
                     
                      if(temp3>0){
                          PC.setText(add);//set program to EA if c(r)>0
                      }
                        
                     }
                      else if("10".equals(r)){
                       String temp2 = GPR2.getText();
                        
                        int temp3=Integer.parseInt(temp2,16)-1;
                       
                      GPR2.setText (DecimaltoHexa( temp3)) ;//c(r)=c(r)-1
                     
                      if(temp3>0){
                          PC.setText(add); //set program to EA if c(r)>0
                      }
                     }
                      else if("11".equals(r)){
                    
                       String temp2 = GPR3.getText();
                        
                        int temp3=Integer.parseInt(temp2,16)-1;
                       
                      GPR3.setText (DecimaltoHexa( temp3)) ; //c(r)=c(r)-1
                     
                      if(temp3>0){
                          PC.setText(add); //set program to EA if c(r)>0
                      }
                     }
                      
}
public void JGE(String opcode,String r, String ix,String i, String address,String add){
    
    //JGE implementation
     if ("00".equals(r)){
                     
                        String temp2 = GPR0.getText();
                        
                        int temp3=Integer.parseInt(temp2,16)-1;
                       
                      if (negative==true){ // for negative value we do 2's compliment
                           temp3 = ((Integer.parseInt(Integer.toString(Integer.parseInt(temp2, 16), 2).replace('0', 'X').replace('1', '0').replace('X', '1'), 2) + 1) * -1)-1;
                      }
                     
                      if(temp3+1>=0){//if c(r)>=0 set porgram counter as EA
                          PC.setText(add);
                      }
                     
                        
                     
                     }
                     else if("01".equals(r)){
                        
                       String temp2 = GPR1.getText();
                        
                        int temp3=Integer.parseInt(temp2,16)-1;
                       
                    if (negative==true){// for negative value we do 2's compliment
                           temp3 = ((Integer.parseInt(Integer.toString(Integer.parseInt(temp2, 16), 2).replace('0', 'X').replace('1', '0').replace('X', '1'), 2) + 1) * -1)-1;
                      }
                     
                      if(temp3+1>=0){
                          PC.setText(add);//if c(r)>=0 set porgram counter as EA
                      }
                        
                     }
                      else if("10".equals(r)){
                       String temp2 = GPR2.getText();
                        
                        int temp3=Integer.parseInt(temp2,16)-1;
                       
                   if (negative==true){// for negative value we do 2's compliment
                           temp3 = ((Integer.parseInt(Integer.toString(Integer.parseInt(temp2, 16), 2).replace('0', 'X').replace('1', '0').replace('X', '1'), 2) + 1) * -1)-1;
                      }
                     
                      if(temp3+1>=0){
                          PC.setText(add);//if c(r)>=0 set porgram counter as EA
                      }
                     }
                      else if("11".equals(r)){
                    
                       String temp2 = GPR3.getText();
                        
                        int temp3=Integer.parseInt(temp2,16)-1;
                       
               if (negative==true){// for negative value we do 2's compliment
                           temp3 = ((Integer.parseInt(Integer.toString(Integer.parseInt(temp2, 16), 2).replace('0', 'X').replace('1', '0').replace('X', '1'), 2) + 1) * -1)-1;
                      }
                     
                      if(temp3+1>=0){
                          PC.setText(add);//if c(r)>=0 set porgram counter as EA
                      }
                     }
                    
}
public void AMR(String opcode,String r, String ix,String i, String address,String add){
    //AMR implementation
    if ("00".equals(r)){//c(r)=c(r)+c(EA)
                           int temp2= Integer.parseInt(memorya.get(add),16);
                           int temp3 = Integer.parseInt(GPR0.getText(),16);
                        GPR0.setText(DecimaltoHexa(temp2+temp3));
                       
                     }
                     else if("01".equals(r)){ //c(r)=c(r)+c(EA)
                        
                        int temp2= Integer.parseInt(memorya.get(add),16);
                           int temp3 = Integer.parseInt(GPR1.getText(),16);
                        GPR1.setText(DecimaltoHexa(temp2+temp3));
                     }
                      else if("10".equals(r)){ //c(r)=c(r)+c(EA)
                       
                       int temp2= Integer.parseInt(memorya.get(add),16);
                           int temp3 = Integer.parseInt(GPR2.getText(),16);
                        GPR2.setText(DecimaltoHexa(temp2+temp3));
                     }
                      else if("11".equals(r)){//c(r)=c(r)+c(EA)
                    
                     int temp2= Integer.parseInt(memorya.get(add),16);
                           int temp3 = Integer.parseInt(GPR3.getText(),16);
                        GPR3.setText(DecimaltoHexa(temp2+temp3));
                     }
                     
}
public void SMR(String opcode,String r, String ix,String i, String address,String add){
  if ("00".equals(r)){//c(r)=c(r)-c(EA)
                           int temp2= Integer.parseInt(memorya.get(add),16);
                           int temp3 = Integer.parseInt(GPR0.getText(),16);
                        GPR0.setText(DecimaltoHexa(temp3-temp2));
                        if ((temp3-temp2)<0){
                            negative=true;
                            cc2=1;
                            console.append("cc(2)=1"); //set underflow if negative value
                        }
                        else{
                            negative=false;
                            cc2=0;
                        }
                       
                     }
                     else if("01".equals(r)){
                        
                        int temp2= Integer.parseInt(memorya.get(add),16);
                           int temp3 = Integer.parseInt(GPR1.getText(),16);
                        GPR1.setText(DecimaltoHexa(temp3-temp2));
                         if ((temp3-temp2)<0){
                            negative=true;
                            cc2=1;
                            console.append("cc(2)=1"); //set underflow if negative value
                        }
                        else{
                            negative=false;
                            cc2=0;
                        }
                     }
                      else if("10".equals(r)){
                       
                       int temp2= Integer.parseInt(memorya.get(add),16);
                           int temp3 = Integer.parseInt(GPR2.getText(),16);
                        GPR2.setText(DecimaltoHexa(temp3-temp2));
                         if ((temp3-temp2)<0){
                            negative=true;
                            cc2=1;
                            console.append("cc(2)=1");//set underflow if negative value
                        }
                        else{
                            negative=false;
                            cc2=0;
                        }
                     }
                      else if("11".equals(r)){
                    
                     int temp2= Integer.parseInt(memorya.get(add),16);
                           int temp3 = Integer.parseInt(GPR3.getText(),16);
                        GPR3.setText(DecimaltoHexa(temp3-temp2));
                         if ((temp3-temp2)<0){
                            negative=true;
                            cc2=1;
                            console.append("cc(2)=1");//set underflow if negative value
                        }
                        else{
                            negative=false;
                            cc2=0;
                        }
                     }
                       
}
public void AIR(String opcode,String r, String ix,String i, String address,String add){
    //implement AIR
  if ("00".equals(r)){ //r=c(r)+c(EA)
                           int temp2= Integer.parseInt(address,2);
                           int temp3 = Integer.parseInt(GPR0.getText(),16);
                        GPR0.setText(DecimaltoHexa(temp3+temp2));
                      
                       
                     }
                     else if("01".equals(r)){ //r=c(r)+c(EA)
                        
                        int temp2= Integer.parseInt(address,2);
                           int temp3 = Integer.parseInt(GPR1.getText(),16);
                        GPR1.setText(DecimaltoHexa(temp3+temp2));
                     }
                      else if("10".equals(r)){ //r=c(r)+c(EA)
                       
                      int temp2= Integer.parseInt(address,2);
                           int temp3 = Integer.parseInt(GPR2.getText(),16);
                        GPR2.setText(DecimaltoHexa(temp3+temp2));
                     }
                      else if("11".equals(r)){ //r=c(r)+c(EA)
                    
                    int temp2= Integer.parseInt(address,2);
                           int temp3 = Integer.parseInt(GPR3.getText(),16);
                        GPR3.setText(DecimaltoHexa(temp3+temp2));
                     }
                   
}
public void SIR(String opcode,String r, String ix,String i, String address,String add){
    //SIR implementation
     if ("00".equals(r)){ //r=c(r)-c(EA)
                           int temp2= Integer.parseInt(address,2);
                           int temp3 = Integer.parseInt(GPR0.getText(),16);
                        GPR0.setText(DecimaltoHexa(temp3-temp2));
                         if ((temp3-temp2)<0){
                            negative=true;
                            cc2=1;
                            console.append("cc(2)=1"); //set underflow if negative value
                        }
                        else{
                            negative=false;
                            cc2=0;
                        }
                       
                     }
                     else if("01".equals(r)){ //r=c(r)-c(EA)
                        
                        int temp2= Integer.parseInt(address,2);
                           int temp3 = Integer.parseInt(GPR1.getText(),16);
                        GPR1.setText(DecimaltoHexa(temp3-temp2));
                         if ((temp3-temp2)<0){
                            negative=true;
                            cc2=1;
                            console.append("cc(2)=1"); //set underflow if negative value
                        }
                        else{
                            negative=false;
                            cc2=0;
                        }
                     }
                      else if("10".equals(r)){ //r=c(r)-c(EA)
                       
                      int temp2= Integer.parseInt(address,2);
                           int temp3 = Integer.parseInt(GPR2.getText(),16);
                        GPR2.setText(DecimaltoHexa(temp3-temp2));
                         if ((temp3-temp2)<0){
                            negative=true;
                            cc2=1;
                            console.append("cc(2)=1"); //set underflow if negative value
                        }
                        else{
                            negative=false;
                            cc2=0;
                        }
                     }
                      else if("11".equals(r)){ //r=c(r)-c(EA)
                    
                    int temp2= Integer.parseInt(address,2);
                           int temp3 = Integer.parseInt(GPR3.getText(),16);
                        GPR3.setText(DecimaltoHexa(temp3-temp2));
                         if ((temp3-temp2)<0){
                            negative=true;
                            cc2=1;
                            console.append("cc(2)=1"); //set underflow if negative value
                        }
                        else{
                            negative=false;
                            cc2=0;
                        }
                     }
                
                    
}
public void MLT(String opcode,String r, String ix,String i, String address,String add){
    //Multiplication implementation c(rx)*c(ry)
  int temp2=0;
                            int temp3=0;
                            int high=0;
                            int low=0;
                            int prod=1;
                     if (("00".equals(r) || "10".equals(r)) && ("00".equals(ix) || "10".equals(ix)) ){//check for rx and ry to be 0 or 2
                         
                         if ("00".equals(r)){
                          temp2 = Integer.parseInt(GPR0.getText(),16);
                          temp3 = Integer.parseInt(GPR2.getText(),16);
                          prod = temp2*temp3;
                          if (prod>Integer.MAX_VALUE){
                              cc=1;
                              cc1=1;
                             console.append("cc(1)=1 \n"); //set overflow
                          }
                          else{
                              cc1=0;
                              console.append("cc(1)=0 \n"); 
                              cc=0;
                          }
                          System.out.println(prod);
                          high = prod >> 16; //extracting last 16 bits
                          System.out.println(high);
                          low= prod & 0xFFFF;//extracting first 16 bits
                          System.out.println(low);
                          GPR0.setText(DecimaltoHexa(high));//higher bits are stored in rx
                          GPR1.setText(DecimaltoHexa(low));//lower bits are stored in rx+1
                         
                         }
                         if ("10".equals(r)){
                              temp2 = Integer.parseInt(GPR0.getText(),16);
                          temp3 = Integer.parseInt(GPR2.getText(),16);
                           prod = temp2*temp3;
                           if (prod>Integer.MAX_VALUE){
                              cc=1;
                              cc1=1;
                             console.append("cc(1)=1 \n"); //set overflow
                          }
                          else{
                              cc1=0;
                              console.append("cc(1)=0 \n");
                              cc=0;
                          }
                          high = prod>>16;//extracting last 16 bits
                          low= prod & 0xFFFF;//extracting first 16 bits
                          GPR2.setText(DecimaltoHexa(high));//higher bits are stored in rx
                          GPR3.setText(DecimaltoHexa(low));//lower bits are stored in rx+1
                         }
                       
                    
                       
                     }  
}
public void DVD(String opcode,String r, String ix,String i, String address,String add){
    //DVD implemmentation c(rx)/c(ry)
     int temp2=0;
                            int temp3=0;
                            int high=0;
                            int low=0;
                            int prod=1;
                          int  q=1;
                          int rem=0;
                           
                     if (("00".equals(r) || "10".equals(r)) && ("00".equals(ix) || "10".equals(ix)) ){
                         
                         if ("00".equals(r)){
                          temp2 = Integer.parseInt(GPR0.getText(),16);
                          temp3 = Integer.parseInt(GPR2.getText(),16);
                          if(temp3==0){
                              cc=3;
                              cc3=1; 
                              console.append("cc(3)=1 \n"); //Divide by zero flag
                          }
                          else{
                              cc3=0;
                              console.append("cc(3)=0 \n");
                              cc=0;
                          }
                           System.out.println(temp2);
                           System.out.println(temp3);
                       
                          q=temp2/temp3; //calculate quotient
                          System.out.println(q);
                          rem=temp2%temp3;//calculate remainder
                          System.out.println(r);
                          GPR0.setText(DecimaltoHexa(q)); //quotient is store in rx
                          GPR1.setText(DecimaltoHexa(rem));//remiander is stored in rx+1
                         
                         }
                         if ("10".equals(r)){
                              temp2 = Integer.parseInt(GPR0.getText(),16);
                          temp3 = Integer.parseInt(GPR2.getText(),16);
                           if(temp3==0){
                              cc=3;
                              cc3=1; 
                              console.append("cc(3)=1 \n"); //Divide by zero flag
                          }
                          else{
                               cc3=0;
                              console.append("cc(3)=0 \n");
                              cc=0;
                          }
                           q=temp2/temp3;
                          System.out.println(q);
                          rem=temp2%temp3;
                          System.out.println(r);
                          GPR2.setText(DecimaltoHexa(q));
                          GPR3.setText(DecimaltoHexa(rem ));
                         }
                       
                    
                       
                     }
                  
}
public void TRR(String opcode,String r, String ix,String i, String address,String add){
  //TRR implementation c(rx)==c(ry)
   int rx=getRxyc(r);
                         int ry=getRxyc(ix);                        
                            if(rx==ry){
                              cc=4;
                              cc4=1;
                              console.append("cc(4)=1 \n");
                          }
                            else{
                                console.append("cc(4)=0 \n");
                                cc4=0;
                                cc=0;
                            }
                          
}
public void AND(String opcode,String r, String ix,String i, String address,String add){
    //AND implementation c(rx) and c(ry)
                        int rx=getRxyc(r);
                         int ry=getRxyc(ix);     
                       
                        setRxyc(r,DecimaltoHexa(rx&ry));
}
public void ORR(String opcode,String r, String ix,String i, String address,String add){
                //AND implementation c(rx)or  c(ry)        
                        int rx=getRxyc(r);
                        int ry=getRxyc(ix);
                        setRxyc(r,DecimaltoHexa(rx | ry));
}
public void NOT(String opcode,String r, String ix,String i, String address,String add){
    //not implementation 
                        int rx=getRxyc(r);
                        
                        setRxyc(r,DecimaltoHexa(~rx & 0xffff));
}
public void SRC(String bin, String r){
    //SRC implementation
    String R= bin.substring(6, 8);
                       int AL = Integer.parseInt(bin.substring(8, 9),2);
                       int LR = Integer.parseInt(bin.substring(9, 10),2);
                       int count = Integer.parseInt(bin.substring(11, 16),2);
                       int data = getRxyc(r);
                       
                        if (AL == 0) { //arithmetic shift
                            if (LR == 0) {//left shift
                                data = data >> count;
                            }
                            if (LR == 1) {//right shift
                               data = data << count;
                            }
                        }
                        if (AL == 1) {//logical shift
                            if (LR == 0) { //left shift
                                if (data >= 0)
                                    data = (data >>> count);
                                else {
                                    String x = Integer.toBinaryString(data >>> count);
                                    x = x.replace("1111111111111111", "");
                                    data = Integer.parseInt(x, 2);
                                }
                            }
                            if (LR == 1) {//right shift
                                data = data << count;
                            }
                        }
                        setRxyc(R,DecimaltoHexa(data));
                       
    
}
public void RRC(String bin, String r){
    //RRC
    String R= bin.substring(6, 8);
                       int AL = Integer.parseInt(bin.substring(8, 9),2);
                    int  LR = Integer.parseInt(bin.substring(9, 10),2);
                      int  count = Integer.parseInt(bin.substring(11, 16),2);
                     int   data = getRxyc(r); 
                    String first=null;
                    String second =null;
                    String bindata=Integer.toBinaryString(data);
                        if(data>=0){
                            bindata=bindata.replace("0000000000000000", "");
                        }
                      if(data<0){
                          bindata=bindata.replaceAll("1111111111111111", "");
                      }
                         if (LR == 1) {//right rotate
                                first = bindata.substring(count, bindata.length());
                                second = bindata.substring(0, count);
                                bindata = first + second;
                            }
                            if (LR == 0) {//left rotate
                                first = bindata.substring(0, bindata.length() - count);
                                second = bindata.substring(bindata.length() - count, bindata.length());
                                 bindata = second + first;
                            }
                            System.out.println(first);
                            System.out.println(second);
                             System.out.println(bindata);
                            data=Integer.parseInt(bindata,2);
                            setRxyc(r,DecimaltoHexa(data));
}
public int getRxyc( String r){
     switch (r){
                             case "00":
                               return Integer.parseInt(GPR0.getText(),16);
                             
                             case "01":
                               return Integer.parseInt(GPR1.getText(),16);
                            
                             case "10":
                               return Integer.parseInt(GPR2.getText(),16);
                               
                             case "11":
                               return  Integer.parseInt(GPR3.getText(),16);
                           
                             default:
                                 break;
                         }
     return 0;
}

public void setRxyc( String r, String data){
     switch (r){
                             case "00":
                               GPR0.setText(data);
                              break;
                             case "01":
                                GPR1.setText(data);
                             break;
                             case "10":
                                GPR2.setText(data);
                                break;
                             case "11":
                              GPR3.setText(data);
                            break;
                             default:
                                 break;
                         }
    
}
 public void updateCache(String address, String data){
               Cache.put(address, data);//update cache with new values
              
                
                     
    }
 
 
 public void displayCache(){
     System.out.print(Cache);
     cache.setText("");
     Set <String> keys = Cache.keySet();//extract address
     for (String key :keys){
         cache.append("Tag: " + key + " Data: " + Cache.get(key)+ "\n");//display cache lines
     }
 }
     
   
    
    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        sTringToHexa();
        // Set the foreground color of the "jLabel19" component to black
        jLabel19.setForeground(Color.BLACK); 

        // Convert the value of the PC register from hexadecimal to decimal representation
        int prc=Integer.parseInt(PC.getText(),16); 

        // Convert the value at the current PC address in the memorya map from hexadecimal to binary representation
        String binary =hexToBinary(memorya.get(PC.getText()));

        // Print the binary representation to the console
        System.out.println(binary);

        // Execute the instruction at the current PC address
        execute(PC.getText(),binary);
        // Increment the PC register
        prc++;
        // Convert the incremented PC value back to hexadecimal representation
        PC.setText(DecimaltoHexa(prc));
        // Set the value of the IR register to the binary representation of the executed instruction
        IR.setText(binary);
        // Get the return value of the LastAdd method with the current PC address as input
        String end=LastAdd(PC.getText());
        // If the return value is "ends", set the foreground color of the "jLabel19" component to red
        if("ends".equals(end)){
            jLabel19.setForeground(Color.red);
            // Reset the PC register to "0000"
            PC.setText("0000");
            // Execute the instruction at the reset PC address
            execute(PC.getText(),memorya.get(PC.getText()));
        }
 
             
              
    }                                         

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        
    }                                           

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        //load program1
        // keyboard.setText("10,20,30,40,50,60,70,80,90,100,110,120,130,140,150,160,170,180,190,200,101");

        String S= keyboard.getText();//take inut from keybaord

        int counter =1;
        String[] arrSplit = S.split(",");
        int[] numbers = new int[21];

        PC.setText("0020"); //set program counter to start of program

        for (int i=0; i < arrSplit.length; i++)

        {
            System.out.println(arrSplit[i]);
            numbers[i]=Integer.parseInt(arrSplit[i]);
            memorya.put(DecimaltoHexa(counter), DecimaltoHexa(Integer.parseInt(arrSplit[i])));//load numbers into the memory
            counter++;

        }
        //  console.append(Integer.toString(counter));
        if (counter<22){
            console.append("Enter 20 comma seprated values followed by value to searched \n");//check if all values have been provided
        }
        else{
            console.append("Program 1 loaded, click run \n");
        }
        int searchNumber=numbers[20];
        //       System.out.println(searchNumber);
        //       System.out.println(prog);
        ////        int closestNumber = numbers[0];
        ////        for (int i = 1; i < 20; i++) {
            ////            if (Math.abs(numbers[i] - searchNumber) < Math.abs(closestNumber - searchNumber)) {
                ////                closestNumber = numbers[i];
                ////            }
            ////             System.out.println(closestNumber);
            ////        }
        //        GPR0.setText(DecimaltoHexa(closestNumber));
        //        printer.append("Closest Number:" +closestNumber);
        String [] tokens;
        try{

            File myObj = new File("Program1.txt"); //opens file "IPL.txt"
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                tokens = data.split(" ");
                if(memorya.size() == 2048){           // sets memory to 2048 words
                    JOptionPane.showMessageDialog(null,"Word memory reached");

                }else{
                    memorya.put(tokens[0],tokens[1]);   //sets value and their address in memory
                    updateCache(tokens[0],tokens[1]);
                    displayCache();
                }

            }

            System.out.println(memorya);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }                                         
    // This method takes a string argument "addr" and returns a string value
    String LastAdd(String addr){
        // Initialize a counter variable to count the number of occurrences of "addr" in the memorya map
        int count=0;
        // Iterating over the keys in the memorya map
        for (String i : memorya.keySet()){
            // If the current key is equal to the input "addr", increment the count
            if (i.equals(addr)){
                count++;
            }
        }
        // If the count is 0, return the string "ends"
        if(count==0){return "ends";}
        // Print the count to the console
        System.out.println("count"+count);
        // Return the string "hel"
        return "hel";
}

    
 // The main method is the starting point of the application
public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Simulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Simulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Simulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Simulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Simulator().setVisible(true);
                
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JPanel Address;
    private javax.swing.JPanel GPR;
    private javax.swing.JTextField GPR0;
    private javax.swing.JTextField GPR1;
    private javax.swing.JTextField GPR2;
    private javax.swing.JTextField GPR3;
    private javax.swing.JPanel GPR_input;
    private javax.swing.JPanel I;
    private javax.swing.JTextField IR;
    private javax.swing.JPanel IXR;
    private javax.swing.JTextField IXR1;
    private javax.swing.JTextField IXR2;
    private javax.swing.JTextField IXR3;
    private javax.swing.JPanel IXR_input;
    private javax.swing.JTextField MAR;
    private javax.swing.JTextField MBR;
    private javax.swing.JTextField MFR;
    private javax.swing.JTextField PC;
    private javax.swing.JTextField Priviledged;
    private javax.swing.JTextArea cache;
    private javax.swing.JTextArea cache1;
    private javax.swing.JTextArea console;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton10;
    private javax.swing.JToggleButton jToggleButton11;
    private javax.swing.JToggleButton jToggleButton12;
    private javax.swing.JToggleButton jToggleButton14;
    private javax.swing.JToggleButton jToggleButton15;
    private javax.swing.JToggleButton jToggleButton16;
    private javax.swing.JToggleButton jToggleButton17;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton7;
    private javax.swing.JToggleButton jToggleButton8;
    private javax.swing.JToggleButton jToggleButton9;
    private javax.swing.JTextArea keyboard;
    private javax.swing.JTextArea keyboard1;
    private javax.swing.JTextArea printer;
    private javax.swing.JTextArea printer1;
    // End of variables declaration                   
}
