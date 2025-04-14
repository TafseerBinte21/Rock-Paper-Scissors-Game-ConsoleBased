package com.example.demo;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringRockAndScissorConsoleAppApplication implements CommandLineRunner  {
	
//	@Autowired
//	Score score;
	
	@Autowired
	ScoreRepository scoreRepo;

	public static void main(String[] args) {
		SpringApplication.run(MySpringRockAndScissorConsoleAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		String result = "";
		
		String gesture = "";
		
		Scanner scanner = new Scanner(System.in);
		
		Score score = scoreRepo.findById(Long.valueOf(1)).get();
		
		do {
			System.out.println("Rock, Paper or Scissors ? ");
			gesture = scanner.next();
			
			if (gesture.equalsIgnoreCase("quit")) {
				break;
			}
			if (gesture.equalsIgnoreCase("Rock")) {
				result = "tie";
				score.ties++;
				scoreRepo.save(score);

			}
			if (gesture.equalsIgnoreCase("Paper")) {
				result = "win";
				score.wins++;
				scoreRepo.save(score);

			}
			if (gesture.equalsIgnoreCase("Scissors")) {
				result = "loss";
				score.losses++;
				scoreRepo.save(score);

			}
			
			System.out.println("You picked "+ gesture);	
			System.out.println("Result is "+ result);	
			System.out.println(score);

		} while(true);
		
	
		scanner.close();
		
	}

}
