
import com.panayotis.gnuplot.JavaPlot;
import com.panayotis.gnuplot.plot.DataSetPlot;
import com.panayotis.gnuplot.style.PlotStyle;
import com.panayotis.gnuplot.style.Style;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class JDDataSet extends javax.swing.JDialog {

    /**
     * Creates new form JDDataSet
     */
    int cuantos;
    ModeloDataSet TMElementos;
    Vector<pair<Double,Double>> pares = new Vector<pair<Double,Double>>();
    boolean ok;
    
    String titulo = "";
    public JDDataSet(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        TMElementos = new ModeloDataSet();
        initComponents();
        ok=false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        X = new javax.swing.JTextField();
        Continuar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TElementos = new javax.swing.JTable();
        Aceptar = new javax.swing.JButton();
        Y = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Eliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Nombre = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        X.setText("10");

        Continuar.setText("Agregar");
        Continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinuarActionPerformed(evt);
            }
        });

        TElementos.setModel(TMElementos);
        TElementos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(TElementos);

        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });

        Y.setText("1.0");

        jLabel1.setText("X");

        jLabel2.setText("Y");

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Nombre.setText("Nombre");

        jButton2.setText("Graficar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Título");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel1)
                        .add(18, 18, 18)
                        .add(X, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 51, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel2)
                        .add(18, 18, 18)
                        .add(Y, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(Continuar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(Eliminar))
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 363, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 2, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 116, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel3))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(Nombre)
                            .add(layout.createSequentialGroup()
                                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 125, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(Aceptar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(X, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(Y, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(Continuar)
                    .add(jLabel1)
                    .add(jLabel2)
                    .add(Eliminar))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 275, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 18, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Nombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Aceptar)
                    .add(jButton1)
                    .add(jButton2))
                .add(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinuarActionPerformed
        // TODO add your handling code here:
        double xx=Double.parseDouble(X.getText());
        double yy=Double.parseDouble(Y.getText());
        TMElementos.addRow(xx, yy);
    }//GEN-LAST:event_ContinuarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        // TODO add your handling code here:
        int fila=TElementos.getSelectedRow();
        if(fila!=-1)
        {
            TMElementos.removeRow(fila);
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        // TODO add your handling code here:
        ok=true;
        pares.clear();
        ArrayList<Object[]> datos=TMElementos.get_datos();
        int l=datos.size();
        int i;        
        for(i=0;i<l;i++)
            pares.add(new pair(datos.get(i)[0],datos.get(i)[1]));
        dispose();                
    }//GEN-LAST:event_AceptarActionPerformed

    public void plotear() {
        JavaPlot p = new JavaPlot();
        

        pares.clear();
        ArrayList<Object[]> datos=TMElementos.get_datos();
        int l=datos.size();
        double tab[][] = new double[l][2];

        
        for(int i=0;i<l;i++){
            tab[i][0] = ((Double)datos.get(i)[0]).doubleValue();
            tab[i][1] = ((Double)datos.get(i)[1]).doubleValue();
            System.out.println("x= " + tab[i][0] + " y= " + tab[i][1] );
        }
        
        
        PlotStyle myPlotStyle = new PlotStyle();        
        myPlotStyle.setStyle(Style.LINES);
        
        PlotStyle myPlotStyle2 = new PlotStyle();        
        myPlotStyle2.setStyle(Style.POINTS);
        myPlotStyle2.setLineType(3);
        
        DataSetPlot s = new DataSetPlot(tab);   
        DataSetPlot s2 = new DataSetPlot(tab);   
        
        s.setTitle(Nombre.getText());
        s.setPlotStyle(myPlotStyle);
        
        s2.setTitle("puntos");
        s2.setPlotStyle(myPlotStyle2);
        
        p.addPlot(s);        
        p.addPlot(s2);        
        
        p.setTitle(titulo);                
        p.newGraph();
        p.plot();
        
       
        
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        pares.clear();
        ArrayList<Object[]> datos=TMElementos.get_datos();
        int l=datos.size();
        int i;        
        for(i=0;i<l;i++)
            pares.add(new pair(datos.get(i)[0],datos.get(i)[1]));
        try
        {          
            FileWriter fichero = null;        
            fichero = new FileWriter("Conjuntos.txt",true);
            PrintWriter pw = null;
            pw = new PrintWriter(fichero);
            pw.print(Nombre.getText()+" ");
            pw.print("2 ");
            pw.print(pares.size()+" ");
            int tam=pares.size();
            for(i=0;i<tam;i++)
            {
                pair p=pares.get(i);
                pw.print(p.getL()+" "+p.getR()+" ");
            }            
            pw.println();
            fichero.close();
        }
         catch (Exception e) 
         {
            e.printStackTrace();
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:        
        plotear();
    }//GEN-LAST:event_jButton2ActionPerformed
    Vector<pair<Double,Double>>  getPares()
    {
        return pares;
    }
    boolean getOK()
    {
        return ok;
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
            java.util.logging.Logger.getLogger(JDDataSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDDataSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDDataSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDDataSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDDataSet dialog = new JDDataSet(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Continuar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JTextField Nombre;
    private javax.swing.JTable TElementos;
    private javax.swing.JTextField X;
    private javax.swing.JTextField Y;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}