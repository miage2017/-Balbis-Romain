package exercice3;
 public final class ObjetExecutable  implements Runnable {
 private volatile boolean done = false;
 public void seterminer() {done = true;}

public synchronized void run()
{int i = 0;
  while (!done)
     {System.out.println(i++);}
 }

public static void main(String[] args) throws InterruptedException {
  ObjetExecutable container = new ObjetExecutable();
  Thread myThread = new Thread(container);
  myThread.start();
  Thread.sleep(500);
  container.seterminer();
}
 }
