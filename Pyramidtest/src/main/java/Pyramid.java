import java.util.ArrayList;

public class Pyramid {

    private int[] val;

    public Pyramid(int... values) {
        this.val = new int[values.length];
        this.val = values;
        create(val);
    }

    private void create(int[] arr) {

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {

                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        try {
            if (arr.length == 6) {
                int n = 1;
                int pos = 0;
                int dev = 2;
                int counter = 0;

                while (n < 4) {
                    pos += dev;
                    ArrayList<Integer> intArr = new ArrayList<Integer>(5);
                    for (int i = 0; i < 5; i++) {
                        intArr.add(0);
                    }

                    for (int i = 0; i < n; i++) {
                        intArr.set(pos, arr[counter]);
                        pos += 2;
                        counter++;
                    }
                    pos = 0;
                    dev--;
                    n++;

                    System.out.println(intArr.toString());
                }
            } else if (arr.length == 3) {
                int n = 1;
                int pos = 0;
                int dev = 1;
                int counter = 0;

                while (n < 3) {
                    pos += dev;
                    ArrayList<Integer> intArr = new ArrayList<Integer>(3);
                    for (int i = 0; i < 3; i++) {
                        intArr.add(0);
                    }

                    for (int i = 0; i < n; i++) {
                        intArr.set(pos, arr[counter]);
                        pos += 2;
                        counter++;
                    }
                    pos = 0;
                    dev--;
                    n++;

                    System.out.println(intArr.toString());
                }
            } else if (arr.length == 10) {
                int n = 1;
                int pos = 0;
                int dev = 3;
                int counter = 0;

                while (n < 5) {
                    pos += dev;
                    ArrayList<Integer> intArr = new ArrayList<Integer>(7);
                    for (int i = 0; i < 7; i++) {
                        intArr.add(0);
                    }

                    for (int i = 0; i < n; i++) {
                        intArr.set(pos, arr[counter]);
                        pos += 2;
                        counter++;
                    }
                    pos = 0;
                    dev--;
                    n++;

                    System.out.println(intArr.toString());
                }
            } else {
                throw new Exception("wrong values");
            }
        } catch (Exception e){
            System.out.println("Invalid count of values");
        }
    }

    public static void main(String[] args) {
        Pyramid p = new Pyramid(4, 1, 2, 6, 5, 3, 8, 7, 9, 10);
    }
}
