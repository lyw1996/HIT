package day2;

import java.util.*;
import java.util.concurrent.*;

/**
 * <h3>JAVA</h3>
 * <p>线程池</p>
 *
 * @author : liuyuwei
 * @date : 2020-08-25 18:15
 **/
public class MyThread {

    private int threadNum;
    private String fileName;
    private MapReduce mapReduce;


    public MyThread(int threadNum, String fileName) {
        this.threadNum = threadNum;
        this.fileName = fileName;
        this.mapReduce = new MapReduce();

    }

    public List<List> initFile() {
        List file = mapReduce.readFromFile(fileName);
        List<List> splitLists = mapReduce.splitting(threadNum, file);
        return splitLists;
    }

    public void multithread(List<List> splitLists) throws ExecutionException, InterruptedException {
        // 创建一个线程池
        List<Tuple> allTuples = Collections.synchronizedList(new ArrayList<>());
        ExecutorService pool = Executors.newFixedThreadPool(threadNum);

        for (int i = 0; i < threadNum; i++) {
            final int id = i;
            pool.execute(() -> {
                try {
                    List<Tuple> mappingTuples = mapReduce.mapping(splitLists.get(id));
                    allTuples.addAll(mappingTuples);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        pool.shutdown();
        List<Tuple> allOriginTuples;
        while (true){
            if(pool.isTerminated()){
                allOriginTuples=allTuples;
                break;
            }
        }


        Map<String, ArrayList<Integer>> shuffleMap = mapReduce.shuffling(allOriginTuples);
        ExecutorService pool2 = Executors.newFixedThreadPool(100);
        List<Tuple> finalResult = Collections.synchronizedList(new ArrayList<>());
        for (String skey : shuffleMap.keySet()) {
            final String s = skey;
            pool2.execute(() -> {
                try {
                    HashMap<String, ArrayList<Integer>> temp = new HashMap<>();
                    temp.put(s, shuffleMap.get(s));
                    List<Tuple> reduceList = mapReduce.reducing(temp);
                    finalResult.addAll(reduceList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        }
        pool2.shutdown();
        while (true){
            if(pool2.isTerminated()){
                mapReduce.printResult(finalResult);
                break;
            }
        }

    }


}
class CallableImpl implements Callable {
    private List<List> splitLists;
    private MapReduce mapReduce;
    private List<Tuple> allTuples;
    private int id;
    CallableImpl(List<List> splitLists,MapReduce mapReduce,List<Tuple> allTuples,int id){
        this.splitLists=splitLists;
        this.mapReduce=mapReduce;
        this.allTuples=allTuples;
        this.id=id;
    }
    @Override
    public Object call(){
        List<Tuple> mappingTuples = mapReduce.mapping(splitLists.get(id));
        allTuples.addAll(mappingTuples);
        return this.allTuples;
    }
}
