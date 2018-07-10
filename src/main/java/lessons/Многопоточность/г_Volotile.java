package lessons.Многопоточность;

public class г_Volotile {

    /*volitile заставляет потоки брать значение переменной из основной памяти, а не из кэша
    * почемуто работает и без волотайла
    *
    * Сейчас современное железо предоставляет хорошую реализацию по согласованности кэша,
    * таким образом изменения в одном кэше отражаются в другом, но это не хорошая практика надеется на железо.
    * Необходимо выполнять синхронизацию в коде.*/

    volatile static int number = 0;

    public static void main(String[] args) {
        new MyThreadReader().start();
        new MyThreadWriter().start();
    }

    static class MyThreadWriter extends Thread {
        @Override
        public void run() {
            while (number < 5) {
                System.out.println("increment number to " + (++number));
                try {
                    sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyThreadReader extends Thread {
        @Override
        public void run() {
            int local_var = number;
            while (local_var < 5) {
                if (local_var != number) {
                    System.out.println("now value of number is " + (local_var));
                    local_var = number;
                }
            }
        }
    }
}




