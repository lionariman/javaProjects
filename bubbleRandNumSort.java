import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

class bubbleRandNumSort {

    public static void waitBeforeGenerate() {
        System.out.println("\nRandom numbers generation...\n");
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("1...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("2...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("3...");
        } catch (Exception e) {
            System.out.println("\n\nERROR\n\n");
        }
        System.out.println("\nDONE!");
    }

    public static void randNumsGeneration(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; ++i) {
            array[i] = random.nextInt(array.length);
        }
    }

    public static void printElements(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            System.out.println(i + ") " + array[i]);
        }
    }

    public static void bubbleSort(int[] array) {
        int tmp;
        int n = array.length;
        for (int j = 0; j < n - 1; ++j) {
            for (int i = 0; i < n - j - 1; ++i) {
                if (array[i + 1] < array[i]) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements: ");
        int numberOfElements = scanner.nextInt();
        
        int[] array = new int[numberOfElements];
        
        waitBeforeGenerate();
        randNumsGeneration(array);
        
        System.out.println("\nnumbers before sort\n");
        printElements(array);

        bubbleSort(array);

        System.out.println("\nnumbers after sort\n");
        printElements(array);
    }
}
