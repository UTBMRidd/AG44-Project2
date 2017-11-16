package fr.cedric.loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import fr.cedric.components.Edge;
import fr.cedric.components.Graph;
import fr.cedric.components.RouteType;

public class fileLoader {
	
	public static Graph loadGraphFromFile(String fileName){
		
		BufferedReader br = null;
		FileReader fr = null;
		Graph g = new Graph();
		int nodeNb, edgeNb;
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			String sCurrentLine = br.readLine();
			nodeNb = Integer.parseInt(sCurrentLine);
			createNode(g,br,nodeNb);
			sCurrentLine = br.readLine();
			edgeNb = Integer.parseInt(sCurrentLine);
			createEdge(g,br,edgeNb);

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

		return g;
		
	}
	private static void createNode(Graph g, BufferedReader br, int nbNodes){
		for(int i=0;i<nbNodes;i++){
			String sCurrentLine = "";
			try {
				sCurrentLine = br.readLine();
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			String [] tokens = sCurrentLine.split("\t");
			g.addNode(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]));
		}
		
	}
	private static void createEdge(Graph g, BufferedReader br, int nbEdges){
		for(int i=0;i<nbEdges;i++){
			String sCurrentLine = "";
			try {
				sCurrentLine = br.readLine();
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			String [] tokens = sCurrentLine.split("\t");
			g.addEdge(Integer.parseInt(tokens[0]), tokens[1],getType(tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
		}
		
	}
	private static RouteType getType(String name){
		RouteType rt;
		switch(name){
		case "TK" :
			rt = RouteType.TK;
			break;
		case "TS" :
			rt = RouteType.TS;
			break;
		case "TSD" :
			rt = RouteType.TSD;
			break;
		case "TC" :
			rt = RouteType.TC;
			break;
		case "TPH" :
			rt = RouteType.TPH;
			break;
		case "BUS1" :
			rt = RouteType.BUS1;
			break;
		case "BUS2" :
			rt = RouteType.BUS2;
			break;
		case "V" :
			rt = RouteType.V;
			break;
		case "B" :
			rt = RouteType.B;
			break;
		case "R" :
			rt = RouteType.R;
			break;
		case "N" :
			rt = RouteType.N;
			break;
		case "KL" :
			rt = RouteType.KL;
			break;
		case "SURF" :
			rt = RouteType.SURF;
			break;
		default:
			throw new IllegalArgumentException("Invalid type :  " + name);
		
		}
		return rt;
	}
	
	
	

}
