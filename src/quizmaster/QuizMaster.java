
package quizmaster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author pedro
 */
public class QuizMaster implements ActionListener
{
    Question question1;
    Question question2;
    List<Question>  questions = new ArrayList<Question>();
    int score;
    Timer ticker = new Timer(1000, this);

    public static void main(String[] args)
    {
        new QuizMaster().getGoing();
    }
    
    private void loadQuestions() throws IOException
    {
        File file = new File("questions.text");

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String s;
            String[] answerChoices = new String[4];
            int n = 0;
            Question q = null;
            while( null != ( s = br.readLine())) 
            {
                s = s.trim();
                //System.out.println(s);
                if ( s.length() == 0 ) {

                    continue;
                }
                
                String question = null;
                if(s.contains("?"))
                {
                    n =0;
                    answerChoices = new String[4];
                     question = s;
                    q = new Question(question, answerChoices, 0);
                    questions.add(q);
                   
                    //Question q = new Question(s, answerChoices, score)
                }
                else
                {
                    answerChoices[ n ] = s;
                    if(s.contains("*"))
                    {
                        q.setCorrect(n);
                    }
                    n++;      
                }
            }
            br.close();
 
        
            for ( Question p : questions ) 
            {
                System.out.println(p);
            }   
    }

    private void getGoing()
    {
        try
        {
            //        String[] answers =
            //        {
            //            "A mamel", "A reptile", "A Fish", "A Bird"
            //        };
            //        question1 = new Question("what's a dog?", answers, 0);
            //
            //        String[] answers2 =
            //        {
            //            "FORTRAN", "C++", "Java", "Pascal"
            //        };
            //        question2 = new Question("What is the Best Computer Language?", answers2, 2);
            //
            //        questions[0] = (question1);
            //        questions[1] = (question2);
                    
                    loadQuestions();
        } catch (IOException ex)
        {
            Logger.getLogger(QuizMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
     
//
//        JFrame frame = new JFrame("Quiz Master");
//        frame.setSize(1000, 600);
        for(Question q: questions) 
        {
            String s = (String) JOptionPane.showInputDialog(null, q.getQuestion(), "", JOptionPane.QUESTION_MESSAGE, null, q.getChoices(), q.getChoices()[0]);
            System.out.println("s = " + s);
            if (s.equals(q.getChoices()[q.getCorrect()]))
            {
                
                JOptionPane.showMessageDialog(null, "correct");
                score++;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "wrong");
            }
            
        }
        
        JOptionPane.showMessageDialog(null, "Your Score Was" + score + " out of " + questions.size());
        
//        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
    }
}
