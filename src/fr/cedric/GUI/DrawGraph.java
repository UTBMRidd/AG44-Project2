package fr.cedric.GUI;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.mxgraph.layout.mxParallelEdgeLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;

import fr.cedric.components.Edge;
import fr.cedric.components.Graph;
import fr.cedric.components.Node;
import fr.cedric.components.Path;

public class DrawGraph extends JPanel{
	
	private Graph graph;
	private mxGraphComponent graphC;
    private double[][] coord = {
    		{350, 850},//1
    		{450, 780},//2
    		{650, 740},//3
    		{760, 650},//4
    		{940,650},//5
    		{820,550},//6
    		{530, 470},//7
    		{600, 580},//8
    		{1000, 380},//9
    		{600, 400},//10
    		{820, 350},//11
    		{970,480},//12
    		{1100,100},//13
    		{1000,150},//14
    		{500, 350},//15
    		{900,220},//16
    		{500,530},//17
    		{450,700},//18
    		{400,600},//19
    		{300,670},//20
    		{320,520},//21
    		{600,270},//22
    		{600,200},//23
    		{500,150},//24
    		{820,40},//25
    		{820,130},//26
    		{150,150},//27
    		{150,480},//28
    		{100,380},//29
    		{250,400},//30
    		{350,300},//31
    		{650,30},//32
    		{400,50},//33
    		{240,70},//34
    		{100,250},//35
    		{350,150},//36
    		{500,100}	
    };
	
	public DrawGraph(Graph g){
		this.graph = g;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setSize(1200, 920);
        this.setBackground(Color.BLUE);
        this.setVisible(true);
        this.initGraph(drawGraph());

	}
	public void initGraph(mxGraph graph){
		//ImageIcon image = new ImageIcon("res/wallpaper.jpg");
		mxParallelEdgeLayout layout = new mxParallelEdgeLayout(graph);
		layout.execute(graph.getDefaultParent());
		graphC = new mxGraphComponent(graph);
		//graphComponent.setBackgroundImage(image);
		removeAll();
        add(graphC);
		
	}
	public mxGraph drawGraph(){
		mxGraph mgraph = new mxGraph();
		
	    Object parent = mgraph.getDefaultParent();
	    ArrayList<Object> vertices = new ArrayList<Object>();
	    
	    double h = 30;
	    double l = 80;

	    mgraph.getModel().beginUpdate();
	    try {
	      for(int i =1;i<=graph.getNumberOfNodes();i++){
	    	  Node n = graph.getNode(i);  
	    	  vertices.add(mgraph.insertVertex(parent, null, n.getName(), coord[i-1][0] - l/2, coord[i-1][1] - h/2, l, h, mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_HEXAGON));
	      }
	      for(int i =1;i<=graph.getNumberOfEdges();i++){
	    	Edge e = graph.getEdge(i);
	    	mgraph.insertEdge(parent, null, e.getType().getAlias(), vertices.get(e.getStart()-1), vertices.get(e.getArrival()-1));
	      }
	      
	    } finally {
	      mgraph.getModel().endUpdate();
	    }
	    
		return mgraph;
	}
	public void setGraph(Graph gr){
		this.graph = gr;
	}
	public mxGraph colorPath(Path pa){
		mxGraph mgraph = new mxGraph();
		
	    Object parent = mgraph.getDefaultParent();
	    ArrayList<Object> vertices = new ArrayList<Object>();

	    double h = 30;
	    double l = 80;

	    mgraph.getModel().beginUpdate();
	    try {
	      for(int i =1;i<=graph.getNumberOfNodes();i++){
	    	  Node n = graph.getNode(i);
	    	  if(pa.vertexPart(i)){
	    		  vertices.add(mgraph.insertVertex(parent, null, n.getName(), coord[i-1][0] - l/2, coord[i-1][1] - h/2, l, h, mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_HEXAGON +";fillColor=#B3F06D"));
	    	  }else{
	    		  vertices.add(mgraph.insertVertex(parent, null, n.getName(), coord[i-1][0] - l/2, coord[i-1][1] - h/2, l, h, mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_HEXAGON));
	    	  }
	      }
	      for(int i =1;i<=graph.getNumberOfEdges();i++){
	    	Edge e = graph.getEdge(i);
	    	if(pa.edgePart(i)){
	    		mgraph.insertEdge(parent, null, e.getType().getAlias(), vertices.get(e.getStart()-1), vertices.get(e.getArrival()-1),mxConstants.STYLE_STROKECOLOR+"="+ "#B3F06D");
	    	}else{
	    		mgraph.insertEdge(parent, null, e.getType().getAlias(), vertices.get(e.getStart()-1), vertices.get(e.getArrival()-1));
	    	}
	      }
	      
	    } finally {
	      mgraph.getModel().endUpdate();
	    }
	    
		return mgraph;
	}


}
