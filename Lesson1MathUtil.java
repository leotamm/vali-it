package ee.bcs.valiiit;

import java.util.Scanner;

public class Lesson1MathUtil {
    private String test;

    public Lesson1MathUtil(String test) {
        this.test = test;
    }

    public static void main(String[] args) {

        System.out.println("Sisesta funktsioon: ");
        Scanner sc_f = new Scanner(System.in);
        String funktsioon = sc_f.nextLine();

        switch (funktsioon) {
            case "min2":
                System.out.print("Sisesta esimene number: ");
                Scanner sc_x = new Scanner(System.in);
                int x = sc_x.nextInt();
                System.out.print("Sisesta teine number: ");
                Scanner sc_y = new Scanner(System.in);
                int y = sc_y.nextInt();
                System.out.print("Väiksem number on: " + min2(x, y));
                break;
            case "min3":
                System.out.print("Sisesta esimene number: ");
                Scanner sc_x1 = new Scanner(System.in);
                int x1 = sc_x1.nextInt();
                System.out.print("Sisesta teine number: ");
                Scanner sc_y1 = new Scanner(System.in);
                int y1 = sc_y1.nextInt();
                System.out.print("Sisesta kolmas number: ");
                Scanner sc_z = new Scanner(System.in);
                int z = sc_z.nextInt();
                System.out.print("Väiksem number on: " + min3(x1, y1, z));
                break;
            case "max2":
                System.out.print("Sisesta esimene number: ");
                Scanner sc_x2 = new Scanner(System.in);
                int x2 = sc_x2.nextInt();
                System.out.print("Sisesta teine number: ");
                Scanner sc_y2 = new Scanner(System.in);
                int y2 = sc_y2.nextInt();
                System.out.println("Suurem number on: " + max2(x2, y2));
                break;
            case "isEven":
                System.out.print("Sisesta number: ");
                Scanner scanner_x3 = new Scanner(System.in);
                int x3 = scanner_x3.nextInt();
                System.out.println(isEven(x3));
                break;
            case "abs":
                System.out.print("Sisesta number: ");
                Scanner sc_x4 = new Scanner(System.in);
                int x4 = sc_x4.nextInt();
                System.out.println("Absoluutväärtus: " + abs(x4));
                break;
            default:
                System.out.println("Pole sellist funktsiooni");
                break;
        }


        Scanner scanner = new Scanner(System.in);
        Lesson1MathUtil lesson1MathUtil1 = new Lesson1MathUtil("test");
        Lesson1MathUtil lesson1MathUtil2 = new Lesson1MathUtil("test2");
        //lesson1MathUtil1.test();
        //lesson1MathUtil2.test();

        Scanner sc = new Scanner(System.in);
        int esimeneNumber = scanner.nextInt();
        int teineNumber = scanner.nextInt();

        //min(esimeneNumber,teineNumber);

        int[][] twoArray = new int[3][4];
    }

    public void test() {
        System.out.println(test);
    }

    public static int esimene() {                        // see ei anna x argumenti funktsioonile ette
        System.out.print("Sisesta esimene number: ");
        Scanner sc_x = new Scanner(System.in);
        int x = sc_x.nextInt();
        return x;
    }

    public static int min2(int a, int b) {
        // TODO tagasta a ja b väikseim väärtus
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    public static int max2(int a, int b) {       //return max(min(a,b),c)
        // TODO tagasta a ja b suurim väärtus
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static boolean isEven(int a) {
        // TODO tagasta true, kui a on paaris arv
        // tagasta false kui a on paaritu arv
        if (a % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int min3(int a, int b, int c) { //return min(min(a,b),c)
        // TODO tagasta a, b ja c väikseim väärtus
        if (a < b && a < c) {
            return a;
        } else if (b < a && b < c) {
            return b;
        } else {
            return c;
        }
    }

    public static int abs(int a) {
        // TODO tagasta a absoluut arv
        if (a > 0) {
            return -a;
        } else {
            return a;
        }
    }

    public static int max3(int a, int b, int c) {
        // TODO tagasta a, b ja c suurim väärtus
        if (a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        } else {
            return c;
        }
    }

}
