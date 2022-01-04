/*Summary: This code uses the Caesar cipher approach to encode a given message based on user input of number of key values, the specific key values and the message to encode. It then prints out both the encoded and the decoded message.
Author: Sarah Haetzel
*/
import java.util.*;

public class CaesarCipher{
    public static void main(String[] args){
        String ans = "yes";
        while(ans.equals("yes")){
            int numKeyValues;
            String decoded Message;

            //Prompt the user to enter the number of key values that will be used to encode a message
            System.out.println("Enter the number of key values: ");
            Scanner numKeyValuesScanner = new Scanner(System.in);
            numKeyValues = numKeyValuesScanner.nextInt();

            //Prompt the user to enter the key values that will be used to encode a message
            Scanner keyValuesScanner = new Scanner(System.in);
            List<Integer> keyValues = new ArrayList<Integer>();
            for(int i = 0; i < numKeyValues; i++){
                keyValues.add(keyValuesScanner.nextInt());
            }

            //Prompt the user to enter the string they want to encode
            System.out.println("Enter a string to be encoded: ");
            Scanner decodedMessageScanner = new Scanner(System.in);
            decodedMessage = decodedMessageScanner.nextLine();

            //Determine the encoded message based on the key values entered above
            StringBuffer encoded = new StringBuffer(decodedMessage.length());
            for(int i =0; i < decodedMessage.length(); i++){
                char changingCharacter = decodedMessage.charAt(i);
                int ascii = changingCharacter;
                int keyAccessValue = i % numKeyValues;
                ascii += keyValues.get(keyAccessValue);

                if(ascii < 32){
                    ascii = 126;
                }
                else if(ascii > 126){
                    ascii = 32;
                }
                changingCharacter = (char) ascii;
                encoded.append(changingCharacter);
            }

            //Print both the encoded and the decoded message
            System.out.println("The encoded message: ");
            System.out.println(encoded);
            System.out.println("The decoded message: ");
            System.out.println(decodedMessage);

            Scanner programLoop = new Scanner(System.in);
            System.out.println("Do you want to run the program again (yes/no)?: ");
            ans = programLoop.next();
        }
    }
        
}
