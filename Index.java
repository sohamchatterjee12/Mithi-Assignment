import java.util.*;



public class Index {



    public Index(Readable text,int PageNo,SortedMap<String, ArrayList<Integer>> occurences, Set<String> exclude) {
        Scanner sc = new Scanner(text);        

        try {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] words = line.split("[0-9 ]");
                for (String word : words) {
                    word = word.toLowerCase();
                    word=word.replaceAll("[\\p{Ps}\\p{Pe}]", "");
                    word=word.replaceAll("[,]", "");
                    word=word.replaceAll("[./]", "");
                    word=word.replaceAll(":", "");
                    word=word.replaceAll("-", "");
                    word=word.replaceAll("^\"|\"$", "");
                    if(word.equals("") || exclude.contains(word))
                        continue;
                    ArrayList<Integer> list = occurences.get(word);
                    if (list == null) {
                        list = new ArrayList<>();
                        list.add(PageNo);
                    } else {
                        if(list.get(list.size()-1)!=PageNo)
                            list.add(PageNo);                  
                    }
                    occurences.put(word, list);
                }
            }
        } finally {
            sc.close();
        }
    }
}