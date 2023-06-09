import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            // Swap the elements at the left and right indices
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            // Move the indices towards the center
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5,6};

        System.out.println("Original Array: " + Arrays.toString(array));

        reverseArray(array);

        System.out.println("Reversed Array: " + Arrays.toString(array));
    }
}