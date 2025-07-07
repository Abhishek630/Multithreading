package org.multithreading.PrintoddEven;

public class Main {

  public static void main(String[] args) {

    SharedClass counter = new SharedClass(10);

    Thread oddThread = new Thread(new Print(counter,1), " OddPrint");
    Thread evenThread = new Thread(new Print(counter,0), " EvenPrint");

    oddThread.start();
    evenThread.start();
  }
}
