package Utils;

import net.datafaker.Faker;

public class FakerDemo {

	public static void main(String[] args) {
		Faker faker = new Faker();

        System.out.println("Name: " + faker.name().fullName());
        System.out.println("Email: " + faker.internet().emailAddress());
        System.out.println("City: " + faker.address().city());
        System.out.println("Phone: " + faker.phoneNumber().cellPhone());
	}
}
