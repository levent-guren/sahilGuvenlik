package tr.gov.sg.springdemo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import tr.gov.sg.springdemo.repository.PersonelRepository;

@Component
public class Test implements CommandLineRunner {
	@Autowired
	private PersonelRepository personelRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Merhaba");
		personelRepository.findByBaskanlikId(1).forEach(System.out::println);
	}

}
