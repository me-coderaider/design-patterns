package rtg.learning.designpatterns.solid.i;

class Document{
	
}

interface Machine{
	void print(Document d);
	void fax(Document d) throws Exception;
	void scan(Document d);
}

class MultiFunctionPrinter implements Machine{

	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub
	}

	@Override
	public void fax(Document d) {
		// TODO Auto-generated method stub
	}

	@Override
	public void scan(Document d) {
		// TODO Auto-generated method stub
	}
	
}

class OldFashionedPrinter implements Machine{

	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub
	}

	@Override
	public void fax(Document d) throws Exception {
		throw new Exception();
	}

	@Override
	public void scan(Document d) {
		// TODO Auto-generated method stub
	}
}



public class InterfaceSegregationPrinciple {

	public static void main(String[] args) {

	}

}