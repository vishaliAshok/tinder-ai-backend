package io.javabrains.tinder_ai_backend;

import io.javabrains.tinder_ai_backend.profiles.Gender;
import io.javabrains.tinder_ai_backend.profiles.Profile;
import io.javabrains.tinder_ai_backend.profiles.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TinderAiBackendApplication implements CommandLineRunner {

	@Autowired
	private ProfileRepository profileRepository;

	public static void main(String[] args) {
		SpringApplication.run(TinderAiBackendApplication.class, args);
	}

	public void run(String... args){
		System.out.println("My app is running vishali");
		Profile profile = new Profile(
				"1",
				"vishali",
				"ashok",
				27,
				"Indian",
				Gender.FEMALE,
				"Software Developer",
				"foo.jpg",
				"INTP"
		);
		profileRepository.save(profile);
		profileRepository.findAll().forEach(System.out::println);
	}

}
