import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.awt.event.ActionEvent;

/** 
 * This will be our main JFrame interface class, will be where all the interactions with buttons and other functions will happen!
*/
public class MyFrame extends JFrame{
    private JTextArea textArea;
    private WordChooser wordChooser;
    private LinkedHashMap<String, ArrayList<String>> wordList;
    private String curText; //String variable that will keep track of the current text before we make any additions.

    /**
     * Sets up our Graphical User Interface for the user.
     */
    public void setupGUI(){
        setBounds(300, 300, 450, 400); // HAD TO CHANGE THE DIMENSIONS OF THE WINDOW SO I DONT HAVE TO RESIZE EVERYTIME TO CLICK THE ADD BUTTON.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Story Composer");
        setBackground(Color.MAGENTA);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JPanel panWest = new JPanel();

        GridLayout gl = new GridLayout(3,1);
        panWest.setLayout(gl);

        /*
         * The first button that will control the adding of nouns
         */
        JButton btnOne = new JButton("Noun");
        panWest.add(btnOne);
        btnOne.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (wordList != null){
                String newWord = wordChooser.chooseWord("n");
                curText = textArea.getText();
                curText += " " + newWord;
                textArea.setText(curText);
                } else {
                    JOptionPane.showMessageDialog(null, "Please load the words into the program using the \"File --> Open\"");
                }
            }
        });

        /**
         * Second button that will control the adding of verbs
         */
        JButton btnTwo = new JButton("Verb");
        panWest.add(btnTwo);
        btnTwo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (wordList != null){
                String newWord = wordChooser.chooseWord("v");
                curText = textArea.getText();
                curText += " " + newWord;
                textArea.setText(curText);
                } else {
                    JOptionPane.showMessageDialog(null, "Please load the words into the program using the \"File --> Open\"");
                }
            }
        });

        /*
         * Third button that will control the adding of adjectives.
         */
        JButton btnThree = new JButton("Adjective");
        panWest.add(btnThree);
        btnThree.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (wordList != null){
                String newWord = wordChooser.chooseWord("a");
                curText = textArea.getText();
                curText += " " + newWord;
                textArea.setText(curText);
                } else {
                    JOptionPane.showMessageDialog(null, "Please load the words into the program using the \"File --> Open\"");
                }
            }
        });

        // Adds panWest pane to container
        c.add(panWest, BorderLayout.WEST);

        // Adds the textArea for the window.
        textArea = new JTextArea();
        c.add(textArea, BorderLayout.CENTER);
        textArea.setEditable(false); // Makes it so the textArea is not able to be tampered with :)
        textArea.setLineWrap(true); // This is what makes it so the characters wrap text around the boundaries of the textArea
        textArea.setWrapStyleWord(true); // This is what makes the words follow the wrapping, so we dont get character cutoffs.
        // I got this code from the Javadocs online https://docs.oracle.com/javase/8/docs/api/javax/swing/JTextArea.html

        JPanel panSouth = new JPanel();
        FlowLayout fl = new FlowLayout();
        panSouth.setLayout(fl);

        JLabel lblEnter = new JLabel("Enter word: ");
        panSouth.add(lblEnter);

        JTextField txtField = new JTextField(20); // Size of textField is 20 m's.
        panSouth.add(txtField);

        // Custom text field for additions
        JButton btnAdd = new JButton("Add");
        panSouth.add(btnAdd);
        btnAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String typedText = txtField.getText(); // .getText() gets text inside of our text box!
                String currentText = textArea.getText();
                textArea.setText(currentText + " " + typedText);
                txtField.setText("");
            }
        });

        // Adds panSouth to the window.
        c.add(panSouth, BorderLayout.SOUTH);
        setupMenu();

    }
    /**
     * This will setup our "file" "Help" menu in the upper part of our interface,
     * Allowing to open, clear, save, exit, or even learn a little about the programmer!
     */
    public void setupMenu(){
        JMenuBar mbar = new JMenuBar();
        setJMenuBar(mbar);

        JMenu mnuFile = new JMenu("File");
        JMenu mnuHelp = new JMenu("Help");
        mbar.add(mnuFile);
        mbar.add(mnuHelp);

        /**
         * Will allow the user to open a file to read and make words from that file appear on screen.
         */
        JMenuItem miOpen = new JMenuItem("Open");
        mnuFile.add(miOpen);
        miOpen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFileChooser chooser = new JFileChooser();
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                        WordFileReader wfr = new WordFileReader();
                        wordList = wfr.readFile(chooser.getSelectedFile()); 
                        wordChooser = new WordChooser(wordList);
                    
                }
            }
        });
        // Saving to the user specified file name to save the output!
        JMenuItem miSave = new JMenuItem("Save");
        mnuFile.add(miSave);
        miSave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    StoryWriter sw = new StoryWriter();
                    sw.saveStory(textArea.getText());
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Something went wrong try again!");
                }
            }
        });

        /*
         * This will clear the writing text area on the screen for the user!
         */
        JMenuItem miClear = new JMenuItem("Clear");
        mnuFile.add(miClear);
        miClear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                textArea.setText(""); // Clears text area for the user!
            }
        });

        /*
         * This will exit the program for the user.
         */
        JMenuItem miExit = new JMenuItem("Exit");
        mnuFile.add(miExit);
        miExit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0); // Exits program saying all is good!
            }
        });
        
        /*
         * This option will display a little about who created the project and what year it was done!
         */
        JMenuItem miAbout = new JMenuItem("About");
        mnuHelp.add(miAbout);
        miAbout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Story Composer by Roman Lewis in Object Oriented Programming Fall 2024"); // Dialog box for the "about" menu option.
            }
        });

    }
    public MyFrame(){
        wordList = null;
        textArea = null;
        setupGUI();
    }
    
}
