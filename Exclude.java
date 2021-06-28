import java.util.*;



public class Exclude {
    private Set<String> hash_Set = new HashSet<String>();

    public Exclude(Readable text) {
        Scanner sc = new Scanner(text);        

        try {
            while (sc.hasNextLine()) {
                String line_word = sc.nextLine(); 
                hash_Set.add(line_word);
            }
        } finally {
            sc.close();
        }
    }
    public Set<String> getExcludedWords(){

        return hash_Set;
    }
}
