package it.polito.tdp.borders.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.event.ConnectedComponentTraversalEvent;
import org.jgrapht.event.EdgeTraversalEvent;
import org.jgrapht.event.TraversalListener;
import org.jgrapht.event.VertexTraversalEvent;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;

import it.polito.tdp.borders.db.BordersDAO;

public class Model {
	
	private Graph<Country, DefaultEdge> grafo;
	private List<Country> paesi;
	private List<Border> confini;
	private Map<Integer, Country> cIdMap;

	public Model() {
		
		BordersDAO dao = new BordersDAO();
		this.cIdMap = new HashMap<>();
		this.paesi = dao.loadAllCountries(cIdMap);
		this.grafo = new SimpleGraph<>(DefaultEdge.class);
	
	}
	
	public void creaGrafo(int anno) {
		
		BordersDAO dao = new BordersDAO();
		this.confini = dao.getCountryPairs(anno);
		Graphs.addAllVertices(this.grafo, paesi);//Aggiunta tutti i Paesi come vertici
		
		for(Border border : confini) {//Aggiunta degli archi nel periodo di tempo considerato
			Graphs.addEdgeWithVertices(grafo, cIdMap.get(border.getStatoUnoCodice()), cIdMap.get(border.getStatoDueCodice()));			
		}
		
		/*System.out.println("Grafo creato!");
		System.out.println("Vertici: "+grafo.vertexSet().size());
		System.out.println("Archi: "+grafo.edgeSet().size());
		System.out.println(grafo);*/
		
	}
	
	public int numeroComponentiConnesse() {
		ConnectivityInspector<Country, DefaultEdge> ispettore = new ConnectivityInspector<>(grafo);
		return ispettore.connectedSets().size();
	}
	
	public List<Country> getConfinanti(Country country){		
		 return Graphs.neighborListOf(this.grafo, country);
	}

	public Graph<Country, DefaultEdge> getGrafo() {
		return grafo;
	}

	public List<Country> getPaesi() {
		return paesi;
	}
	
	/**
	 * Ritorno la lista di vertici (paesi) connessi mediante la libreria JGrapht
	 * @param paese
	 * @return list di Country connessi
	 */
	
	public List<Country> trovaVicini(Country paese){
		
		List<Country> vicini = new ArrayList<>();
		BreadthFirstIterator<Country, DefaultEdge> it = new BreadthFirstIterator<>(grafo, paese);
		
		while(it.hasNext()) {
			vicini.add(it.next());
		}
		Collections.sort(vicini);
		return vicini;
		
	}
	
	

}
