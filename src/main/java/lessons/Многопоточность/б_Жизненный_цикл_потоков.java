package lessons.Многопоточность;

/*1. Создание потока.
* 2. Runable - поток находиться в пуле и ждет очереди на исполнение.
* 3. Running - поток выполняется.
* 3.1 Sleep - остановить поток на заданное время, после этого поток перемещается в пул (2).
* 3.2
* 4. Dead - поток умирает.*/

public class б_Жизненный_цикл_потоков {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

//        выставить приоритет
        thread.setPriority(10);

//        заставляет процессор переключиться на обработку других потоков системы, поток прыгает в пулл
        Thread.yield();

//        ждем завершения потока
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        при вызове метода на следующем sleep выброситься InterruptedException
//        thread.interrupt();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread main");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}