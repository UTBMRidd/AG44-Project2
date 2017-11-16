package fr.cedric.GUI;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import fr.cedric.components.Graph;

public class Frame extends JFrame{
	
	private static final long serialVersionUID = -8123406571694511514L;
	
	public Frame(Graph g){
		super("Station de ski de l'arc");
		setSize(1500,920);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DrawGraph dg = new DrawGraph(g);
		add(dg);
        Menu m = new Menu(g, dg);
        add(m);
        
        JSplitPane splitPane = new JSplitPane();
        splitPane.setSize(1500, 920);
        splitPane.setDividerSize(0);
        splitPane.setDividerLocation(1200);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(dg);
        splitPane.setRightComponent(m);

        this.add(splitPane);
        setVisible(true);

	}

}
