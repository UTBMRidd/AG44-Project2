package fr.cedric.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;

public class Graph {
	private HashMap<Integer,Node> nodes = new HashMap <Integer,Node>();
	private HashMap<Integer,Edge> edges = new HashMap <Integer,Edge>();
	
	
	private int nodeNb;
	private int edgeNb;
	
	public void addNode(int id, String name, int altitude){
		nodes.put(id, new Node(id, name,altitude));
		this.setNumberOfNodes(this.getNumberOfNodes() + 1);
	}
	public void addNode(Node n){
		nodes.put(n.getNodeID(), n);
		this.setNumberOfNodes(this.getNumberOfNodes() + 1);
	}
	public void addEdge(int id,String name,RouteType type,int start,int arrival){
		Edge k = new Edge(id, name,type,start,arrival);
		edges.put(id, k);
		nodes.get(start).addSuccessors(k);
		this.setNumberOfEdges(this.getNumberOfEdges() + 1);
	}
	public Node getNode(int index){
		return nodes.get(index);
	}
	public Edge getEdge(int index){
		return edges.get(index);
	}
	public void printNodes(){
		for(Map.Entry<Integer,Node> entry : nodes.entrySet()) {
		    int key = entry.getKey();
		    Node value = entry.getValue();
		    System.out.print("Node : " + key  + " / Nom : " + value.getName() + " / Altitude : " + value.getAltitude() + " / Successors : ");
		    for(Edge i : value.getSuccessors()){
		    	System.out.print(i.getArrival() + " ");
		    }
		    System.out.println("");
		}
	}
	public void printEdges(){
		for(Map.Entry<Integer,Edge> entry : edges.entrySet()) {
		    int key = entry.getKey();
		    Edge value = entry.getValue();
		    System.out.println("Edge : " + key  + " / Nom : " + value.getName() + " / Type : " + value.getType().getName() + " / Start : " + value.getStart() + " / Arrival : " + value.getArrival());
		}
	}
	public Graph redefineGraph(ArrayList<RouteType> denied){
		Graph g = new Graph();
		int i=1;
		boolean isDenied = false;
		for(Map.Entry<Integer,Node> entry : nodes.entrySet()) {
		    int key = entry.getKey();
		    Node value = entry.getValue();  
			g.addNode(i,value.getName(),value.getAltitude());
			i++;
		}
		i=1;
		for(Map.Entry<Integer,Edge> entry : edges.entrySet()) {
		    int key = entry.getKey();
		    Edge value = entry.getValue();
		    for(RouteType rt : denied){
		    	if(rt.compareTo(value.getType())==0){
		    		isDenied = true;
		    	}
		    }
		    if(!isDenied){
		    	g.addEdge(i,value.getName(),value.getType(),value.getStart(),value.getArrival());
		    	i++;
		    }else{
		    	isDenied = false;
		    }

		}
		return g;
	}
	
	
	
	
	//GETTER/SETTER
	
	public int getNumberOfNodes() {
		return nodeNb;
	}
	public void setNumberOfNodes(int nodeNb) {
		this.nodeNb = nodeNb;
	}
	public int getNumberOfEdges() {
		return edgeNb;
	}
	public void setNumberOfEdges(int edgeNb) {
		this.edgeNb = edgeNb;
	}
}
