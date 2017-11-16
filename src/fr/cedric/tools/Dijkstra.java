package fr.cedric.tools;

import java.util.ArrayList;
import java.util.Stack;

import fr.cedric.components.Edge;
import fr.cedric.components.Graph;
import fr.cedric.components.Node;
import fr.cedric.components.Path;
import fr.cedric.components.RouteType;

public class Dijkstra {
	public static Path shortestPath(Graph g, int start, int end){
		int length = g.getNumberOfNodes(); 
		int inf = 100000;
		ArrayList<Integer> list = new ArrayList<Integer>();
		float[] weight = new float[length + 1];
		int[] pred = new int[length + 1];
		int[] edges = new int[length + 1];
		for(int i=1;i<=length;i++){
			weight[i] = inf;
			pred[i] = -1;
			list.add(i);
		}
		weight[start] = 0;
		pred[start] = -1;
		while(!list.isEmpty()){
			int index = getMin(list, weight);
			Node n = g.getNode(index);
			list.remove(new Integer(index));
			for(Edge s : n.getSuccessors() ){
				int next = s.getArrival();
				float nW = weight[index] + cost(g,s);
				if(weight[next] > nW){
					weight[next] = nW;
					pred[next] = index;
					edges[next] = s.getEdgeID();
				}
			}
		}
		
		
		Stack<Integer> st = new Stack<Integer>();
		Stack<Integer> stEdg = new Stack<Integer>();
		int i = end;
		double w = weight[i];
		st.add(i);
		stEdg.add(edges[i]);
		
		while(pred[i] != -1){
			i = pred[i];
			st.add(i);
			stEdg.add(edges[i]);
		}
		i=0;
		int[] pa = new int[st.size()];
		int[] edg = new int[stEdg.size()];
	    while(!st.isEmpty())
	    {
	        pa[i] = st.pop();
	        i++;
	    }
	    i=0;
	    while(!stEdg.isEmpty())
	    {
	        edg[i] = stEdg.pop();
	        i++;
	    }
	    
		return new Path(g,pa,edg,w);
		
	}
	private static int getMin(ArrayList<Integer> list, float[] weight){
		int min = list.get(0);
		for(int i=1;i<list.size();i++){
			if(weight[min]>weight[list.get(i)]){
				min = list.get(i);
			}
		}
		return min;
	}
	private static float cost(Graph g,Edge e){
		
		float distance = ((float) Math.abs(g.getNode(e.getStart()).getAltitude()-g.getNode(e.getArrival()).getAltitude()))/100;
		RouteType rt = e.getType();
		return rt.getFixedT() + distance * rt.getdT();
	}
}
