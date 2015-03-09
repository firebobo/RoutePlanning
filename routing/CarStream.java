package routing;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class CarStream {
	protected Map<Road, Integer> streamMap=null;
	public CarStream(Network net) {
		Enumeration<?>  en=net.edges.hashTable.keys();
		while(en.hasMoreElements()){
			Edge edge=(Edge) en.nextElement();
			streamMap=new HashMap<Road,Integer>();
			Road road1=new Road(edge.getNode1().getID(), edge.getNode2().getID());
			Road road2=new Road(edge.getNode2().getID(), edge.getNode1().getID());
			streamMap.put(road1, 0);
			streamMap.put(road2, 0);
		}
	}
	public void moveIn(Road road) {
		streamMap.put(road,streamMap.get(road)+1);
	}
	public void moveOut(Road road) {
		streamMap.put(road,streamMap.get(road)-1);
	}
}
