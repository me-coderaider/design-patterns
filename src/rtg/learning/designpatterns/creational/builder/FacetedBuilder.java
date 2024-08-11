package rtg.learning.designpatterns.creational.builder;

class PersonFaceted{
	// address info
	public String streetAddress, postCode, city;
	
	// employment info
	public String companyName, position;
	public int annualIncome;
	@Override
	public String toString() {
		return "PersonFaceted [streetAddress=" + streetAddress + ", postcode=" + postCode + ", city=" + city + ", companyName="
				+ companyName + ", position=" + position + ", annualIncome=" + annualIncome + "]";
	}
}
// builder facade
class PersonFacetedBuilderFaceted {
	protected PersonFaceted PersonFaceted=new PersonFaceted();
	
	public PersonFacetedAddressBuilder lives() {
		return new PersonFacetedAddressBuilder(PersonFaceted);
	}
	
	public PersonFacetedJobBuilder works() {
		return new PersonFacetedJobBuilder(PersonFaceted);
	}
	
	public PersonFaceted build() {
		return PersonFaceted;
	}
}

class PersonFacetedAddressBuilder extends PersonFacetedBuilderFaceted{
	
	public PersonFacetedAddressBuilder(PersonFaceted PersonFaceted) {
		this.PersonFaceted=PersonFaceted;
	}
	
	public PersonFacetedAddressBuilder at(String streetAddress) {
		PersonFaceted.streetAddress=streetAddress;
		return this;
	}
	public PersonFacetedAddressBuilder withPostCode(String postCode) {
		PersonFaceted.postCode=postCode;
		return this;
	}
	public PersonFacetedAddressBuilder in(String city) {
		PersonFaceted.city=city;
		return this;
	}
}

class PersonFacetedJobBuilder extends PersonFacetedBuilderFaceted{
	public PersonFacetedJobBuilder(PersonFaceted PersonFaceted) {
		this.PersonFaceted=PersonFaceted;
	}
	
	public PersonFacetedJobBuilder at(String companyName) {
		PersonFaceted.companyName=companyName;
		return this;
	}
	public PersonFacetedJobBuilder asA(String position) {
		PersonFaceted.position=position;
		return this;
	}
	public PersonFacetedJobBuilder earning(int annualIncome) {
		PersonFaceted.annualIncome=annualIncome;
		return this;
	}
}

public class FacetedBuilder {

	public static void main(String[] args) {
		PersonFacetedBuilderFaceted pb =new PersonFacetedBuilderFaceted();
		PersonFaceted PersonFaceted=pb
				.lives()
					.at("GT Road NH007")
					.in("KGF")
					.withPostCode("345263")
				.works()
					.at("Product Based")
					.asA("Full Stack Engineer")
					.earning(119000)
				.build();
		System.out.println(PersonFaceted);
	}

}
