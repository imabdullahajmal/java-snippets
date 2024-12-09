package runnables;

/**
 *
 * @author dell
 */
class One2Ten implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i += 1) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

}

public class SyncThreads {
    public static void main(String[] args) {
        Thread thr = new Thread(new One2Ten());
        Thread thr_2 = new Thread(new One2Ten());
        
        Thread[] thds = {
            new Thread(new One2Ten()),
            thr,
            thr_2
        };
        
        for(int i=0;i<thds.length;i++) {
            thds[i].start();
            while(!thds[i].getState().toString().equals("TERMINATED"))
                continue;
        }
    }

}