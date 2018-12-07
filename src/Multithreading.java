public class Multithreading {
    //Multithreading is ability of program to run two or more threads concurrently, where each one can handle separate task at same time
    //making optimal use of resources
    //Asynchronous execution
    public static void main(String[] args){
        System.out.println("<============ App started ===========>");

        Printer printer = new Printer();
        //printer object is shared between 3 threads
        printer.printdocs(3,"chiru_profile.pdf"); // Main thread

        myThread myThread = new myThread(printer); //Thread 1
        myThread.start();

        yourThread yt = new yourThread(printer); // Thread 2
        yt.start();

        System.out.println("<============ App Ended ===========>");
    }

}

class Printer{
    void printdocs(int copies,String name){
        for(int i = 1;i <= copies;i ++){
            System.out.println("<==========printing "+name+" copy number "+ i+" =======>");
        }
    }
}

class myThread extends Thread{
    Printer pref;
    myThread(Printer p){
        this.pref = p;
    }
    @Override
    public void run() {
        pref.printdocs(10,"John.docx");
    }
}

class yourThread extends Thread{
    Printer pref;
    yourThread(Printer p){
        this.pref = p;
    }
    @Override
    public void run() {
        pref.printdocs(5,"Dexter.docx");
    }
}