package org.multithreading.PrintoddEven;

public class Print implements Runnable{

  private final SharedClass sharedClass;
  private final int remainder;

  public Print(SharedClass sharedClass, int remainder) {
    this.sharedClass = sharedClass;
    this.remainder = remainder;
  }

  @Override
  public void run() {
    while(true) {
      synchronized (sharedClass) {
        if(sharedClass.getCounter() >= sharedClass.getMAX_VALUE()) {
          break; // Exit if the counter has reached the maximum value
        }
        if(sharedClass.getCounter() % 2 == remainder) {
          sharedClass.print();
          sharedClass.notify();
        }
        else{
          try {
            sharedClass.wait();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      }
    }
  }
}
