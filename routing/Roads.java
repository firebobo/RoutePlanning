package routing;

import java.util.*;



public class Roads {
	/**
	 * Container
	 */
	protected Map<Road, RoadValue> roadsMap=null;
	private Network net;
	private CarStream cStream;

	public Roads(Network net) {
		this.net=net;
		cStream = new CarStream(net);
	}
	public void compute() {
		Enumeration<?>  en=net.edges.hashTable.keys();
		while(en.hasMoreElements()){
			Edge edge=(Edge) en.nextElement();
			roadsMap=new HashMap<Road,RoadValue>();
			Road road1=new Road(edge.getNode1().getID(), edge.getNode2().getID());
			Road road2=new Road(edge.getNode2().getID(), edge.getNode1().getID());
			roadsMap.put(road1, new RoadValue(edge.getLength(), 0));
			roadsMap.put(road2, new RoadValue(edge.getLength(), 0));
		}
		Nodes nodes=net.getNodes();
		Enumeration<?>  en1=nodes.hashTable.keys();
		Enumeration<?>  en2=nodes.hashTable.keys();
		Enumeration<?>  en3=nodes.hashTable.keys();
		while(en3.hasMoreElements()){
			Node node3=(Node) en3.nextElement();
			while(en1.hasMoreElements()){
				Node node1=(Node) en1.nextElement();
				while(en2.hasMoreElements()){
					Node node2=(Node) en2.nextElement();
					RoadValue value=roadsMap.get(new Road(node1.getID(),node2.getId()));
					RoadValue value1=roadsMap.get(new Road(node1.getID(),node3.getId()));
					RoadValue value2=roadsMap.get(new Road(node2.getID(),node3.getId()));

					if(value1!=null&&value2!=null&&value.getLength()>value1.getLength()+value2.getLength()){

						roadsMap.put(new Road(node1.getID(), node2.getID()), new RoadValue(value1.getLength()+value2.getLength(), node3.getID()));
					}

				}
			}		

		}
	}
	public PathEdge computePath(Node start,Node end) {
		RoadValue roadValue=roadsMap.get(new Road(start.getID(), end.getID()));
		if(roadValue==null){
			return null;
		}
		if(roadValue.getNid3()==0){
			return new PathEdge(start.getBetweenEdge(end), true);
		}else{
			PathEdge path=computePath(start, net.nodes.get(roadValue.getNid3()));
			path.next=computePath(net.nodes.get(roadValue.getNid3()), end);
			return path;
		}
	}
	public void moveIn(Road road) {
		cStream.moveIn(road);
	}
	public void moveOut(Road road) {
		cStream.moveOut(road);
	}
}
