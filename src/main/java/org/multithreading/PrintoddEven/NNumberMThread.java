package org.multithreading.PrintoddEven;

public class NNumberMThread implements Runnable {
    private final SharedClass sharedClass;
    int totalThread;
    private final int threadNumber;

    public NNumberMThread(SharedClass sharedClass, int totalThread, int threadNumber) {
        this.sharedClass = sharedClass;
        this.totalThread = totalThread;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedClass) {
                if (sharedClass.getCounter() > sharedClass.getMAX_VALUE()) {
                    sharedClass.notifyAll();
                    break;
                }

                if ((sharedClass.getCounter() -1) % totalThread == threadNumber) {
                    sharedClass.print();
                    sharedClass.notifyAll();
                } else {
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
