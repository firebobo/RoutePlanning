package routing;


public class Road {
	/**
	 * The identifier.nid1<nid2
	 */
	private long nid1 = 0;
	private long nid2 = 0;
	public Road(long id1,long id2) {
		nid1=id1;
		nid2=id2;
	}
	/**
	 * The length of the road.
	 */
	public long getNid1() {
		return nid1;
	}
	public void setNid1(long nid1) {
		this.nid1 = nid1;
	}
	public long getNid2() {
		return nid2;
	}
	public void setNid2(long nid2) {
		this.nid2 = nid2;
	}

}
class RoadValue{
	private double length = 0;
	private long nid3=0;
	public RoadValue(double length, long nid3) {
		super();
		this.length = length;
		this.nid3 = nid3;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public long getNid3() {
		return nid3;
	}
	public void setNid3(long nid3) {
		this.nid3 = nid3;
	}

}