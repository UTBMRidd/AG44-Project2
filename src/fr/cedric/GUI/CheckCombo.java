package fr.cedric.GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import fr.cedric.components.RouteType;

public class CheckCombo implements ActionListener  
{  
         
        private String[] ids;
        private Boolean[] values;
         
         
        public CheckCombo(String[] ids,
                    Boolean[] values) {
                this.ids = ids;
                this.values = values;
        }
         
         
    public void actionPerformed(ActionEvent e)  
    {  
        JComboBox cb = (JComboBox)e.getSource();  
        CheckComboStore store = (CheckComboStore)cb.getSelectedItem();  
        CheckComboRenderer ccr = (CheckComboRenderer)cb.getRenderer();  
        ccr.checkBox.setSelected((store.state = !store.state));  
               this.values[cb.getSelectedIndex()]=store.state;
              /* for(int i=0;i<this.values.length;i++)
               {
                       if(this.values[i]) System.out.println("id= "+this.ids[i]);
               }*/
    }  
    
    /**
     * Prépare le contenu de la liste déroulante en fonction de la liste donnée en paramètre
     * @param ids la liste à ajouter
     * @param values les valeurs de cochage initial
     * @return 
     */
    public JPanel getContent()  
    {  
        CheckComboStore[] stores = new CheckComboStore[ids.length];  
        for(int j = 0; j < ids.length; j++)  
            stores[j] = new CheckComboStore(ids[j], values[j]);  
        JComboBox combo = new JComboBox(stores);
        combo.setRenderer(new CheckComboRenderer());  
        combo.addActionListener(this);  
        JPanel panel = new JPanel();
        panel.add(combo);
        panel.setMaximumSize(new Dimension(300,50));
        return panel;  
    }
    public ArrayList<RouteType> getDenied(){
    	ArrayList<RouteType> denied = new ArrayList<RouteType>();
    	for(int i=0;i<values.length;i++){
    		if(!values[i]){
    			denied.add(RouteType.values()[i]);
    		}
    	}
    	
    	
    	return denied;
    }
    
}  