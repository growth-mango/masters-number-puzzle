package puzzle;

import java.util.Arrays;
import java.util.Random;

public class PracticeStep2 {
    private static final String TURN_PREFIX = "Turn ";
    private static int turn = 1;


    public static void main(String[] args) {
        System.out.println("재미있는 15 퍼즐!\n");
        turnPrint();
        int[][] numbers = generateNumbers();
        shuffleNumbers(numbers);
        printGrid(numbers);

    }

    // Turn 생성 후 출력
    public static void turnPrint() {
        System.out.println(TURN_PREFIX + turn);
        turn++;
    }

    // 2차원 배열 생성 // 4 * 4 형식 // 1부터 15까지 // 빈칸존재
    public static int[][] generateNumbers() {
        int[][] numbers = new int[4][4];
        int num = 1;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                numbers[i][j] = num <= 15 ? num : 0;
                num++;
            }
        }
        shuffleNumbers(numbers);
        return numbers;
    }

    // 2차원 배열 섞기
    public static void shuffleNumbers(int[][] numbers) {
        Random random = new Random(); // Random 클래스의 인스턴스 rand 생성 // Random 클래스는 임의의 숫자를 생성하는데 사용
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int i1 = random.nextInt(4); // 0에서 3사이의 임의의 정수 생성
                int j1 = random.nextInt(4);

                int temp = numbers[i][j];
                numbers[i][j] = numbers[i1][j1];
                numbers[i1][j1] = temp;
            }
        }
    }

    // 4 * 4 형식으로 출력하기
    public static void printGrid(int[][] numbers) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (numbers[i][j] == 0) {
                    System.out.print("[  ]");
                } else {
                    System.out.printf("[%2d]", numbers[i][j]);
                }
            }
            System.out.println();
        }
    }


}
