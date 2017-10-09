/**
 *
 */
package nlp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

public class MainClass {

    public static void main(String[] args) {
        System.out.println("Enter Sentence for tokenize : ");
        Scanner s = new Scanner(System.in);
        String sentence = s.nextLine();
        s.close();

        PosTagger tagger = new PosTagger("c:\\users\\vimal patel\\nlp\\reminderModel.zip", "G:\\tools\\Opennlp models\\en-token.bin");
        TokenizerUtils tokenizer = new TokenizerUtils("G:\\tools\\Opennlp models\\en-token.bin");
        //NameFinder nameFinder = new NameFinder("G:\\tools\\Opennlp models\\en-ner-person.zip","G:\\tools\\Opennlp models\\en-token.bin");

        String[] tokens = tokenizer.tokenizeStringUsingLearnableTokenizer(sentence);
        String[] tags = tagger.tagifyString(tokens);

        System.out.print("tokens_tags : ");
        for(int i=0; i<tokens.length; i++)
            System.out.print(" "+ tokens[i] + "_" + tags[i]);

        String eventString = EventExtractor.exractEvent(tokens, tags).toString();
        System.out.println("\n" + eventString);// + "Time : " + TimeParser.parseTime(eventString).toString());
        String ss="";
        /*try {
            ss = new SimpleDateFormat("dd,MMMMMMMMM").parse("1,October 2017").toString();
        } catch (ParseException e) {
            System.out.print(e.getMessage());
        }
        System.out.println(ss);*/
    }

}