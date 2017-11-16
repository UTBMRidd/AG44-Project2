package fr.cedric.components;

import java.util.ArrayList;

public class Node {

	private int nodeID;
	private String name;
	private int altitude;
	private ArrayList<Edge> successors = new ArrayList <Edge>();
	
	public Node(int id, String name,int altitude){
		this.nodeID = id;
		this.name = name;
		this.altitude = altitude;
	}
	
	
	public ArrayList<Edge> getSuccessors(){
		
		return this.successors;
	}
	public void addSuccessors(Edge succ){
		
		this.successors.add(succ);
	}

	public int getNodeID() {
		return nodeID;
	}

	public void setNodeID(int nodeID) {
		this.nodeID = nodeID;
	}


	public int getAltitude() {
		return altitude;
	}


	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	

}
