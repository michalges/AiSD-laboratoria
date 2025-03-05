//public class Main {
//    static void drawChristmasTree(int n) {
//        for (int i = 0; i <= n; i++) {
//            drawPyramid(i, n);
//        }
//    }
//
//    static void drawPyramid(int n, int m) {
//        for (int i = 0; i < n; i++) {
//            printChars(m - 1 - i, '.');
//            printChars(1 + i * 2, 'X');
//            printChars(m - 1 - i, '.');
//            System.out.println();
//        }
//    }
//
//    static void printChars(int x, char c) {
//        for (int j = 0; j < x; j++) {
//            System.out.print(c);
//        }
//    }
//
//    public static void main(String[] args) {
//        drawPyramid(4, 4);
//        drawChristmasTree(4);
//    }
//}