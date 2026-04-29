package datastr;

public class MyVerticeNode<Ttype> {
	private Ttype element;
	private MyEdgeNode firstEdgeNode = null;

	public Ttype getElement() {
		return element;
	}

	public MyEdgeNode getFirstEdgeNode() {
		return firstEdgeNode;
	}

	public void setElement(Ttype element) {
		if (element != null) {
			this.element = element;
		} else {
			this.element = (Ttype) new Object();
		}
	}

	public void setFirstEdgeNode(MyEdgeNode firstEdgeNode) {
		this.firstEdgeNode = firstEdgeNode;
	}

	public MyVerticeNode(Ttype element) {
		setElement(element);
	}

	public String toString() {
		String result = element + " ";

		MyEdgeNode currentEdgeNode = firstEdgeNode;
		while (currentEdgeNode != null) {
			result += ">" + currentEdgeNode.getIndexOfVerticeTo() + " " + currentEdgeNode.getWeight() + " ";
			currentEdgeNode = currentEdgeNode.getNextEdgeNode();
		}
		return result;
	}
}
