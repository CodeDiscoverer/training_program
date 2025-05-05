package OnlineExamPortal.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import OnlineExamPortal.model.Question;


public class ExamEngineController implements ExamEngine{
	
	Map<Integer, Question> question = new HashMap<>();
	Scanner read = new Scanner(System.in);
	int score = 0;
	int skip = 0;
	int warning = 0;
	
	@Override
	public void loadQuestion() {
		
		{
			question.put(1, new Question());
			question.get(1).setQuestion("Select R");
			{
				ArrayList <String> options = new ArrayList<>();
				options.add("a. A");
				options.add("b. Z");
				options.add("c. E");
				options.add("d. R");
				question.get(1).setOptions(options);
			}
			question.get(1).setCorrectAnswer("d");
		}
		
		{
			question.put(2, new Question());
			question.get(2).setQuestion("Select Q");
			{
				ArrayList <String> options = new ArrayList<>();
				options.add("a. H");
				options.add("b. S");
				options.add("c. Q");
				options.add("d. R");
				question.get(2).setOptions(options);
			}
			question.get(2).setCorrectAnswer("c");
		}
		
		{
			question.put(3, new Question());
			question.get(3).setQuestion("Select X");
			{
				ArrayList <String> options = new ArrayList<>();
				options.add("a. X");
				options.add("b. Y");
				options.add("c. Z");
				options.add("d. U");
				question.get(3).setOptions(options);
			}
			
			question.get(3).setCorrectAnswer("a");
		}
		
		{
			question.put(4, new Question());
			question.get(4).setQuestion("Select Q");
			
			{
				ArrayList <String> options = new ArrayList<>();
				options.add("a. W");
				options.add("b. J");
				options.add("c. Q");
				options.add("d. I");
				question.get(4).setOptions(options);
			}
			question.get(4).setCorrectAnswer("c");
		}
		
		{
			question.put(5, new Question());
			question.get(5).setQuestion("Select B");
			
			{
				ArrayList <String> options = new ArrayList<>();
				options.add("a. H");
				options.add("b. S");
				options.add("c. Q");
				options.add("d. B");
				question.get(5).setOptions(options);	
			}
			question.get(5).setCorrectAnswer("d");
		}
		
		System.err.println("All the Questions are loaded All the Best!");
		
	}
	
	@Override
	public void assesmentStart() {
		loadQuestion();
		
		
		String answer;

		try {
			for(int i = 1; i <= 5; i++) {
				
				if(warning <= 3 || skip <= 3) {
					System.out.printf("\n------- Question %d -------\n", i);
					System.out.println("Q" + i + ". " + question.get(i).getQuestion());
					System.out.println(question.get(i).getOptions());
					System.out.println("Press 's' to Skip the Question");
					System.out.print("Enter your Choice: ");
					answer = read.nextLine();
					
					String correctAns = question.get(i).getCorrectAnswer();
					char correctAnswer = correctAns.charAt(0);
					char ans = answer.charAt(0);
					
					if(ans == 's') {
						skip++;
						System.out.println("You have Skipped the question " + i);
						System.out.println("Your Skip Count: " + skip);
						if(skip == 4) {
							evaluate();
							throw new SkipWarningException("You had skipped more than 3 times.");
						}
					}
					else if(correctAnswer == ans) {
						score++;
					}else if(ans >= 'a' && ans <= 'd'){
						continue;
					}
					else {
						warning++;
						System.out.println("Warning! Junk Input Detected at question " + i);
						System.out.println("Your Warning Count: " + warning);
						if(warning == 3) {
							evaluate();
							throw new JunkInputException("Warning! Junk Input Detectedmore than 3 times.");
						}
						System.err.println("Invalid Option!");
						i--;
					}
				}
				else {
					System.out.println("Skip or Warning Limit Exceed");
					break;
				}
			}
			
			evaluate();
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		
//		if(skip != 0) {
//			System.out.printf("Skipped Questions: %i/5\n", skip);
//		}
//		
//		System.out.printf("Score: %i/5\n", score);
	}

	@Override
	public void evaluate() {
		
		System.out.println("\nYour Score is: " +  score + "\nYou have Skipped " + warning + " Question\n");
		
	}

}
