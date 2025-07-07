package org.multithreading.PrintoddEven;

public class EvenPrint implements  Runnable{

  private final SharedClass sharedClass;

  public EvenPrint(SharedClass sharedClass){
    this.sharedClass = sharedClass;
  }

  @Override
  public void run() {
    while(true){
      synchronized (sharedClass) {
        if (sharedClass.getCounter() >= sharedClass.getMAX_VALUE()) {
          break; // Exit if the counter has reached the maximum value
        }
        if (sharedClass.getCounter() % 2 == 0) {
          sharedClass.print();
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
