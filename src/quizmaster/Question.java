/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizmaster;

/**
 *
 * @author pedro
 */
public class Question
{
    private String question;
    private String[] answerChoices = new String[4];
    private int correct;
    public String[] getChoices()
    {
     return answerChoices;  
    }

    public Question(String question, String[] answerChoices, int correct)
    {
        this.question = question;
        this.answerChoices = answerChoices;
        this.correct = correct;
    }
    
    public String toString()
    {
        String s = question + '\n';
        for ( int i = 0; i<4; i++)
        {
            s += answerChoices[i];
        }
        return s;
    }
    
    public String getQuestion()
    {
        return question;
    }
    
    public int getCorrect()
    {
        return correct;
    }
    
    public void setCorrect(int correct)
    {
        this.correct = correct;
    }
}