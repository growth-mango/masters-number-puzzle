package puzzle;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

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

    // 사용자에게 숫자 입력받기
    public static int getNumber() {
        Scanner sc = new Scanner();
        int number;
        while (true) {
            try {
                System.out.print("숫자 입력> ");
                number = sc.nextInt();
                if (number >= 1 && number <= 15) {
                    break;
                }
                System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
            }
        }
        return number;
    }

    // 숫자 교환
    public static boolean swapWithEmptySpace(int[][] numbers, int number) {
        // 사용자가 입력한 숫자의 위치를 저장
        int[] numberPosition = findPosition(numbers, number);
        // 빈 칸의 위치를 찾아 저장, generateNumbers 에서 빈칸은 0으로 표시되니 0으로 인자 전달
        int[] emptySpacePosition = findPosition(numbers, 0);

        // 입력받은 숫자와 빈 칸이 인접해 있다면
        if (isAdjacent(numberPosition, emptySpacePosition)) {
            // 교환 시작
            // 1. 입력한 숫자의 위치를 빈 칸으로 설정
            numbers[numberPosition[0]][numberPosition[1]] = 0;
            // 2. 빈칸의 위치에 사용자가 입력한 숫자를 배치
            numbers[emptySpacePosition[0]][emptySpacePosition[1]] = number;
            return true;
        }
        return false;
    }

    // 특정 숫자가 있는 그리드 내의 위치 찾기
    private static int[] findPosition(int[][] numbers, int number) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                // number[i][j] 인덱스의 값이 nuber(입력값) 과 같다면
                if (numbers[i][j] == number) {
                    // int[] 자료형에 i, j 를 넣어버려라
                    return new int[]{i, j};
                }
            }
        }
        // 숫자를 찾지 못한 경우 -1, -1 을 반환
        return new int[]{-1, -1};
    }

    // 두 위치가 상하좌우로 인접해 있는지 확인
    // 두 위치의 행 차이와 열 차이의 절대값을 합하여 이 값이 1이면 두 위치는 서로 인접해 있다고 판단
    private static boolean isAdjacent(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0] - pos2[0] + Math.abs(pos1[1] - pos2[1]) == 1;
    }

    // 오름차순 정렬 확인
    public static boolean isSorted(int[][] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length - 1; j++) {
                if (numbers[i][j] > numbers[i][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}





}
