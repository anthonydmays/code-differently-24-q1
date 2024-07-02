package com.codedifferently.lesson3.quizzes;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.codedifferently.instructional.quiz.AnswerChoice;
import com.codedifferently.instructional.quiz.MultipleChoiceQuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestionProvider;

@Service
public class admaysquiz implements QuizQuestionProvider {

  public String getProviderName() {
    return "admays";
  }

  public List<QuizQuestion> makeQuizQuestions() {
    return List.of(makeQuestion0(), makeQuestion1());
  }

  private QuizQuestion makeQuestion0() {
    return new MultipleChoiceQuizQuestion(
        0,
        "What does the terminal command pwd mean?",
        Map.of(
            AnswerChoice.A, "print written directory",
            AnswerChoice.B, "pull working directory",
            AnswerChoice.C, "print working directory",
            AnswerChoice.D, "post working directory"),
        AnswerChoice.UNANSWERED); // Replace `UNANSWERED` with the correct answer.
  }

  private QuizQuestion makeQuestion1() {
    return new QuizQuestion(
        1, "What does NVME stand for?", "nonvolatile memory express"); // Provide an answer.
  }

  private QuizQuestion makeQuestion2() {
    return new QuizQuestion(
        1,
        "Can you recieve graphics output from your motherboard? (Type y/n)",
        "y"); // Provide an answer.
  }
}
