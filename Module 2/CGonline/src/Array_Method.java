import java.util.Arrays;

public class Array_Method {
    public static void main(String[] args) {
        int[] array = new int[5];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;
        removeItem(1,3, array);
        removeItemByIndex(3, array);
        addItem(6, array);
        findIdexByValue(3,array);

    }
    static int[] removeItem(int a, int b, int[] arrayRemove) {
        int countItemRemove = b - a + 1;
        int[] newArray2 = new int[arrayRemove.length - countItemRemove];
        for (int i = 0; i < arrayRemove.length; i++) {
            if (i < a || i > b) {
                newArray2[i] = arrayRemove[i];
            } else {
                if (i == arrayRemove.length - countItemRemove) {
                    break;
                }
                newArray2[i] = arrayRemove[i + countItemRemove];
            }
        }
        arrayRemove = newArray2;
        System.out.println(Arrays.toString(arrayRemove));
        return newArray2;
    }

    static int[] removeItemByIndex(int index, int[] array) {
        int[] newArray = new int[array.length - 1];
        for (int i = 0; i < array.length; i++) {
            if (i < index) {
                newArray[i] = array[i];
            } else {
                if (i == array.length - 1) {
                    break;
                }
                newArray[i] = array[i + 1];
            }
        }
        array = newArray;
        System.out.println(Arrays.toString(newArray));
        return newArray;
    }
    //Them 1 phan tu vao mang
    static int[] addItem(int item, int[] array){
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = item;
        System.out.println(Arrays.toString(newArray));
        return newArray;
    }
    //Tim index cua phan tu
    static int findIdexByValue(int value, int[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value){
                System.out.println(i);
            }
        }
        return -1;
    }
}
