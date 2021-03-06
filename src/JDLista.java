import com.panayotis.gnuplot.JavaPlot;
import com.panayotis.gnuplot.plot.DataSetPlot;
import com.panayotis.gnuplot.style.PlotColor;
import com.panayotis.gnuplot.style.PlotStyle;
import com.panayotis.gnuplot.style.Style;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class JDLista extends javax.swing.JDialog implements PlotColor{

    /**
     * Creates new form JDLista
     */

    Vector<pair<Double,Double>> pares = new Vector<pair<Double,Double>>();
    Vector<pair<Double,Double>> pares2 = new Vector<pair<Double,Double>>();
    
    boolean ok;
    String titulo;

    public JDLista(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ok=false;
        Lista.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Xi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Lista = new javax.swing.JList();
        Nombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Xfin = new javax.swing.JTextField();
        Np = new javax.swing.JTextField();
        A = new javax.swing.JTextField();
        B = new javax.swing.JTextField();
        C = new javax.swing.JTextField();
        Xini = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        D = new javax.swing.JTextField();
        Graficar = new javax.swing.JButton();
        Aceptar = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();

        Xi.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Lista.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Triangular", "Trapezoidal", "Gaussiana", "Bell", "Sigmoidal", "LR" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        Lista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Lista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(Lista);

        Nombre.setText("grafica00");
        Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        Xfin.setText("100");

        Np.setText("8");

        A.setText("20");

        B.setText("60");

        C.setText("80");
        C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CActionPerformed(evt);
            }
        });

        Xini.setText("0");
        Xini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XiniActionPerformed(evt);
            }
        });

        jLabel2.setText("a");

        jLabel3.setText("Xf");

        jLabel4.setText("b");

        jLabel5.setText("d");

        jLabel6.setText("c");

        jLabel7.setText("Xi");

        jLabel8.setText("#p");

        D.setText("100");

        Graficar.setText("Graficar");
        Graficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraficarActionPerformed(evt);
            }
        });

        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 103, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(layout.createSequentialGroup()
                                    .add(jLabel3)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                    .add(Xfin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(layout.createSequentialGroup()
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel2)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel4)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel6)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel8)
                                        .add(jLabel5))
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                        .add(D, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                        .add(C)
                                        .add(B)
                                        .add(A)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, Np))))
                            .add(layout.createSequentialGroup()
                                .add(22, 22, 22)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(Aceptar)
                                    .add(Graficar)
                                    .add(Guardar))))
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(Nombre)
                        .add(162, 162, 162))
                    .add(layout.createSequentialGroup()
                        .add(0, 6, Short.MAX_VALUE)
                        .add(jLabel7)
                        .add(18, 18, 18)
                        .add(Xini, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(156, 156, 156))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(Nombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane1)
                        .add(30, 30, 30))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel7)
                            .add(Xini, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(5, 5, 5)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(6, 6, 6)
                                .add(jLabel3))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, Xfin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(Np, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel8))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(A, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel2))
                        .add(4, 4, 4)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(B, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel4))
                        .add(12, 12, 12)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(C, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel6))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(D, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel5))
                        .add(18, 18, 18)
                        .add(Graficar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(Guardar)
                        .add(22, 22, 22)
                        .add(Aceptar)
                        .add(0, 75, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CActionPerformed

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        // TODO add your handling code here:
        ok=true;
        dispose();
    }//GEN-LAST:event_AceptarActionPerformed
    boolean getOK()
    {
        return ok;
    }
    Vector<pair<Double,Double>>  getPares()
    {
        return pares;
    }
    private void XiniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XiniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_XiniActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        // TODO add your handling code here:


        pares.clear();
        pares2.clear();
        int i;
        double limiteInferior,limiteSuperior,npuntos,incremento;
        double npuntos2,incremento2;
        double AA,BB,CC,DD;
        limiteInferior = Double.parseDouble(Xini.getText());
        limiteSuperior = Double.parseDouble(Xfin.getText());
        npuntos = Double.parseDouble(Np.getText());
        npuntos2 = npuntos * 50;
        
        incremento  = Math.abs(limiteSuperior-limiteInferior)/npuntos;
        incremento2 = Math.abs(limiteSuperior-limiteInferior)/npuntos2;
            AA = Double.parseDouble(A.getText());
            BB = Double.parseDouble(B.getText());
            CC = Double.parseDouble(C.getText());
            DD = Double.parseDouble(D.getText());
            System.out.println("opcion es "+Lista.getSelectedIndex());
            
            
        titulo= (String)Lista.getSelectedValue()+ "(";
        if(Lista.getSelectedIndex()==0)
        {
            for(i=0;i<=npuntos;i++,limiteInferior+=incremento)
                pares.add(new pair(limiteInferior,Triangular(limiteInferior,AA,BB,CC)));
            
            limiteInferior = Double.parseDouble(Xini.getText());            
            for(i=0;i<=npuntos2;i++,limiteInferior+=incremento2)
                pares2.add(new pair(limiteInferior,Triangular(limiteInferior,AA,BB,CC)));
            
            titulo +=""+AA+", "+BB+ ", "+CC+ ") ";
            
        
        }
        else if(Lista.getSelectedIndex()==1){
            
            for(i=0;i<=npuntos;i++,limiteInferior+=incremento)
                pares.add(new pair(limiteInferior,Trapezoidal(limiteInferior,AA,BB,CC,DD)));
            
            limiteInferior = Double.parseDouble(Xini.getText());            
            for(i=0;i<=npuntos2;i++,limiteInferior+=incremento2)
                 pares2.add(new pair(limiteInferior,Trapezoidal(limiteInferior,AA,BB,CC,DD)));
            
            titulo +=""+AA+", "+BB+ ", "+CC+ ", "+DD+ ") ";
            
        }
        else if(Lista.getSelectedIndex()==2)
        {
            for(i=0;i<=npuntos;i++,limiteInferior+=incremento)
                pares.add(new pair(limiteInferior,Gusianna(limiteInferior,AA,BB)));
            
            limiteInferior = Double.parseDouble(Xini.getText());            
            for(i=0;i<=npuntos2;i++,limiteInferior+=incremento2)
               pares2.add(new pair(limiteInferior,Gusianna(limiteInferior,AA,BB)));
            
            titulo +=""+AA+", "+BB+  ") ";
            
        }
        else if(Lista.getSelectedIndex()==3){
            
            for(i=0;i<=npuntos;i++,limiteInferior+=incremento)
                pares.add(new pair(limiteInferior,Bell(limiteInferior,AA,BB,CC)));
            
            limiteInferior = Double.parseDouble(Xini.getText());            
            for(i=0;i<=npuntos2;i++,limiteInferior+=incremento2)
               pares2.add(new pair(limiteInferior,Bell(limiteInferior,AA,BB,CC)));
            
            titulo +=""+AA+", "+BB+ ", "+CC+ ") ";
        }
        else if(Lista.getSelectedIndex()==4){
            for(i=0;i<=npuntos;i++,limiteInferior+=incremento)
                pares.add(new pair(limiteInferior,Sigmoide(limiteInferior,AA,BB,CC)));

            limiteInferior = Double.parseDouble(Xini.getText());            
            for(i=0;i<=npuntos2;i++,limiteInferior+=incremento2)
               pares2.add(new pair(limiteInferior,Sigmoide(limiteInferior,AA,BB,CC)));
        
            titulo +=""+AA+", "+BB+ ", "+CC+ ") ";
        }                
        else if(Lista.getSelectedIndex()==5)
         {
            for(i=0;i<=npuntos;i++,limiteInferior+=incremento)
                pares.add(new pair(limiteInferior,LR(limiteInferior,AA,BB,CC)));
            
            
            limiteInferior = Double.parseDouble(Xini.getText());            
            for(i=0;i<=npuntos2;i++,limiteInferior+=incremento2)
               pares2.add(new pair(limiteInferior,LR(limiteInferior,AA,BB,CC)));
            
            titulo +=""+AA+", "+BB+ ", "+CC+ ") ";
         }

        try
        {          
            FileWriter fichero = null;        
            fichero = new FileWriter("Conjuntos.txt",true);
            PrintWriter pw = null;
            pw = new PrintWriter(fichero);
            pw.print(Nombre.getText()+" ");
            pw.print("1 ");
            pw.print(pares.size()+" ");
            int tam=pares.size();
            for(i=0;i<tam;i++)
            {
                pair p=pares.get(i);
                pw.print(p.getL()+" "+p.getR()+" ");
            }            
            pw.println();
            fichero.close();
            
             plotear();
             
             

        }
         catch (Exception e) 
         {
            e.printStackTrace();
         }
                
        
        
    }//GEN-LAST:event_GuardarActionPerformed

    private void GraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraficarActionPerformed
        // TODO add your handling code here:
        
        
        pares.clear();
        pares2.clear();
        int i;
        double limiteInferior,limiteSuperior,npuntos,incremento;
        double npuntos2, incremento2;
        double AA,BB,CC,DD;
        
        limiteInferior = Double.parseDouble(Xini.getText());
        limiteSuperior = Double.parseDouble(Xfin.getText());
        npuntos = Double.parseDouble(Np.getText());
        npuntos2 = npuntos * 50;
        
        incremento=Math.abs(limiteSuperior-limiteInferior)/npuntos;
        incremento2 = Math.abs(limiteSuperior-limiteInferior)/npuntos2;
            AA = Double.parseDouble(A.getText());
            BB = Double.parseDouble(B.getText());
            CC = Double.parseDouble(C.getText());
            DD = Double.parseDouble(D.getText());
            
        System.out.println("opcion es "+Lista.getSelectedIndex());

        titulo= (String)Lista.getSelectedValue()+ "(";
        if(Lista.getSelectedIndex()==0)
        {
            for(i=0;i<=npuntos;i++,limiteInferior+=incremento)
                pares.add(new pair(limiteInferior,Triangular(limiteInferior,AA,BB,CC)));
            
            limiteInferior = Double.parseDouble(Xini.getText());            
            for(i=0;i<=npuntos2;i++,limiteInferior+=incremento2)
                pares2.add(new pair(limiteInferior,Triangular(limiteInferior,AA,BB,CC)));
            
            titulo +=""+AA+", "+BB+ ", "+CC+ ") ";
            
        
        }
        else if(Lista.getSelectedIndex()==1){
            
            for(i=0;i<=npuntos;i++,limiteInferior+=incremento)
                pares.add(new pair(limiteInferior,Trapezoidal(limiteInferior,AA,BB,CC,DD)));
            
            limiteInferior = Double.parseDouble(Xini.getText());            
            for(i=0;i<=npuntos2;i++,limiteInferior+=incremento2)
                 pares2.add(new pair(limiteInferior,Trapezoidal(limiteInferior,AA,BB,CC,DD)));
            
            titulo +=""+AA+", "+BB+ ", "+CC+ ", "+DD+ ") ";
            
        }
        else if(Lista.getSelectedIndex()==2)
        {
            for(i=0;i<=npuntos;i++,limiteInferior+=incremento)
                pares.add(new pair(limiteInferior,Gusianna(limiteInferior,AA,BB)));
            
            limiteInferior = Double.parseDouble(Xini.getText());            
            for(i=0;i<=npuntos2;i++,limiteInferior+=incremento2)
               pares2.add(new pair(limiteInferior,Gusianna(limiteInferior,AA,BB)));
            
            titulo +=""+AA+", "+BB+  ") ";
            
        }
        else if(Lista.getSelectedIndex()==3){
            
            for(i=0;i<=npuntos;i++,limiteInferior+=incremento)
                pares.add(new pair(limiteInferior,Bell(limiteInferior,AA,BB,CC)));
            
            limiteInferior = Double.parseDouble(Xini.getText());            
            for(i=0;i<=npuntos2;i++,limiteInferior+=incremento2)
               pares2.add(new pair(limiteInferior,Bell(limiteInferior,AA,BB,CC)));
            
            titulo +=""+AA+", "+BB+ ", "+CC+ ") ";
        }
        else if(Lista.getSelectedIndex()==4){
            for(i=0;i<=npuntos;i++,limiteInferior+=incremento)
                pares.add(new pair(limiteInferior,Sigmoide(limiteInferior,AA,BB,CC)));

            limiteInferior = Double.parseDouble(Xini.getText());            
            for(i=0;i<=npuntos2;i++,limiteInferior+=incremento2)
               pares2.add(new pair(limiteInferior,Sigmoide(limiteInferior,AA,BB,CC)));
        
            titulo +=""+AA+", "+BB+ ", "+CC+ ") ";
        }                
        else if(Lista.getSelectedIndex()==5)
         {
            for(i=0;i<=npuntos;i++,limiteInferior+=incremento)
                pares.add(new pair(limiteInferior,LR(limiteInferior,AA,BB,CC)));
            
            
            limiteInferior = Double.parseDouble(Xini.getText());            
            for(i=0;i<=npuntos2;i++,limiteInferior+=incremento2)
               pares2.add(new pair(limiteInferior,LR(limiteInferior,AA,BB,CC)));
            
            titulo +=""+AA+", "+BB+ ", "+CC+ ") ";
         }
        
        
        try
        {          
            int tam=pares.size();
            for(i=0;i<tam;i++)
            {
                pair p=pares.get(i);
        
            }            
            plotear();
                        

        }
         catch (Exception e) 
         {
            e.printStackTrace();
         }
        
    }//GEN-LAST:event_GraficarActionPerformed

    private void ListaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListaValueChanged
        // TODO add your handling code here:
        
           int sel = Lista.getSelectedIndex();
           if(sel == -1)
               return;
        String t= (String)Lista.getModel().getElementAt(sel);
        




        if(t.equals("Triangular")){
            
            Xini.setText("0");
            Xfin.setText("100");
            
            A.setText("20");
            B.setText("60");
            C.setText("80");
            D.setText("0");
            
            
            
        }
        else if(t.equals("Trapezoidal")){

            Xini.setText("0");
            Xfin.setText("100");
            
            A.setText("10");
            B.setText("20");
            C.setText("60");
            D.setText("95");

        }
        else if(t.equals("Gaussiana")){
            Xini.setText("-2");
            Xfin.setText("10");
            
            A.setText("3");
            B.setText("1");
            C.setText("0");
            D.setText("0");
        }
        else if(t.equals("Bell")){
            Xini.setText("-2");
            Xfin.setText("10");
            
            A.setText("2");
            B.setText("1");
            C.setText("3");
            D.setText("0");
        }
        else if(t.equals("Sigmoidal")){
            Xini.setText("-10");
            Xfin.setText("10");
            
            A.setText("1");
            B.setText("0");
            C.setText("-5");
            D.setText("0");
        }
        else if(t.equals("LR")){
            Xini.setText("0");
            Xfin.setText("100");
            
            A.setText("10");
            B.setText("40");
            C.setText("25");
            D.setText("0");
        }
        
        
    }//GEN-LAST:event_ListaValueChanged

    private void NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreActionPerformed

    double Triangular(double x,double a,double b,double c)
    {
        if(x <=a )            
            return 0;
        if(a<=x && x<=b)
            return (x-a)/(b-a);
        if(b<=x && x<=c)
            return (c-x)/(c-b);
        if(c<=x)
            return 0;
        return 0;
    }
    double Trapezoidal(double x,double a,double b,double c,double d)
    {
        if(x <=a )            
            return 0;
        if(a<=x && x<=b)
            return (x-a)/(b-a);        
        if(b<=x && x<=c)
            return 1;
        if(c<=x && x<=d)
            return (d-x)/(d-c);
        if(d<=x)
            return 0;
        return 0;
    }
    double Gusianna(double x,double c,double sigma)
    {        
        return Math.exp(-0.5*Math.pow((x-c)/sigma, 2));
    }
    double Bell(double x,double a,double b,double c)
    {        
        return 1/(a+Math.pow(Math.abs((x-c)/a), 2*b));
    }
    
    double Sigmoide(double x,double a,double b,double c)
    {        
        return 1/(1+Math.exp(-a*(x-c)));
    }
    
    
    double LR(double x,double a,double b,double c)
    {        
        if(x<c)
            return FL((c-x)/a);
        else
            return FR((x-c)/b);
    }
    
    double FL(double x)
    {        
        return Math.sqrt(Math.max(0, 1-x*x));
    }

    double FR(double x)
    {        
        return Math.exp( -Math.pow(Math.abs(x),3.0) );
    }

    public void plotear() {
        JavaPlot p = new JavaPlot();
        
        
        double tab[][] = new double[pares.size()][2];
        double tab2[][] = new double[pares2.size()][2];
        
        
        for(int i=0; i<pares.size(); i++)
        {
            //tab = new double[2][2];
            pair punto  = (pair)pares.get(i);
            
            tab[i][0] = (double)punto.getL();
            tab[i][1] = (double)punto.getR();
            
            System.out.println("x= " + tab[i][0] + " y= " + tab[i][1] );
        }
        
        
        for(int i=0; i<pares2.size(); i++)
        {
            //tab = new double[2][2];
            pair punto  = (pair)pares2.get(i);
            
            tab2[i][0] = (double)punto.getL();
            tab2[i][1] = (double)punto.getR();
            
            System.out.println("x= " + tab2[i][0] + " y= " + tab2[i][1] );
        }
        
        PlotStyle myPlotStyle = new PlotStyle();        
        PlotStyle otherPlotStyle = new PlotStyle();        
        myPlotStyle.setStyle(Style.LINES);
       
        otherPlotStyle.setStyle(Style.POINTS);
        otherPlotStyle.setLineType(3);
        
      
        DataSetPlot s = new DataSetPlot(tab);
        s.setTitle(Np.getText()+ " puntos");
        s.setPlotStyle(otherPlotStyle);
        
        DataSetPlot s2 = new DataSetPlot(tab2);
        s2.setTitle(titulo);
        myPlotStyle.setLineWidth(1);
        //DataSetPlot testDataSetPlot = new DataSetPlot(tab);        
        s2.setPlotStyle(myPlotStyle);     
        p.addPlot(s2);
        p.addPlot(s);
        
        p.setTitle(titulo);
         //p.addPlot( "sin(x)" );       
         
        p.newGraph();
        p.plot();
        
       
        
    }
    
     public String getColor(){
    
           return "blue";
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(JDLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDLista dialog = new JDLista(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField A;
    private javax.swing.JButton Aceptar;
    private javax.swing.JTextField B;
    private javax.swing.JTextField C;
    private javax.swing.JTextField D;
    private javax.swing.JButton Graficar;
    private javax.swing.JButton Guardar;
    private javax.swing.JList Lista;
    private javax.swing.JTextField Nombre;
    private javax.swing.JTextField Np;
    private javax.swing.JTextField Xfin;
    private javax.swing.JTextField Xi;
    private javax.swing.JTextField Xini;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
