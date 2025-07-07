package org.multithreading.PrintoddEven;

public class OddPrint implements  Runnable{

  private final SharedClass sharedClass;

  public OddPrint (SharedClass sharedClass){
    this.sharedClass = sharedClass;
  }

  @Override
  public void run() {
    while(true){
      synchronized (sharedClass) {
        if (sharedClass.getCounter() >= sharedClass.getMAX_VALUE()) {
          break; // Exit if the counter has reached the maximum value
        }
        if (sharedClass.getCounter() % 2 != 0) {
          sharedClass.print();
//          System.out.println("Odd: " + sharedClass.getCounter());
//          sharedClass.setCounter(sharedClass.getCounter() + 1);
          sharedClass.notify(); // Notify other threads waiting on this object
        } else {
          try {
            sharedClass.wait(); // Wait for the even thread to notify
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }

  }
}
