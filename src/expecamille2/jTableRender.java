/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expecamille2;

/**
 *
 * @author thevenet
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Définir l'affichage dans un JTable
 *
 * @author Fobec 2010
 */
public class jTableRender extends DefaultTableCellRenderer {

    int typeTableau;

    jTableRender(int c) {
        typeTableau = c;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(expecamille2.fenetre.colorBackground);

table.setShowGrid(false);
table.setIntercellSpacing(new Dimension(0, 0));


setHorizontalAlignment(JLabel.CENTER);
        if (typeTableau != 0)
        {

        if (row == expecamille2.j.period - 1) {
            Color clr = new Color(224, 224, 224);
            component.setBackground(clr);
        } else {
            Color clr = new Color(224, 224, 224);
            component.setBackground(clr);
        }

        if (typeTableau == 1) {
            if (((row == expecamille2.j.period - 1 && column == 2) || (row == expecamille2.j.period - 1 && column == 8)) && expecamille2.j.phaseDecision) {
                Color clr = Color.WHITE;
                component.setBackground(clr);
            }

            if (column == 4 || column ==6 ||column ==9 ) {
                component.setBackground(expecamille2.fenetre.colorBackground);
                table.getColumnModel().getColumn(column).setHeaderRenderer(headerRenderer);
            }
        }
        if (typeTableau == 2) {
            if ((row == expecamille2.j.period - 1 && column == 1) && expecamille2.j.phaseDecision) {
                Color clr = Color.WHITE;
                component.setBackground(clr);
            }
                        if (column == 6 || column == 9) {
                component.setBackground(expecamille2.fenetre.colorBackground);
                table.getColumnModel().getColumn(column).setHeaderRenderer(headerRenderer);
            }

        }
        }
        else
        {
            table.setShowGrid(true);
            if (column == 0 || column == 1)
            {
            Color clr = new Color(224, 224, 224);
            component.setBackground(clr);
            }
            else
            {
             Color clr =Color.white;
            component.setBackground(clr);
            }
            
        }
        return component;

    }
}
