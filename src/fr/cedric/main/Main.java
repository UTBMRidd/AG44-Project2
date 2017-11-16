package fr.cedric.main;

import java.util.ArrayList;

import fr.cedric.GUI.Frame;
import fr.cedric.components.Graph;
import fr.cedric.components.RouteType;
import fr.cedric.loader.fileLoader;

public class Main {

	public static void main(String[] args) {
		Graph g = fileLoader.loadGraphFromFile("res/dataski.txt");
		

		new Frame(g);
	}

}
