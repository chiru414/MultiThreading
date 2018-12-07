import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threadpool {
//How many threads do u want to use in the application
    //Creation of thread is resource heavy , hence we will maintain a pool of threads
    public static void main(String[] args){
        System.out.println("<=========== main started ============>");
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(int i =0;i<10;i++){
            Runnable runnable = new myClass("workerThread"+i);
            executorService.execute(runnable);
        }

        executorService.shutdown();

        while (!executorService.isTerminated()){

        }
        System.out.println("All threads processed");
        System.out.println("<=========== main ended ============>");

    }

}

class myClass implements Runnable{
    String name;
    myClass(String name){
        this.name = name;
    }
    public void run() {
        System.out.println("Start Thread " + name);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ended Thread "+ name);
    }
}