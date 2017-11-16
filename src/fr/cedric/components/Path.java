package fr.cedric.components;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Path {
	
	private double weight;
	private int[] path,edges;
	private Graph g;
	public Path(Graph g,int[] p, int[] e,double w){
		this.path = p;
		this.weight = w;
		this.edges = e;
		this.g = g;
	}
	public double getWeight() {
		return weight;
	}

	public int[] getPath() {
		return path;
	}
	public int[] getEdges() {
		return edges;
	}
	public String getText(){
		String text = "";
		NumberFormat formatter = new DecimalFormat("#0.00");
		
		text += "<html>Duration : " + formatter.format(weight) + " minutes<br> <br>";
		for(int i = 1;i<path.length;i++){
			text += "-> " + g.getNode(path[i]).getName() + " by " + g.getEdge(edges[i]).getType().getName() +  "<br>";
		}
		
		text += "</html>";
		
		return text;
	}
	public boolean vertexPart(int id){
		boolean test = false;
		int i = 0;
		while((!test)&&i<path.length){
			if(path[i] == id){
				test = true;
			}
			i++;
		}
		return test;
	}
	public boolean edgePart(int id){
		boolean test = false;
		int i = 0;
		while((!test)&&i<edges.length){
			if(edges[i] == id){
				test = true;
			}
			i++;
		}
		return test;
	}
	
	
	

}
