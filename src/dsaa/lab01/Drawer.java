package dsaa.lab01;

public class Drawer {
    private static void drawLine(int n, char ch) {
        for (int j = 0; j < n; j++) {
            System.out.print(ch);
        }
    }

    private static void drawSinglePyramid(int n, int m) {
        for (int i = 0; i < n; i++) {
            drawLine(m - 1 - i, '.');
            drawLine(1 + i * 2, 'X');
            drawLine(m - 1 - i, '.');
            System.out.println();
        }
    }

    public static void drawPyramid(int n) {
        drawSinglePyramid(n, n);
    }

    public static void drawChristmassTree(int n) {
        for (int i = 0; i <= n; i++) {
            drawSinglePyramid(i, n);
        }
    }

}