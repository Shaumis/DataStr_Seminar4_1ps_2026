package datastr;

public class MyEdgeNode {
	private int indexOfVerticeTo;
	private int weight;
	private MyEdgeNode nextEdgeNode = null;

	public int getIndexOfVerticeTo() {
		return indexOfVerticeTo;
	}

	public void setIndexOfVerticeTo(int indexOfVerticeTo) {
		if(indexOfVerticeTo >= 0) {
		this.indexOfVerticeTo = indexOfVerticeTo;
	}else {
		this.indexOfVerticeTo = 0;
	}
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		if(weight > 0) {
		this.weight = weight;
		}else {
			this.weight = 1;
		}
	}

	public MyEdgeNode getNextEdgeNode() {
		return nextEdgeNode;
	}

	public void setNextEdgeNode(MyEdgeNode nextEdgeNode) {
		this.nextEdgeNode = nextEdgeNode;
	}
	public MyEdgeNode(int indexOfVerticeTo, int weight) {
		setIndexOfVerticeTo(indexOfVerticeTo);
		setWeight(weight);
		
	}
	public String toString() {
		return "index";
	}
}
