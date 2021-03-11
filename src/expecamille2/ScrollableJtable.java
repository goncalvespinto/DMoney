/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expecamille2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author thevenet
 */
public class ScrollableJtable extends JPanel {
    JScrollPane     scrollPane ;

    public ScrollableJtable() {
               setLayout(new BorderLayout());
       //setPreferredSize(new Dimension(400, 200));
        
        JTable table = new JTable(20, 20);
        //
        // Turn off JTable's auto resize so that JScrollpane
        // will show a horizontal scroll bar.
        //
     //   table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        JScrollPane pane = new JScrollPane(table);
        add(pane, BorderLayout.CENTER);
    }
    
    public ScrollableJtable(JTable table ) {
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
       setPreferredSize(new Dimension(100,100));
 

        
       
        //
        // Turn off JTable's auto resize so that JScrollpane
        // will show a horizontal scroll bar.
        //
      //  table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        scrollPane = new JScrollPane(table);
  
   
scrollPane.getViewport().setBackground(expecamille2.fenetre.colorBackground);
      
        add(scrollPane, BorderLayout.CENTER);
    }
    


}