package puzzle;

import java.util.*;

public class Step2 {
    private static final String TURN_PREFIX = "Turn ";
    private static int turn = 1;

    public static void main(String[] args) {
        System.out.println("재미있는 15 퍼즐!\n");
        turnNumber();
        System.out.println(Arrays.deepToString(generateNumbers()));
        int[][] numbers = generateNumbers();
        shuffleGrid(numbers);
        printGrid(numbers);

    }

    // turn의 숫자를 1부터 증가시키기
    public static void turnNumber() {
        System.out.println(TURN_PREFIX + turn);
        turn++;
    }

    // 랜덤 숫자 생성하기 // 1부터 15까지 // [] 포함 // 4 * 4 형식 //
//    public static List<Integer> generateNumbers(){
//        List<Integer> numbers = new ArrayList<>();
//        for (int i = 1; i <= 15 ; i++) {
//            numbers.add(i);
//        }
//        Collections.shuffle(numbers);
//        return numbers;
//    }
    // 1부터 15까지 숫자 생성 후 배치
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
    private static void shuffleGrid(int[][] grid){
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int i1 = rand.nextInt(4);
                int j1 = rand.nextInt(4);

                int temp = grid[i][j];
                grid[i][j] = grid[i1][j1];
                grid[i1][j1] = temp ;
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


    // 입력받은 숫자와 공백 교환하기


    // 오름차순으로 정렬되었는지 확인하기





}
