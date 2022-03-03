/***************************************************************************************
*    Title: Java program generate a random String using Regular Expressions method
*    Author: Rajput-Ji 
*    Availability: https://www.geeksforgeeks.org/generate-random-string-of-given-size-in-java/
*
***************************************************************************************/
  
import java.util.*; 
import java.nio.charset.*; 
  
class RandomString { 
  
    public String getRandomString(int n) 
    { 
  
        // length is bounded by 256 Character 
        byte[] array = new byte[256]; 
        new Random().nextBytes(array); 
  
        String randomString 
            = new String(array, Charset.forName("UTF-8")); 
  
        // Create a StringBuffer to store the result 
        StringBuffer r = new StringBuffer(); 
  
        // remove all spacial char 
        String  RandomString 
            = randomString 
                  .replaceAll("[^A-Za-z]", ""); 
  
        // Append first 20 characters 
        // from the generated random String into the result 
        for (int k = 0; k < RandomString.length(); k++) { 
  
            if (Character.isLetter(RandomString.charAt(k)) 
                    && (n > 0) 
                || Character.isDigit(RandomString.charAt(k)) 
                       && (n > 0)) { 
  
                r.append(RandomString.charAt(k)); 
                n--; 
            } 
        } 
  
        // return the resultant string 
        return r.toString(); 
    }

} 