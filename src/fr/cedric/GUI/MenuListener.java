package fr.cedric.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import fr.cedric.components.Graph;
import fr.cedric.components.Path;
import fr.cedric.tools.Dijkstra;

public class MenuListener implements ActionListener{
	
	private CheckCombo routes;
	private JComboBox start,end;
	private JLabel path;
	private Graph g;
	private DrawGraph dg;
	
	public MenuListener(Graph g,CheckCombo cc,JComboBox s, JComboBox e, JLabel path, DrawGraph dg){
		this.routes = cc;
		this.start = s;
		this.end = e;
		this.path = path;
		this.g= g;
		this.dg = dg;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Graph n2 = g.redefineGraph(routes.getDenied());
		Path pth = Dijkstra.shortestPath(n2, start.getSelectedIndex()+1, end.getSelectedIndex()+1);
		path.setText(pth.getText());
		dg.setGraph(n2);
		dg.initGraph(dg.colorPath(pth));
	}

}
