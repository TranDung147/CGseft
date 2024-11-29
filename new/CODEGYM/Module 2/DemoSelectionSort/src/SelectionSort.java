import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class SelectionSort {
    public void selectionSort(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            int v_min = a[i];
            for (int j = i; j < a.length; j++) {
                if (a[j] < v_min) {
                    v_min = a[j];
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }

    public void swap(int a[], int i, int min) {
        int temp = a[i];
        a[i] = a[min];
        a[min] = temp;
    }
}
