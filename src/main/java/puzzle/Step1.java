package puzzle;

import java.util.*;

// 원래보다 간단한 기능의 숫자퍼즐 구현
public class Step1 {
    private static final String TURN_PREFIX = "Turn ";
    private static int turn = 1;

    public static void main(String[] args) {
        System.out.println("간단 숫자 퍼즐");
        //임시 테스트
        turnPrint();
        List<Integer> radomNumbers = generateNumbers();
        System.out.println(radomNumbers);
        int[] inputNumbers = getUserInput();
        System.out.println(Arrays.toString(inputNumbers));
        swapNumbers(radomNumbers, inputNumbers[0], inputNumbers[1]);
        System.out.println(radomNumbers);

    }

    public static void turnPrint() {
        System.out.println(TURN_PREFIX + turn);
        turn++;
    }

    public static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers;
    }

    public static int[] getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int[] inputNumbers = new int[2];
        while (true) {
            System.out.println("교환할 두 숫자를 입력>");
            String inputStr = scanner.nextLine();
            try {
                String[] parts = inputStr.split(",");
                if (parts.length == 2) {
                    inputNumbers[0] = Integer.parseInt(parts[0].trim());
                    inputNumbers[1] = Integer.parseInt(parts[1].trim());
                    if (inputNumbers[0] >= 1 && inputNumbers[0] <= 8 && inputNumbers[1] >= 1 && inputNumbers[1] <= 8) {
                        break;
                    }
                }
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            }
        }
        return inputNumbers;
    }

    public static void swapNumbers(List<Integer> numbers, int number1, int number2) {
        int index1 = numbers.indexOf(number1);
        int index2 = numbers.indexOf(number2);

        numbers.set(index1, number2); // set(index, 요소);
        numbers.set(index2, number1);
    }

    public static boolean isSorted(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > numbers.get(i + 1)) { // 오름차순이 아닐경우  // [1,2,3,4,5,6,7,8]
                return false;
            }
        }
        return true;
    }

}
