package rtg.learning.designpatterns.solid.d;

import java.util.ArrayList;
import java.util.List;

//e.g family tree kind of application
enum Relationship {
	PARENT, CHILD, SIBLING
}

class Person {
	private String name;

	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

}

class Triplet {
	private Person person1;
	private Relationship relationship;
	private Person person2;

	public Triplet(Person person1, Relationship relationship, Person person2) {
		super();
		this.person1 = person1;
		this.relationship = relationship;
		this.person2 = person2;
	}

	public Person getPerson1() {
		return person1;
	}

	public Relationship getRelationship() {
		return relationship;
	}

	public Person getPerson2() {
		return person2;
	}

	@Override
	public String toString() {
		return "Triplet [person1=" + person1 + ", relationship=" + relationship + ", person2=" + person2 + "]";
	}
}

class Relationships { // low level module
	private List<Triplet> relations = new ArrayList<>();

	public List<Triplet> getRelations() {
		return relations;
	}

	public void addParentAndChild(Person parent, Person child) {
		relations.add(new Triplet(parent, Relationship.PARENT, child));
		relations.add(new Triplet(child, Relationship.CHILD, parent));
	}
}

class Research { // high-level module
	public Research(Relationships relationships) {
		List<Triplet> relations = relationships.getRelations();

		relations.stream().filter(x -> x.getPerson1().getName().equals("John") && x.getRelationship() == Relationship.PARENT)
			.forEach(ch -> System.out.println("John has a child called "+ch.getPerson2().getName()));
	}
}

public class DependencyInversionPrinciple {

	public static void main(String[] args) {
		Person parent = new Person("John");
		Person child1 = new Person("Chris");
		Person child2 = new Person("Matt");

		Relationships relationships = new Relationships();
		relationships.addParentAndChild(parent, child1);
		relationships.addParentAndChild(parent, child2);

	new Research(relationships);
	}

}
