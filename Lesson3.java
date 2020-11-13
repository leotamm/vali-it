package ee.bcs.valiiit;

public class Lesson3 {

    public static void main(String[] args) {
        //System.out.println(uusSumma(9, 9));           // uusSumma function

        //int[] myList = {3, 7, 5, 3, 4, 8, 12, 105};         // sum function
        //System.out.println(sum(myList));

        //System.out.println(factorial(7));             // factorial function

        //int[] messedUpList1 = {2, 6, 8, 1};                 // sort lists
        //int[] messedUpList2 = {12, 7, 6, 8};
        //System.out.println(Arrays.toString(sort(messedUpList1)));

        //System.out.println(isPrime(13));

        System.out.println(reverseString("Hello world!"));

    }

    public static int uusSumma(int x, int y) {              // READY
        // TODO liida kokku ja tagasta x ja y väärtus
        int sum = x + y;
        return (int) sum;
    }

    public static int sum(int[] x) {                        // READY
        // TODO liida kokku kõik numbrid massivis x
        int sum = 0;
        int len = x.length;
        for (int y = 0; y < len; y++) {
            sum += x[y];
        }
        return sum;
    }

    public static int factorial(int x) {                    // READY
        // TODO tagasta x faktoriaal.
        // Näiteks
        // x = 5
        // return 5*4*3*2*1 = 24
        int factorial = 1;
        for (int y = 1; y < x; y++) {
            factorial *= y;
        }
        return factorial;
    }

    public static int[] sort(int[] a) {                     // READY
        // TODO sorteeri massiiv suuruse järgi
        // Näiteks {2, 6, 8, 1}
        // Väljund {12, 7, 6, 8}

        int[] newArray = new int[a.length];
        for (int x = 0; x < a.length; x++) {
            int smallestNumber = Integer.MAX_VALUE;
            int smallestIndex = 0;
            for (int y = x; y < a.length; y++) {                // find smallest number in array
                if (a[y] < smallestNumber) {
                    smallestNumber = a[y];
                    smallestIndex = y;
                }
                int tempNumber = smallestNumber;                // assigns the smallest value to new array
                a[smallestIndex] = a[0];
                a[0] = tempNumber;
                newArray[x] = smallestNumber;
                smallestIndex = 0;
            }

        }
        return newArray;                                        // return new list
    }


    public static String reverseString(String a) {          // READY
        // TODO tagasta string tagurpidi
        // Näiteks:
        // a = "Test";
        // return tseT";
        int len = a.length();
        String reverse = "";
        reverse = reverse + a.substring(len-1);
        for (int x = len-1; x > 0; x--) {
            reverse = reverse + a.substring(x-1,x);
        }
    return reverse;
    }

    public static boolean isPrime(int x) {                  // READY
        // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
        int count = 0;
        for (int y = x; y > 0; y--) {
            if (x % y == 0) {
                count++;
            }
        }
        if (count > 2) {
            return false;
        } else {
            return true;
        }
    }
}