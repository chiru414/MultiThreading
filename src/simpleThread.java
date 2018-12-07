public class simpleThread {
    //Thread states New, runnable, running, waiting, terminated
    //New --> Just born
    //runnable --> Once we start it moves to this state
    //waiting --> Thread will be inactive , sleeping for some event to complete
    //Main method it self is a thread. Threading introduces time slicing executing multiple tasks in specific times
    //Extends Thread class or implement runnable interface
    //Thread execute the code always in sequence

    public static void main(String[] args){
        //Job1
        System.out.println("<==========App is started==========>");

        //Job3 main and mytask will execute concurrently thread extending thread class
        mytask task = new mytask();
        task.start(); //starting the child thread

        //Job 5 thread creation implementing runnable
        Runnable r = new newtask();
        Thread mythread = new Thread(r);
        //mythread.setDaemon(true); // this will make this one as Daemon thread, hence will be started in parallel with main() or whenever app starts
        mythread.start();

        //Job2
        for(int i =1;i < 10;i++){
            System.out.println("<=====Printing document number "+i);
        }



        //Job4
        System.out.println("<==========App is Ended==========>");
    }
}

class mytask extends Thread{
    public void run(){
        for(int i =1;i < 10;i++){
            System.out.println("<=====Printing Secure document number "+i);
        }

    }
}

class newtask extends dummy implements Runnable{
    @Override
    public void run() {
        for(int i =1;i < 10;i++){
            System.out.println("<=====Printing Highly Secure document number "+i);
        }
    }
}

class dummy{

}