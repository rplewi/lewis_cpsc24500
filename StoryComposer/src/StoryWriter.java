import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * This StoryWriter class will be what writes our stories that we created to a user specified file!
 */
public class StoryWriter {
    /**
     * This method inside StoryWriter will be what actually writes our text and saves it to the file location.
     * @param ourText - the text we want to save to the file.
     */
    public void saveStory(String ourText){
        JFileChooser jfc = new JFileChooser();
        try {
            if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(jfc.getSelectedFile()))); // Creates the file we will be saving our output to!
            pw.println(ourText);
            pw.close();
            JOptionPane.showMessageDialog(null, "File was saved to" + jfc.getCurrentDirectory());
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "You did something wrong brodie try again.");
        }
        
        
        
    }
}
