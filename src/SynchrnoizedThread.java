public class SynchrnoizedThread {
    //Multithreading is ability of program to run two or more threads concurrently, where each one can handle separate task at same time
    //making optimal use of resources
    //Synchronous execution between threads
    public static void main(String[] args){
        System.out.println("<============ App started ===========>");

        Printer1 myprinter = new Printer1();
        //printer object is shared between 3 threads
        myprinter.printdocs(3,"chiru_profile.pdf"); // Main thread

        myThread1 myThread = new myThread1(myprinter); //Thread 1
        myThread.start();

        yourThread1 yt = new yourThread1(myprinter); // Thread 2
        yt.start();

        System.out.println("<============ App Ended ===========>");
    }

}

class Printer1{
    synchronized void printdocs(int copies,String name){ // Synchronize keyword ensures the threads execute one after another
        //No other thread can access the printer object until running thread completes execution. Kind of locking
        for(int i = 1;i <= copies;i ++){
            System.out.println("<==========printing "+name+" copy number "+ i+" =======>");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class myThread1 extends Thread{
    Printer1 pref;
    myThread1(Printer1 p){
        this.pref = p;
    }
    @Override
    public void run() {
        pref.printdocs(10,"John.docx");
    }
}

class yourThread1 extends Thread{
    Printer1 pref;
    yourThread1(Printer1 p){
        this.pref = p;
    }
    @Override
    public void run() {
        pref.printdocs(5,"Dexter.docx");
    }
}

