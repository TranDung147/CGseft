public class App {
    public static void main(String[] args) {
        SelectionSort order = new SelectionSort();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.print("Array before sorting: ");
        for (int i = 0; i <array.length; i++) {
            System.out.print(array[i] + " ");
        }
        order.optimizedBubbleSort(array);

        System.out.print("\nArray after sorting: ");
        for (int i = 0; i <array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
