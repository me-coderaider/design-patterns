package rtg.learning.designpatterns.creational.builder;

class Person{
	public String name;
	
	public String position;

	@Override
	public String toString() {
		return "Person [name=" + name + ", position=" + position + "]";
	}
}


class PersonBuilder<SELF extends PersonBuilder<SELF>>{
	protected Person person=new Person();
	
	public SELF withName(String name) {
		person.name=name;
//		return (SELF) this;
		return self();
	}
	
	public Person build() {
		return person;
	}
	
	protected SELF self() {
		return (SELF)this;
	}
}
class EmployeeBuilder extends PersonBuilder<EmployeeBuilder>{
	
	public EmployeeBuilder worksAt(String position) {
		person.position=position;
//		return this;
		return self();
	}

	@Override
	protected EmployeeBuilder self() {
		return this;
	}
}

public class FluentBuilderInheritanceWithRecursiveGenerics {

	public static void main(String[] args) {
		EmployeeBuilder pb = new EmployeeBuilder();
		Person pankaj=pb
				.withName("Pankaj")
				.worksAt("SDE-I")
				.build();
		
		System.out.println(pankaj);
	}

}
