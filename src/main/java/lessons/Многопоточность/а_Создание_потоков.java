package lessons.Многопоточность;

public class а_Создание_потоков {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        myThread myThread = new myThread();
        myThread.start();

//        два раза поток вызывать нельзя
//        myThread.start();

        Thread myRun = new Thread(new myRunable());
        myRun.start();

        Thread abstreactThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });

        abstreactThread.start();

    }
}

class myThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class myRunable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}