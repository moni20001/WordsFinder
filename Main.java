import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] words = new String[72798];
        String inputPath = "src\\words.txt";
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        for (int i = 1; i <= 72767; i++) {
            String[] line = reader.readLine().split("\"");
            String word = line[3];
            words[i] = word;
        }
        Scanner scan = new Scanner(System.in);
        System.out.print("Дължина:");
        int length = Integer.parseInt(scan.nextLine());
        //creating list of the letters containing
        System.out.print("Букви:");
        String[] lettersContaining = scan.nextLine().split(" ");
        List<Character> contains = new ArrayList<>();
        for (String w: lettersContaining) {
            contains.add(w.charAt(0));
        }
        //filter and printing the words
        System.out.printf("Думи: ");
        Arrays.stream(words).filter(a -> a.length() == length).filter(а -> а!=null);
        for (int i = 0; i < words.length; i++) {
            try{
                char[] letttersIn = words[i].toCharArray();
                boolean isTrue = true;
                for (int j = 0; j < letttersIn.length; j++) {
                    if(!contains.contains(letttersIn[j])){
                        isTrue = false;
                    }
                }
                if(isTrue && (letttersIn.length == length)){
                    System.out.printf("%s ",words[i]);
                }}
            catch (Exception e){}
        }


    }
}
