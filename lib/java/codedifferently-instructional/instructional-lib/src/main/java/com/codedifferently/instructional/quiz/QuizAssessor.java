package com.codedifferently.instructional.quiz;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class QuizAssessor {
    public static final String CORRECT_KEY = "correct";
    public static final String INCORRECT_KEY = "incorrect";

    public static void printQuizResults(QuizConfig quizConfig) throws Exception {
        List<QuizQuestion> questions = quizConfig.getQuestions("default");
        List<Path> paths = getResponseFilePaths();
        for (Path path : paths) {
          Map<Integer, String> responses = getResponsesFromPath(path);
          
          Map<String, List<Integer>> results = new HashMap<>();
          results.put(CORRECT_KEY, new ArrayList<>());
          results.put(INCORRECT_KEY, new ArrayList<>());
          Map<Integer, String> incorrectAnswersByQuestion = new HashMap<>();
          for (var entry : responses.entrySet()) {
            Integer questionNumber = entry.getKey();
            String actualAnswer = entry.getValue();

            boolean correct =quizConfig.checkAnswer("default", questionNumber, actualAnswer);
            if (correct) {
                results.get(CORRECT_KEY).add(questionNumber);
            } else {
                results.get(INCORRECT_KEY).add(questionNumber);
                incorrectAnswersByQuestion.put(questionNumber, actualAnswer);
            }
          }

          String quizTakerName = path.getFileName().toString();
          int totalQuestions = responses.size();
          int totalAnsweredCorrectly = results.get(CORRECT_KEY).size();

          String correctAnswers = String.join(", ", results.get(CORRECT_KEY).stream().sorted().map(i -> i.toString()).toList());
          String incorrectAnswers = String.join(", ", results.get(INCORRECT_KEY).stream().sorted().map(i -> i.toString() + " [" + incorrectAnswersByQuestion.get(i) + "]").toList());

          System.out.println("Total score for " + quizTakerName + ": " + totalAnsweredCorrectly + "/" + totalQuestions);
          System.out.println("Answered correctly: " + correctAnswers);
          System.out.println("Answered incorrectly: " + incorrectAnswers);
          System.out.println();
        }
    }

  private static List<Path> getResponseFilePaths() {
    var result = new ArrayList<Path>();

    Path dirPath = Paths.get(getDataPath());
    try (Stream<Path> paths = Files.walk(dirPath)) {
      paths.forEach(
          filePath -> {
            if (!Files.isRegularFile(filePath)) {
              return;
            }
            result.add(filePath);
          });
    } catch (IOException e) {
      e.printStackTrace();
    }

    return result;
  }

  private static Map<Integer, String> getResponsesFromPath(Path filePath) throws Exception {
    var gson = new Gson();
    try (var reader = new InputStreamReader(Files.newInputStream(filePath))) {
      var typeToken = new TypeToken<Map<Integer, String>>() {}.getType();
      return gson.fromJson(reader, typeToken);
    } catch (IOException e) {
      throw new Exception(e);
    }
  }

  public static String getDataPath() {
    String[] pathParts = {
      Paths.get("").toAbsolutePath().toString(), "src", "main", "resources", "data"
    };
    return String.join(File.separator, pathParts);
  }
}


