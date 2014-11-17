
import java.util.ArrayList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class ModeloDataSet  extends AbstractTableModel implements TableModelListener 
{
    ArrayList<Object[]> data = new ArrayList<Object[]>();
    String columnNames[] = { "X", "Y" };

    public ModeloDataSet()
    {
    }
    public ArrayList<Object[]> devuelve()
    {
        return data;
    }
    public ArrayList<Object[]> get_datos()
    {
        return data;
    }
    public void addRow(double a,double b)
    {

        Object [] objeto= {a,b};    
        data.add(objeto);
        
        
        //ordenamiento
        ArrayList<Object[]> datos=get_datos();
        int l=datos.size();
        double tab[][] = new double[l][2];

        
        for(int i=0;i<l;i++)
        {
            tab[i][0] = ((Double)datos.get(i)[0]).doubleValue();
            tab[i][1] = ((Double)datos.get(i)[1]).doubleValue();
            //System.out.println("x= " + tab[i][0] + " y= " + tab[i][1] );
        }
        
           
        for(int i=0;i<l;i++)
            for(int j=i+1; j<l; j++)
            {
                if(tab[i][0]>tab[j][0])
                {
                    double tmp = tab[i][0];
                    tab[i][0] = tab[j][0];
                    tab[j][0] = tmp;
                    
                    tmp = tab[j][1];
                    tab[j][1] = tab[i][1];
                    tab[i][1] = tmp;                                        
                }
                
            }
        
        
        
        data.clear();
        
        for(int i=0;i<l;i++)
        {
            Object [] obj= {tab[i][0],tab[i][1]};    
            data.add(obj);           
        }
        
        
        fireTableRowsInserted(data.size()-1, data.size()-1);
    }
    public void removeRow(int row)
    { 
        data.remove(row);
        fireTableRowsDeleted(row, row);
    }
    public int getColumnCount() 
    {
        return columnNames.length;
    }
    @Override
    public String getColumnName(int column) 
    {
        return columnNames[column];
    }
    public int getRowCount() 
    {
        return data.size();
    }
    public Object getValueAt(int row, int column) 
    {
        if(data.size()==0)
            return null;
        return data.get(row)[column];
    }
    @Override
    public void setValueAt(Object value, int row, int column) 
    {
        data.get(row)[column]=value;
    }
    @Override
    public boolean isCellEditable(int row, int column) 
    {
       // if(column >=3 )
            return false;
       // return false;
    }
     public void tableChanged(TableModelEvent e) {
         
     }
     @Override
     public Class<?> getColumnClass(int columnIndex) 
     {
         if (columnIndex == 3)
             return Boolean.class;
         return super.getColumnClass(columnIndex);
     }        
}