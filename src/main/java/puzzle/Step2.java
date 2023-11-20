package puzzle;

import java.util.*;

public class Step2 {
    private static final String TURN_PREFIX = "Turn ";
    private static int turn = 1;

    public static void main(String[] args) {
        System.out.println("재미있는 15 퍼즐!\n");
        int[][] numbers = generateNumbers();

        while (true) {
            turnNumber(); // Turn 1
            printGrid(numbers);

            int inputNumber = getNumber();
            swapWithEmptySpace(numbers, inputNumber);
            if (isSorted(numbers)) {
                System.out.println("축하합니다! " + turn + "턴만에 퍼즐을 완성하셨습니다.");
            }
        }
    }

    // turn의 숫자를 1부터 증가시키기
    public static void turnNumber() {
        System.out.println(TURN_PREFIX + turn);
        turn++;
    }

    public static int[][] generateNumbers() {
        int[][] grid = new int[4][4];
        int num = 1;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = num <= 15 ? num : 0;
                num++;
            }
        }
        shuffleGrid(grid);
        return grid;
    }

    // 2차원 배열 섞기
    private static void shuffleGrid(int[][] grid) {
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int i1 = rand.nextInt(4);
                int j1 = rand.nextInt(4);

                int temp = grid[i][j];
                grid[i][j] = grid[i1][j1];
                grid[i1][j1] = temp;
            }
        }
    }

    // 2차원 배열 출력하기
    public static void printGrid(int[][] grid) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j] == 0) {
                    System.out.print("[  ]");
                } else {
                    System.out.printf("[%2d]", grid[i][j]); // grid[0][0] grid[0][1] grid[0][2] grid[0][3] println ...
                }
            }
            System.out.println();
        }
    }


    // 사용자에게 숫자 입력받기
    // 1개의 숫자 입력받기 (하나의 숫자가 아니거나, 숫자가 아니거나, 1-15 넘어가면 예외처리)
    public static int getNumber() {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            try {
                System.out.print("숫자 입력> ");
                number = sc.nextInt();
                if (number >= 1 && number <= 15) {
                    break;
                }
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
            }
        }
        return number;
    }

    // 입력받은 숫자와 공백 교환하기
    public static boolean swapWithEmptySpace(int[][] grid, int number) {
        int[] numberPosition = findPosition(grid, number);
        int[] emptySpacePosition = findPosition(grid, 0);

        // 교환 가능 여부 확인하기
        if (isAdjacent(numberPosition, emptySpacePosition)) {
            // 숫자와 빈 칸 교환
            grid[numberPosition[0]][numberPosition[1]] = 0;
            grid[emptySpacePosition[0]][emptySpacePosition[1]] = number;
            return true;
        }
        return false;
    }

    // 숫자의 위치 찾기
    private static int[] findPosition(int[][] grid, int number) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == number) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // 두 위치가 상하좌우로 인접해 있는지 확인
    private static boolean isAdjacent(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]) == 1;

    }

    // 오름차순으로 정렬되었는지 확인하기
    public static boolean isSorted(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length - 1; j++) {
                if (grid[i][j] > grid[i][j + 1]) { // 1 , 2, 3, 4 // 첫 번째 숫자가 가장 작아야 함
                    return false;
                }
            }
        }
        return true;
    }
}
