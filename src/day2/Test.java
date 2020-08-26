package day2;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * <p>junit test</p>
 *
 * @author : liuyuwei
 * @date : 2020-08-25 16:35
 **/
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyThread myThread = new MyThread(5, "D://hamlet.txt");
        List<List> splitLists = myThread.initFile();
        myThread.multithread(splitLists);
    }
}
