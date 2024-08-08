package rtg.learning.designpatterns.solid.s;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class Journal{
	private final List<String> entries=new ArrayList<>();
	private static int count=0;
	
	public void addEntry(String text) {
		entries.add(""+ (++count)+": "+text);
	}
	
	public void removeEntry(int index) {
		entries.remove(index);
	}

	@Override
	public String toString() {
		return String.join(System.lineSeparator(), entries);
	}
	
	public void save(String filename) throws FileNotFoundException{
		try(PrintStream out=new PrintStream(filename)){
			out.println(toString());
		}
	}
	public void load(String filename) {	}
	public void load(URL url) {}
}

public class SingleResponsibilityPrinciple {
	public static void main(String[] args) throws Exception {
		Journal j=new Journal();
		j.addEntry("Learn Design Pattern");
		j.addEntry("Learning Single Responsibility Principle");
		System.out.println(j);
	}
}
