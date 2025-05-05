package UserAddress;


public class Main {

	public static void main(String[] args) {
		
		User user = new User();
		User.Address address = user.new Address();
		
		address.getAddressValidation();
	}

}
