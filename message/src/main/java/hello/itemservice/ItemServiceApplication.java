package hello.itemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class ItemServiceApplication {

	public static void main(String[] args) {
		System.out.println("Locale = " + Locale.getDefault());
		SpringApplication.run(ItemServiceApplication.class, args);
	}

}
