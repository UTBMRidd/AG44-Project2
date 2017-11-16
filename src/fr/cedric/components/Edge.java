package fr.cedric.components;

public class Edge {
	
	private int edgeID;
	private String name;
	private RouteType type;
	private int start;
	private int arrival;
	
	public Edge(int id,String name,RouteType type,int start,int arrival){
		this.setEdgeID(id);
		this.setName(name);
		this.setType(type);
		this.setStart(start);
		this.setArrival(arrival);
	}

	public int getEdgeID() {
		return edgeID;
	}

	public void setEdgeID(int edgeID) {
		this.edgeID = edgeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RouteType getType() {
		return type;
	}

	public void setType(RouteType type) {
		this.type = type;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getArrival() {
		return arrival;
	}

	public void setArrival(int arrival) {
		this.arrival = arrival;
	}
	
}
