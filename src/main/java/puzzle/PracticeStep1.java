package puzzle;

import java.util.*;

public class PracticeStep1 {
    private static final String TURN_PREFIX = "Turn ";
    private static int turn = 1;

    public static void main(String[] args) {
        System.out.println("간단 숫자 퍼즐");
        List<Integer> numbers = generateNumbers();

        while (true) { // 정렬이 될 때 까지 반복 // true 될 때 까지 반복
            turnNumber(); // Turn 1
            System.out.println(numbers); // [1~8]
            int[] inputNumbers = getNumbers();
            swapNumbers(numbers, inputNumbers[0], inputNumbers[1]); // 교환할 두숫자 > 1,2
            if (isSorted(numbers)){ // 정렬 되었다면
                System.out.println("축하합니다! " + turn + "턴만에 퍼즐을 완성하셨습니다!");
                break;
            }
        }
    }

    // Turn Number를 증가시킴
    public static void turnNumber() {
        System.out.println(TURN_PREFIX + turn);
        turn++;
    }

    // 이 메서드의 리턴 값을 다른 곳에서도 사용이 되어야만 함
    // 1-8 무작위의 숫자를 출력하는 메서드
    public static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers); // 무작위로 숫자 섞기
        return numbers;
    }

    // 두 개의 숫자 입력받기 (쉼표로 구분)
    //    - 1 ~ 8 사이의 두 숫자 입력받기
    //    - 쉼표 기준으로 입력받기
    //    - 쉼표 다음에 스페이스 한 칸 허용
    //    - 정상적인 입력 아닐 경우 재입력 받기 (숫자 X, 1-8 범위가 아니거나, 숫자를 하나만 입력하거나 등)
    public static int[] getNumbers() {
        Scanner sc = new Scanner(System.in); // 사용자 입력 받기 위해 Scanner 클래스 주입
        int[] numbersInt = new int[2]; // 정수형 배열 생성
        while (true) { // 정상 입력을 받을 떄 까지 반복되어야 하므로
            try {
                System.out.println("교환할 두 숫자를 입력>");
                String[] numbersStr = sc.nextLine().split(","); // 쉼표로 구분된 배열, nextLine의 반환형이 String 임

                // 입력받은 numbersStr의 조건절
                if (numbersStr.length == 2) { // 숫자 두개를 제대로 입력했다면
                    numbersInt[0] = Integer.parseInt(numbersStr[0].trim()); // 입력받은 String 타입을 int 타입에 대입
                    numbersInt[1] = Integer.parseInt(numbersStr[1].trim());

                    // 대입 받은 후 1 ~ 8의 범위에 있는지 확인하기
                    if (numbersInt[0] >= 1 && numbersInt[0] <= 8 && numbersInt[1] >= 1 && numbersInt[1] <= 8) {
                        break; // 범위에 있다면 조건에 모두 만족하니 break로 빠져나가기
                    }
                }
                // if문이 false면 그러니까 입력 형식에 맞지 않다면
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
            }
        }
        return numbersInt;
    }

    // 숫자 교환
    // 입력받은 숫자 중, 첫번째 숫자와 두번째 숫자를 교환한다.
    // 그럼 메소드가 생성될 때, 숫자 배열(8개의 숫자), 첫 번째 숫자, 두 번째 숫자가 인자로 있어야함
    public static void swapNumbers(List<Integer> numbers, int number1, int number2) {
        int index1 = numbers.indexOf(number1);
        int index2 = numbers.indexOf(number2);

        numbers.set(index1, number2);
        numbers.set(index2, number1);
    }

    // 오름차순으로 정렬되었는지 확인하기
    public static boolean isSorted(List<Integer> numbers) {
        // i와 i+1 요소를 비교할 것이기 때문이 마지막 요소를 초과하지 않게끔 size()-1 설정
        for (int i = 0; i < numbers.size() - 1; i++) {
            // 만약 if(numbers.get(i) < numbers.get(i+1) {return true;}로 바꾸면
            // 첫 번째 요소가 두 번째 요소보다 작으면 즉시 true 를 반환하기에 전체 리스트 검증이 불가하다.
            // for문을 돌면서 if가 true이면 즉시 if 문을 빠져나가기에 오름차순 검증을 하지 못한다.
            // 리스트가 오름차순으로 정렬이 되었는지 확인하려면 리스트 전체를 순회를 돌아야 한다.
            // 즉 for문을 다 돌때 까지 계속 false 를 내뱉으면서 로직을 검증해야 한다.
            if (numbers.get(i) > numbers.get(i + 1)) { // true 면이 조건 { // 오름차순 정렬 안되었으면 false 내뱉기
                return false;
            }
        }
        return true;
    }


}
