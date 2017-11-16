package fr.cedric.GUI;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.cedric.components.Graph;
import fr.cedric.components.RouteType;

public class Menu extends JPanel{
	
	private Graph graph;
	private JButton valider;
	private CheckCombo routes;
	private JComboBox start,end;
	private JLabel path;
	private DrawGraph dg;
	
	public Menu(Graph g, DrawGraph dg){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setSize(300, 920);
        //controls.setBackground(Color.RED);
        this.setVisible(true);
        this.graph = g;
        this.dg = dg;
        addComponents();

	}
	private void addComponents(){
        add(new JLabel("Roads enabled :"));
        
        path = new JLabel("");
        
        add(Box.createRigidArea(new Dimension(0,20)));
        
        String[] ids = getRoutes();
        Boolean[] values = setValues(ids.length);
        routes = new CheckCombo(ids, values);
        add(routes.getContent());
        
        add(Box.createRigidArea(new Dimension(0,20)));
        
        add(new JLabel("Traveling :"));
        
        add(Box.createRigidArea(new Dimension(0,20)));
        
        add(new JLabel("I go from :"));
        
        add(Box.createRigidArea(new Dimension(0,20)));
        
        start = new JComboBox(getPos());
        start.setMaximumSize(new Dimension(300,30));
        add(start);
        
        add(Box.createRigidArea(new Dimension(0,20)));
        
        add(new JLabel("I go to :"));
        
        add(Box.createRigidArea(new Dimension(0,20)));
        
        end = new JComboBox(getPos());
        end.setMaximumSize(new Dimension(300,30));
        add(end);
        
        add(Box.createRigidArea(new Dimension(0,20)));
        
        valider = new JButton("Generate");
        valider.addActionListener(new MenuListener(graph,routes,start,end,path,dg));
       
        add(valider);
        
        add(Box.createRigidArea(new Dimension(0,20)));
        
        add(new JLabel("Path :"));
        
        add(Box.createRigidArea(new Dimension(0,20)));
        
        add(path);
	}
	
	private String[] getRoutes(){
		String [] routes = new String[RouteType.values().length];
		int i= 0;
		for(RouteType rt : RouteType.values()){
			routes[i] = rt.getName();
			i++;
		}
		return routes;
	}
	private Boolean[] setValues(int l){
		Boolean[] bool = new Boolean[l];
		for(int i=0;i<l;i++){
			bool[i] = Boolean.TRUE;
		}
		return bool;
	}
	private String[] getPos(){
		String [] pos = new String[graph.getNumberOfNodes()];
		for(int i=0;i<graph.getNumberOfNodes();i++){
			pos[i] = graph.getNode(i+1).getName();
		}
		return pos;
	}
	
	
	

}
