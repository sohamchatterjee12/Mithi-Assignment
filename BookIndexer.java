import java.io.FileReader;
import java.io.*;
import java.util.*;
public class BookIndexer {

    public static void main(String[] args) {
        SortedMap<String, ArrayList<Integer>> occurences = new TreeMap<String, ArrayList<Integer>>();
        try {
            BufferedReader br;   
            br = new BufferedReader(new FileReader(args[0]));   
            Set<String> exclude=new Exclude(br).getExcludedWords();
            for(int i=1;i<args.length;i++){
            br = new BufferedReader(new FileReader(args[i]));
            new Index(br,i,occurences,exclude);
            FileWriter writer = new FileWriter("index.txt");  
            BufferedWriter buffer = new BufferedWriter(writer);  
            buffer.write("Words : PageNumbers \n");
            buffer.write("------------------- \n");
            for(SortedMap.Entry<String,ArrayList<Integer>> entry : occurences.entrySet())
                buffer.write(entry.getKey()+" : "+entry.getValue().toString().substring(1,entry.getValue().toString().length()-1)+"\n");  
            buffer.close();  
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}