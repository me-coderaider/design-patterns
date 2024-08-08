package rtg.learning.designpatterns.solid.s;

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
}

public class SingleResponsibilityPrinciple {
	public static void main(String[] args) {
		Journal j=new Journal();
		j.addEntry("Learn Design Pattern");
		j.addEntry("Learning Single Responsibility Principle");
		System.out.println(j);
	}
}
