package Multithreading;

public class MainClass {

    private static int flag = 0;

    public static void Eating(Philosophers philosophers) throws InterruptedException {
        synchronized (philosophers) {
            philosophers.eating();
            Thread.sleep(philosophers.getTimeToEat());
        }
    }

    public static void Sleeping(Philosophers philosophers) throws InterruptedException {
        philosophers.sleeping();
        Thread.sleep(philosophers.getTimeToSleep());
    }

    public static void Died(Philosophers philosophers) {
        if (System.currentTimeMillis() - philosophers.getPhilosopherStartedTime() > philosophers.getTimeToDie()) {
            flag = 1;
        }
    }

    public static void Life(Philosophers philosophers) throws InterruptedException {
        while (true) {
            Eating(philosophers);
            Sleeping(philosophers);
            philosophers.thinking();
            if (flag == 1)
                break ;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // number of philosophers, time to eat, time to sleep, time to die, number of food
        // forks - synchronized methods
        // 1, 2, 3, 4, 5, 6, 7, 8, 9

        if (args.length >= 4 && args.length <= 5) {
            // command line arguments
            final int philosophersNumber = Integer.parseInt(args[0]);
            final int timeToEat = Integer.parseInt(args[1]);
            final int timeToSleep = Integer.parseInt(args[2]);
            final int timeToDie = Integer.parseInt(args[3]);
            int numberOfFood = 0;
            if (args.length == 5)
                numberOfFood = Integer.parseInt(args[4]);

            // create an array of philosophers
            Philosophers[] philosophers = new Philosophers[philosophersNumber];

            // Initializing elements of philosophers array
            for (int i = 0; i < philosophersNumber; i++) {
                philosophers[i] = new Philosophers(i);
                philosophers[i].setTimeToEat(timeToEat);
                philosophers[i].setTimeToSleep(timeToSleep);
                philosophers[i].setTimeToDie(timeToDie);
                if (args.length == 5)
                    philosophers[i].setNumberOfFood(numberOfFood);
            }

            // print philosophers id
            for (int i = 0; i < philosophersNumber; i++) {
                System.out.println(philosophers[i]);
            }

            System.out.println("<===========================================>");

            // create threads
            for (int i = 0; i < philosophersNumber; i++) {
                philosophers[i].setPhilosopherStartedTime(System.currentTimeMillis());
                philosophers[i].start();
            }

            // life of these threads
            for (int i = 0; i < philosophersNumber; i++) {
                Life(philosophers[i]);
            }

            // join these thread with main thread
            for (int i = 0; i < philosophersNumber; i++) {
                philosophers[i].join();
            }

            System.out.println("<===========================================>");

        }
        else
            System.out.println("ERROR!\nWRONG NUMBER OF ARGUMENTS!");
    }
}

class Philosophers extends Thread {

    // philosopher id
    private final int id;

    // philosopher started time
    private long philosopherStartedTime;

    // eat, sleep, die
    private int timeToEat;
    private int timeToSleep;
    private int timeToDie;
    private int numberOfFood;

    Philosophers(final int id) {
        this.id = id;
    }

    public void setTimeToEat(int timeToEat) { this.timeToEat = timeToEat; }
    public void setTimeToSleep(int timeToSleep) { this.timeToSleep = timeToSleep; }
    public void setTimeToDie(int timeToDie) { this.timeToDie = timeToDie; }
    public void setNumberOfFood(int numberOfFood) { this.numberOfFood = numberOfFood; }
    public void setPhilosopherStartedTime(long philosopherStartedTime) { this.philosopherStartedTime = philosopherStartedTime; }

    public int getTimeToEat() { return timeToEat; }
    public int getTimeToSleep() { return timeToSleep; }
    public int getTimeToDie() { return timeToDie; }
    public int getNumberOfFood() { return numberOfFood; }
    public long getPhilosopherStartedTime() { return philosopherStartedTime; }

    public void eating() {
        System.out.println(id + " is eating");
    }

    public void sleeping() {
        System.out.println(id + " is sleeping");
    }

    public void died() {
        System.out.println(id + " is died");
    }

    public void thinking() {
        System.out.println(id + " is thinking");
    }

    @Override
    public void run() {
        System.out.println(id + " has started");
    }



    @Override
    public String toString() {
        return "Philosophers{" +
                "id=" + id +
                ", timeToEat=" + timeToEat +
                ", timeToSleep=" + timeToSleep +
                ", timeToDie=" + timeToDie +
                ", numberOfFood=" + numberOfFood +
                '}';
    }
}


