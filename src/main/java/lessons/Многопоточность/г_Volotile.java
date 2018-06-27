package lessons.Многопоточность;

public class г_Volotile {

    /*volitile заставляет потоки брать значение переменной из основной памяти, а не из кэша*/
    volatile static int number;

    public static void main(String[] args) {
        new MyThreadWriter().start();
        new MyThreadReader().start();
    }

    static class MyThreadWriter extends Thread {
        @Override
        public void run() {
            while (number < 10) {
                System.out.println("increment number to " + (++number));
                try {
                    sleep(800);
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
            while (local_var < 10) {
                if (local_var != number) {
                    System.out.println("now valut of numbler is " + (++local_var));
                    local_var = number;
                }
            }
        }
    }
}




