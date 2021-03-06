/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        String trimmed_stat = statement.trim();
        if (statement.indexOf("no") >= 0)
        {
            response = "Why so negative?";
        }
        else if (findWord(statement, "mother") >= 0
                || findWord(statement, "father") >= 0
                || findWord(statement, "sister") >= 0
                || findWord(statement, "brother") >= 0)
        {
            response = "Tell me more about your family.";
        }
        else if (findWord(statement, "dog") >= 0
                || findWord(statement, "cat") >= 0)
        {
            response = "Tell me more about your pets.";
        }
        else if (findWord(statement, "nathan") >= 0)
        {
            response = "He sounds like a good teacher.";
        }
        else if (findWord(statement, "cool") >=0)
        {
            response = "That's cool.";
        }
        else if (findWord(statement, "mother") >=0)
        {
            response = "What is your favorite food?";
        }
        else if (findWord(statement, "soccer") >= 0
                || findWord(statement, "tennis") >= 0
                || findWord(statement, "basketball") >= 0
                || findWord(statement, "baseball") >= 0)
        {
            response = "Tell me more about your favorite sport.";
        }
        else if (trimmed_stat.length() == 0)
        {
            response = "Please say something.";
        }
        else if (findWord(statement, "I want to") >= 0)
        {
         response = transformIWantToStatement(statement);
        }
        else if (findWord(statement, "I want") >= 0)
        {
         response = transformIWantStatement(statement);
        }
        else if (findWord(statement, "I") >= 0 && findWord(statement, "you") >= 0 && findWord(statement, "I") < findWord(statement, "you"))
        {
         response = transformIYouStatement(statement);
        }
        else if (findWord(statement, "you") >= 0 && findWord(statement, "me") >= 0 && findWord(statement, "you") < findWord(statement, "me"))
        {
         response = transformYouMeStatement(statement);
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }
    
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    public String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4)
        {
            response = "Great.";
        }
        else if (whichResponse == 5)
        {
            response = "Precisely.";
        }
    
        return response;
    }

    // Checks to see if the String word appears as a whole word
    // in the String str (in this case, a "whole word" means that 
    // word is not just a substring of some larger word in str)

    // This method should work regardless of the capitalization 
    // of str or word

    // The method returns the index of the first character in word
    // if it is found, and returns -1 otherwise. 
    
public int findWord(String str, String word) {
    str = " " + str.toLowerCase() + " ";
    word = " " + word.toLowerCase() + " ";

    return str.indexOf(word);
}
    
    // We will work on the following methods later!

    /**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    public String transformIWantStatement(String statement){
    String trim = statement.trim().toLowerCase();
    if(trim.indexOf("i want ") >= 0){
        String trim_sub = trim.substring(trim.indexOf("i want ") + 7);
        String response_sub = trim_sub.trim();
        return "Would you really be happy if you had " + response_sub + "?";
    }
    return "";
   }

    /**
     * Take a statement with "I <something> you" and transform it into 
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    public String transformIYouStatement(String statement)
    {
        String low = statement.toLowerCase();
        int index_i = low.indexOf("i ");
        int index_you = low.indexOf(" you");
        String between = low.substring((index_i+2), (index_you));
        return "Why do you " + between + " me?";
    }

    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWantToStatement(String statement)
    {
    String trim = statement.trim().toLowerCase();
    if(trim.indexOf("i want to ") >= 0){
        String trim_sub = trim.substring(trim.indexOf("i want to ") + 10);
        String response_sub = trim_sub.trim();
        return "What would it mean to " + response_sub + "?";
        }
    return "";
    }




    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement)
    {
        String low = statement.toLowerCase();
        int index_you = low.indexOf("you ");
        int index_me = low.indexOf(" me");
        String between = low.substring((index_you+4), (index_me));
        return "What makes you think that I " + between + " you?";
    }
}
