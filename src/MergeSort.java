
public class MergeSort {

    private static Object[] array;
    private static Object[] tempMergArr;
    private static int length;

    /**
     * Ordena una lista de busqueda binaria utilizando Merge Sort
     * @param list Lista a ordenar
     */
    public static void sort(ArrayListBinary list) {
        array = list.toArray();
        tempMergArr = new Object[list.size];
        doMergeSort(0, list.size - 1);

    }

    private static void doMergeSort(int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = (higherIndex + lowerIndex) / 2;
            doMergeSort(lowerIndex, middle);
            doMergeSort(middle + 1, higherIndex);
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private static void mergeParts(int lowerIndex, int middle, int higherIndex) {
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            Comparable tempI = ((Comparable) tempMergArr[i]);
            Comparable tempJ = ((Comparable) tempMergArr[j]);

            if (tempI.compareTo(tempJ) <= 0) {
                array[k] = tempMergArr[i];
                i++;
            }
            else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
    }
}
