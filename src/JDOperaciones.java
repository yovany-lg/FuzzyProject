
import com.panayotis.gnuplot.JavaPlot;
import com.panayotis.gnuplot.plot.DataSetPlot;
import com.panayotis.gnuplot.style.PlotStyle;
import com.panayotis.gnuplot.style.Style;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class JDOperaciones extends javax.swing.JDialog 
{
    DefaultListModel<String> modelo1 = new  DefaultListModel<String>();
    DefaultListModel<String> modelo2 = new  DefaultListModel<String>();
    String nombreConjunto1,nombreConjunto2;
    
    int tamA=0;
    int tamB=0;
    int totalAB = 0;
    // /*Codigo Yovany 
    public double [][] graphNorm(String opName, String mfA, String mfB) throws FileNotFoundException{
        double vectorA[][], vectorB[][],resultVector[][];
        MF funcA,funcB;

        vectorA = readMF("Conjuntos.txt",mfA);
        vectorB = readMF("Conjuntos.txt",mfB);
        if(vectorA == null){
            funcA = readMFC("Conjuntos.txt", mfA);
            funcB = readMFC("Conjuntos.txt", mfB);
            tConorm tN = new tConorm(opName,funcA,funcB);
            resultVector = tN.getPlotSet();
            return resultVector;
        }

        int aSize = vectorA.length, bSize = vectorB.length, totalLenght;
        int count = 0;
        double normValue;
        tamA = aSize;
        tamB = bSize;

        tConorm tN = new tConorm(opName);
        totalLenght = aSize*bSize;
        totalAB = totalLenght;
        
        resultVector = new double[totalLenght][3];
        for(int i = 0; i < aSize; i++){
            for(int j = 0; j < bSize; j++){
                    normValue = tN.evaluation(vectorA[i][1], vectorB[j][1]);
                    resultVector[count][0] = vectorA[i][0];
                    resultVector[count][1] = vectorB[j][0];
                    resultVector[count][2] = normValue;
                    count++;
                    //System.out.println(count);
            }
        }

        return resultVector;
    }
    
    public double [][] readMF(String fileName, String mfName) throws FileNotFoundException{
        java.io.File file = new File(fileName);
        // Create a Scanner for the file
        Scanner input = new Scanner(file);
        
        double [][]vector = null;
        
        // Read data from a file
        while(input.hasNext()) {
            if(input.next().toString().compareTo(mfName) == 0){ // Validar nombre
                //System.out.println("YEA!!");
                String functype = input.next().toString();
                if(Integer.parseInt(functype) == 1 || Integer.parseInt(functype) == 2){ //Validar tipo de funcion
                    //System.out.println("YEA!!");
                    int samples = Integer.parseInt(input.next().toString());
                    vector = new double[samples][2];
                    
                    for(int i = 0; i < samples; i++){
                        vector[i][0] = Double.parseDouble(input.next().toString());
                        vector[i][1] = Double.parseDouble(input.next().toString());
                        
                        //System.out.println("("+vector[i][0]+","+vector[i][1]+") ");
                    }
                    break;
                }
                break;
            }else{
                input.nextLine();
            }
        }

        // Close the file
        input.close();      
        return vector;
    }

    public MF readMFC(String fileName, String mfName) throws FileNotFoundException{
        java.io.File file = new File(fileName);
        // Create a Scanner for the file
        Scanner input = new Scanner(file);
        
        MF mf = null;
        
        // Read data from a file
        while(input.hasNext()) {
            if(input.next().toString().compareTo(mfName) == 0){ // Validar nombre
                // Funciones continuas
                if(Integer.parseInt(input.next().toString()) == 3){ //Validar tipo de funcion
                    double a,b,c,d,min,max;
                    //System.out.println("YEA!!");
                    String fName = input.next();
                    a = Double.parseDouble(input.next().toString());
                    b = Double.parseDouble(input.next().toString());
                    c = Double.parseDouble(input.next().toString());
                    d = Double.parseDouble(input.next().toString());
                    min = Double.parseDouble(input.next().toString());
                    max = Double.parseDouble(input.next().toString());
                    mf = new MF(fName,a,b,c,d,min,max);
                }
                break;
            }else{
                input.nextLine();
            }
        }

        // Close the file
        input.close();      
        return mf;
    }    
    
    public Integer exists(double vector[][],double x){
        int size = vector.length;
        
        for(int i = 0; i < size; i++){
            if(Double.compare(vector[i][0], x) == 0 ){
                return i;
            }
        }
        return -1;
    }
    // Codigo Yovany */
    
    public void readMF1(String fileName) 
    {
        try
        {
            java.io.File file = new File(fileName);
            Scanner input = new Scanner(file);        
            while(input.hasNext()) 
            {
                String cad=input.next();
                modelo1.addElement(cad);
                modelo2.addElement(cad);
                input.nextLine();
            }
            jListConjunto1.setModel(modelo1);
            jListConjunto2.setModel(modelo2);
            input.close();      
        }
        catch (Exception e) 
        {        
            System.out.println(            e.getMessage());
        }
    }
    public JDOperaciones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        readMF1("Conjuntos.txt");
        nombreConjunto1="";
        nombreConjunto2="";
        jListConjunto1.addListSelectionListener(new ListSelectionListener() 
        {
            public void valueChanged(ListSelectionEvent e)
            {
                nombreConjunto1=(String)jListConjunto1.getSelectedValue();
            }
        });
        jListConjunto2.addListSelectionListener(new ListSelectionListener() 
        {
            public void valueChanged(ListSelectionEvent e)
            {
                nombreConjunto2=(String)jListConjunto2.getSelectedValue();
            }
        });
        jListConjunto1.setSelectedIndex(0);
        jListConjunto2.setSelectedIndex(0);
        jListOperacion.setSelectedIndex(0);

    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jListConjunto1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListConjunto2 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListOperacion = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jListConjunto1.setModel(modelo1);
        jScrollPane1.setViewportView(jListConjunto1);

        jListConjunto2.setModel(modelo2);
        jScrollPane2.setViewportView(jListConjunto2);

        jLabel1.setText("Conjunto 1");

        jLabel2.setText("Conjunto 2");

        jListOperacion.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Yager", "Union" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jListOperacion);

        jLabel3.setText("Operación");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(29, 29, 29)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel3)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .add(jLabel1))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(58, 58, 58)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel2)
                                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jButton1)
                                .add(44, 44, 44)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(9, 9, 9)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20)
                .add(jLabel3)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(52, 52, 52)
                        .add(jButton1)))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String normName=(String)jListOperacion.getSelectedValue();
        System.out.println("conjunto1="+nombreConjunto1);
        System.out.println("conjunto2="+nombreConjunto2);
        double resultVector[][] = null;
        
        try {
            resultVector = graphNorm(normName,nombreConjunto1,nombreConjunto2);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JDOperaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JavaPlot p = new JavaPlot();        
        p.setTitle((String)jListOperacion.getSelectedValue());                
        p.newGraph3D();
        
        PlotStyle myPlotStyle = new PlotStyle();        
        myPlotStyle.setStyle(Style.LINESPOINTS);
        myPlotStyle.setLineType(3);
        
        // Cuando se obtuvo por funciones continuas
        totalAB = resultVector.length;
        if(tamA == 0 && tamB == 0 && totalAB > 0){
            tamA = (int) Math.sqrt(totalAB);
            tamB = tamA;
        }

        double datos[][] = new double[tamB][3]; 
        int cont =0;
        
        for(int i = 0; i < tamA; i++){
            for(int j = 0; j < tamB; j++){                    
                datos[j][0]=resultVector[cont][0];
                datos[j][1]=resultVector[cont][1];
                datos[j][2]=resultVector[cont][2];
                cont++;                    
                //System.out.print("("+datos[j][0]+", "+datos[j][1]+", "+datos[j][2]+") ");
            }
            //System.out.println();
            //cont = 0;
            DataSetPlot s = new DataSetPlot(datos);
            s.setTitle("");       
            s.setPlotStyle(myPlotStyle);

            p.getAxis("x").setLabel("X");
            p.getAxis("y").setLabel("Y");
            p.getAxis("z").setLabel("Z");
            p.addPlot(s);
        }
        //System.out.println("\n\n");
        //datos = null;
        double datos2[][] = new double[tamA][3]; 
        
        for(int i = 0; i < tamB; i++){
            cont = i;
            for(int j = 0; j < tamA; j++){                    
                datos2[j][0]=resultVector[cont][0];
                datos2[j][1]=resultVector[cont][1];
                datos2[j][2]=resultVector[cont][2];                
                cont+=tamB;
                //System.out.print("("+datos2[j][0]+", "+datos2[j][1]+", "+datos2[j][2]+") ");
            }
            System.out.println();

            DataSetPlot s = new DataSetPlot(datos2);
            s.setTitle("");       
            s.setPlotStyle(myPlotStyle);

            p.getAxis("x").setLabel("X");
            p.getAxis("y").setLabel("Y");
            p.getAxis("z").setLabel("Z");
            p.addPlot(s);
        }
        
        
        //p.getCommands("set view 60, 15");
        
        
        
        p.plot();        
        
        
            
        //dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    
     public void plotear(double tab[][] ) {
        JavaPlot p = new JavaPlot();        
        
        PlotStyle myPlotStyle = new PlotStyle();
        myPlotStyle.setStyle(Style.LINES);
        DataSetPlot s = new DataSetPlot(tab);
        myPlotStyle.setLineWidth(1);
        DataSetPlot testDataSetPlot = new DataSetPlot(tab);        
        s.setPlotStyle(myPlotStyle);     
        p.addPlot(s);
        p.newGraph();
        p.plot();       
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
            java.util.logging.Logger.getLogger(JDOperaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDOperaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDOperaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDOperaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDOperaciones dialog = new JDOperaciones(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jListConjunto1;
    private javax.swing.JList jListConjunto2;
    private javax.swing.JList jListOperacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
