package io.javabrains.tinder_ai_backend;

import io.javabrains.tinder_ai_backend.convestaions.ChatMessage;
import io.javabrains.tinder_ai_backend.convestaions.Conversation;
import io.javabrains.tinder_ai_backend.convestaions.ConversationRepository;
import io.javabrains.tinder_ai_backend.profiles.Gender;
import io.javabrains.tinder_ai_backend.profiles.Profile;
import io.javabrains.tinder_ai_backend.profiles.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TinderAiBackendApplication implements CommandLineRunner {

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private ConversationRepository conversationRepository;

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

		Conversation conversation = new Conversation("101",profile.id(),
				List.of( new ChatMessage("hi","1001", LocalDateTime.now()),
						new ChatMessage("hello","1001", LocalDateTime.now())));
		conversationRepository.save(conversation);
		conversationRepository.findAll().forEach(System.out::println);
	}

}
