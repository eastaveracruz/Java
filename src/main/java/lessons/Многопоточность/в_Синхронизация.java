package lessons.Многопоточность;

public class в_Синхронизация {
    public static void main(String[] args) throws InterruptedException {
        Res res = new Res();
        MyThread2 t1 = new MyThread2();
        MyThread2 t2 = new MyThread2();
        t1.setRes(res);
        t2.setRes(res);
        t1.start();
        t2.start();
        Thread.sleep(5000);
        System.out.println(res.getCount());
    }
}

class MyThread2 extends Thread {

   private Res res;

    public void setRes(Res res) {
        this.res = res;
    }

      @Override
    public void run() {
        for (int j = 0; j < 1000_000_0; j++) {
            res.chaingeCount();
        }
    }
}

class Res {
    private int count;

//    в некоторых случаях сетеры тоже должны быть синхронизированы
    public int getCount() {
        return count;
    }

    /*если метод статически, то синхронизация проихсодит на уровне класса ( synchonized (Class.changeCount() )
    * статические переменные синхронизировать на уровне класса
    * объектные переменные синхонизировать на уровне обьекта*/
    synchronized public void chaingeCount() {
//        или так
        synchronized (this){
            count++;
        }

    }
}