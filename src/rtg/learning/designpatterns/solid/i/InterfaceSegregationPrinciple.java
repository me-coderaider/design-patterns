package rtg.learning.designpatterns.solid.i;

class Document{
	
}

interface Machine{
	void print(Document d);
	void fax(Document d) throws Exception;
	void scan(Document d);
}

interface Printer{
	void print(Document d);
}

interface Scanner{
	void scan(Document d);
}

interface Fax{
	void fax(Document d);
}

class JustAPrinter implements Printer{

	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub
		
	}
}

class Photocopier implements Printer, Scanner{

	@Override
	public void scan(Document d) {
		
	}

	@Override
	public void print(Document d) {
		
	}
	
}

interface MultiFunctionDevice extends Printer, Scanner{ }

class MultiFunctionMachine implements MultiFunctionDevice{

	private Printer printer;
	private Scanner scanner;
	
	public MultiFunctionMachine(Printer printer, Scanner scanner) {
		super();
		this.printer = printer;
		this.scanner = scanner;
	}

	@Override
	public void print(Document d) {
		printer.print(d);
	}

	@Override
	public void scan(Document d) {
		scanner.scan(d);
	}
	
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