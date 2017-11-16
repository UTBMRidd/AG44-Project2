package fr.cedric.GUI;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class CheckComboRenderer implements ListCellRenderer  {
 JCheckBox checkBox;  
     
     public CheckComboRenderer()  
     {  
         checkBox = new JCheckBox();  
     }  
     public Component getListCellRendererComponent(JList list,  
                                                   Object value,  
                                                   int index,  
                                                   boolean isSelected,  
                                                   boolean cellHasFocus)  
     {  
         CheckComboStore store = (CheckComboStore)value;  
         checkBox.setText(store.id);  
         checkBox.setSelected(((Boolean)store.state).booleanValue());  
         checkBox.setBackground(isSelected ? Color.red : Color.white);  
         checkBox.setForeground(isSelected ? Color.white : Color.black);  
         return checkBox;  
     } 
}
