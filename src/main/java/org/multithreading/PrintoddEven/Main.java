package org.multithreading.PrintoddEven;

public class Main {

  public static void main(String[] args) {
    int totalThreads = 3;
    SharedClass counter = new SharedClass(10);

//    Thread oddThread = new Thread(new Print(counter,1), " OddPrint");
//    Thread evenThread = new Thread(new Print(counter,0), " EvenPrint");
//
//    oddThread.start();
//    evenThread.start();

    for(int i=0; i<totalThreads; i++) {
      Thread printThread = new Thread(new NNumberMThread(counter,totalThreads,i),"Thread - " + (i+1) );
      printThread.start();
    }


  }
}
