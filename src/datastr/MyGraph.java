package datastr;

public class MyGraph<Ttype>{
	private MyVerticeNode<Ttype>[] vertices;
	private final int DEFAULT_SIZE = 5;
	private int size = DEFAULT_SIZE;
	private int howManyElements = 0;
	
	public int getHowManyElements()
	{
		return howManyElements;
	}
	
	public MyGraph() {
		vertices = new MyVerticeNode[size];
	}
	
	public MyGraph(int inputSize) {
		if(inputSize > 0 && inputSize < 1000) {
			size = inputSize;
		}
		
		vertices = new MyVerticeNode[size];
	}
	
	
	public boolean isEmpty() {
		return (howManyElements == 0);
	}
	
	public boolean isFull() {
		return (howManyElements == size);
	}
	
	private void resize() {
		int newSize = (size <= 100) ? (size * 2) : ((int)(size*1.5));
		
		MyVerticeNode<Ttype>[] newVertices = new MyVerticeNode[newSize];
		
		for(int i = 0; i < howManyElements; i++) {
			newVertices[i] = vertices[i];
		}
		size = newSize;
		vertices = newVertices;
		System.gc();
		
	}
	
	
	public void addVertice(Ttype element) throws Exception{
		if(element == null) {
			throw new Exception("Elements nevar būt bez references");
		}
		
		for(int i = 0; i < howManyElements; i++) {
			if(vertices[i].getElement().equals(element)) {
				throw new Exception("Tad elements jau eksistē grafā. To nevar pievienot atkārtoti");
			}
		}
		
		if(isFull())
		{
			resize();
		}
		
		MyVerticeNode newVerticeNode =  new MyVerticeNode(element);
		vertices[howManyElements] = newVerticeNode;
		howManyElements++;
		
	}
	
	
	public void addEdge(Ttype elementFrom, Ttype elementTo, int weight) 
			throws Exception
	{
		if(elementFrom == null || elementTo == null || weight <= 0)
		{
			throw new Exception("Kāds no ievades parametriem nav atbilstošs");
		}
		
		int indexOfElementFrom = findVertice(elementFrom);		
		int indexOfElementTo = findVertice(elementTo);

		MyEdgeNode newEdge = new MyEdgeNode(indexOfElementTo, weight);
		
		MyVerticeNode verticeNodeFrom = vertices[indexOfElementFrom];
		//noskaidrojam, vai edgeNOde būs kā pirmais
		if(verticeNodeFrom.getFirstEdgeNode() == null) {
			verticeNodeFrom.setFirstEdgeNode(newEdge);
		}
		//vai tas ir kārtejais edgeNode objekts, aks pielipinats saistītajā pierakstā
		else
		{
			MyEdgeNode currentNode = verticeNodeFrom.getFirstEdgeNode();
			//TODO ja vēlas, tad var optimizet un vinemēr likt kā pirmo, pie kura pielpina iepriekšējo pirmo
			while(currentNode.getNextEdgeNode() != null) {
				currentNode = currentNode.getNextEdgeNode();
			}
			
			currentNode.setNextEdgeNode(newEdge);
			
		}
		
	}
	
	
	private int findVertice(Ttype element) throws Exception{
		if(element == null) {
			throw new Exception("Elements nevar būt bez references");
		}
		
		for(int i = 0; i < howManyElements; i++) {
			if(vertices[i].getElement().equals(element)) {
				return i;//i -> atrastas pilsetas indekss masīvā
			}
		}
		
		throw new Exception("Meklētā virsotne nav atrasta");
		
	}
	
	public void print() throws Exception{
		if(isEmpty()) {
			throw new Exception("Grafs ir tukšs un to nevar izprintēt");
		}
		
		for(int i = 0; i < howManyElements; i++) {
			System.out.println(vertices[i].toString());//toString no MyVerticeNode
		}
	}

}