package DAY1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <h3>JAVA</h3>
 * <p>mapreduce 计算word count</p>
 *
 * @author : liuyuwei
 * @date : 2020-08-24 17:22
 **/
public class MapReduce {

    public static void main(String[] args) {
        //split
        List readFile = readFile("D://hamlet.txt");
        //map
        ArrayList<Tuple> tupleArrayList = map(readFile);
        //shuffle
        HashMap<String, ArrayList<Integer>> shuffleHashMap = shuffle(tupleArrayList);
        //reduce
        ArrayList<Tuple> results = reduce(shuffleHashMap);
        for (int i = 0; i <results.size() ; i++) {
            System.out.println(results.get(i).toString());
        }
    }

    /*
    split
     */
    public static List readFile(String fileName){
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            //按行处理
            //1、将非字符处理成空格 2、所有字符换成小写
            list = stream
                    .map(s ->s.replaceAll("[\\pP\\p{Punct}]"," "))
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /*
    map
     */
    public static ArrayList<Tuple> map(List list){
        ArrayList<Tuple> tuples = new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            String[] s = list.get(i).toString().split(" ");
            for (int j = 0; j <s.length; j++) {
                tuples.add(new Tuple(s[j],1));
            }
        }
        return tuples;
    }
    /*
    shufle
     */
    public static HashMap<String,ArrayList<Integer>> shuffle(ArrayList<Tuple> tuples){
        HashMap<String, ArrayList<Integer>> listHashMap = new HashMap<>();
        for (int i = 0; i <tuples.size() ; i++) {
            if(listHashMap.containsKey(tuples.get(i).key)){
                listHashMap.get(tuples.get(i).key).add((Integer)tuples.get(i).value);
            }
            else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add((Integer)tuples.get(i).value);
                listHashMap.put(String.valueOf(tuples.get(i).key),temp);
            }

        }
        return listHashMap;
    }

    /*
    reduce
     */
    public static ArrayList<Tuple> reduce(HashMap<String, ArrayList<Integer>> listHashMap){
        ArrayList<Tuple> tuples = new ArrayList<>();
        for (String s :listHashMap.keySet()) {
            tuples.add(new Tuple(s,listHashMap.get(s).size()));
        }
        return tuples;
    }


}




class Tuple<String, Integer>{
    public final String key;
    public final Integer value;

    public Tuple(String key, Integer value){
        this.key = key;
        this.value = value;
    }

    @Override
    public java.lang.String toString() {
        return  key +"," + value ;
    }
}





