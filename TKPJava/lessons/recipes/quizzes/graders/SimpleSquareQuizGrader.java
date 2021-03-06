package src.main.java.org.teachingkidsprogramming.recipes.quizzes.graders;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.NumberUtils;
import src.main.java.org.teachingextentions.logo.TortoiseUtils;
import src.main.java.org.teachingextentions.logo.Turtle;
import src.main.java.org.teachingextentions.logo.utils.LineAndShapeUtils.Paintable;

public class SimpleSquareQuizGrader implements Paintable
{
  private boolean[]  answers;
  public static int  TURTLE_SPEED = 9;
  private SquareQuiz quiz;
  private void displayScreen()
  {
    QuizUtils.prepareScoringScreen(answers, this, TURTLE_SPEED);
    drawRewardShape();
  }
  public void grade(SquareQuiz quiz)
  {
    this.quiz = quiz;
    answers = new boolean[]{grade1Move(), grade2Turn(), grade3Color(), grade4Width()};
    displayScreen();
  }
  @Override
  public void paint(Graphics2D g, JPanel caller)
  {
    QuizUtils.displayScores(g, 200, answers);
  }
  public void drawRewardShape()
  {
    TortoiseUtils.setOrientation(60, 80, 90);
    quiz.question3();
    quiz.question4();
    for (int i = 0; i < 5; i++)
    {
      quiz.question1();
      quiz.question2();
      quiz.question2();
    }
  }
  private boolean grade1Move()
  {
    TortoiseUtils.setTurtle(QuizUtils.createTestTurtle());
    TortoiseUtils.setOrientation(0, 0, 90);
    quiz.question1();
    return NumberUtils
        .equals(TortoiseUtils.getTurtle().getX(), 110, 0.005);
  }
  private boolean grade3Color()
  {
    quiz.question3();
    return TortoiseUtils.getTurtle().getPenColor().equals(Color.yellow);
  }
  private boolean grade4Width()
  {
    quiz.question4();
    return TortoiseUtils.getTurtle().getPenWidth() == 5;
  }
  private boolean grade2Turn()
  {
    int angle = NumberUtils.getRandomInt(5, 20);
    Turtle turtle = QuizUtils.createTestTurtle();
    TortoiseUtils.setTurtle(turtle);
    turtle.setAngleInDegrees(angle);
    quiz.question2();
    return NumberUtils.equals(turtle.getAngleInDegrees(), angle + 360.0 / 5, 0.005);
  }
}
