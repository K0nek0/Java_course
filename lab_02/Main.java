package lab_02;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Задания:\n1. Наибольшая подстрока без повторяющихся символов"+
        "\n2. Объединить два отсортированных массива"+
        "\n3. Максимальная сумма подмассива"+
        "\n4. Повернуть массив на 90 градусов по часовой стрелке"+
        "\n5. Найти пару элементов в массиве, сумма которых равна заданному числу"+
        "\n6. Сумма всех элементов в двумерном массиве"+
        "\n7. Максимальный элемент в каждой строке двумерного массива"+
        "\n8. Повернуть двумерный массив на 90 градусов против часовой стрелки");
        System.out.print("Введите номер задания (1-8): ");

        switch (scanner.nextInt()) {
            case 1:
                longestSubstringWithoutRepeating();
                break;
            case 2:
                mergeSortedArrays();
                break;
            case 3:
                maxSubarraySum();
                break;
            case 4:
                rotateArray90DegreesClockwise();
                break;
            case 5:
                findPairWithTargetSum();
                break;
            case 6:
                sumOfArray();
                break;
            case 7:
                maxElementInEachRow();
                break;
            case 8:
                rotateArray90DegreesCounterClockwise();
                break;
            default:
                System.out.println("Ошибка: такого задания не было");
        }
        scanner.close();
    }

    // Задача 1: Наибольшая подстрока без повторяющихся символов
    public static void longestSubstringWithoutRepeating() {
        System.out.print("Введите строку: ");
        String input = scanner.next();
        String longestSubstring = "";
        Set<Character> set = new HashSet<>();
        int start = 0;
        for (int end = 0; end < input.length(); end++) {
            while (set.contains(input.charAt(end))) {
                set.remove(input.charAt(start));
                start++;
            }
            set.add(input.charAt(end));
            if (end - start + 1 > longestSubstring.length()) {
                longestSubstring = input.substring(start, end + 1);
            }
        }
        System.out.println("Наибольшая подстрока без повторяющихся символов: " + longestSubstring);
    }

    // Задача 2: Объединить два отсортированных массива
    public static void mergeSortedArrays() {
        System.out.print("Введите размер первого массива: ");
        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        System.out.print("Введите элементы первого массива: ");
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }

        System.out.print("Введите размер второго массива: ");
        int m = scanner.nextInt();
        int[] arr2 = new int[m];
        System.out.print("Введите элементы второго массива: ");
        for (int i = 0; i < m; i++) {
            arr2[i] = scanner.nextInt();
        }

        int[] mergedArray = new int[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }
        while (i < n) {
            mergedArray[k++] = arr1[i++];
        }
        while (j < m) {
            mergedArray[k++] = arr2[j++];
        }

        System.out.println("Объединенный отсортированный массив: " + Arrays.toString(mergedArray));
    }

    // Задача 3: Максимальная сумма подмассива
    public static void maxSubarraySum() {
        System.out.print("Введите размер массива: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.print("Введите элементы массива: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int maxSum = arr[0];
        int currentSum = arr[0];
        for (int i = 1; i < n; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println("Максимальная сумма подмассива: " + maxSum);
    }

    // Задача 4: Повернуть массив на 90 градусов по часовой стрелке
    public static void rotateArray90DegreesClockwise() {
        System.out.print("Введите размерность массива (n x n): ");
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int[][] rotatedArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedArr[j][n - 1 - i] = arr[i][j];
            }
        }

        System.out.println("Массив после поворота на 90 градусов по часовой стрелке:");
        for (int[] row : rotatedArr) {
            System.out.println(Arrays.toString(row));
        }
    }

    // Задача 5: Найти пару элементов в массиве, сумма которых равна заданному числу
    public static void findPairWithTargetSum() {
        System.out.print("Введите размер массива: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.print("Введите элементы массива: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("Введите целевое число: ");
        int target = scanner.nextInt();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                System.out.println("Пара: (" + complement + ", " + arr[i] + ")");
                return;
            }
            map.put(arr[i], i);
        }
        System.out.println("Пара не найдена");
    }

    // Задача 6: Сумма всех элементов в двумерном массиве
    public static void sumOfArray() {
        System.out.print("Введите количество строк: ");
        int rows = scanner.nextInt();
        System.out.print("Введите количество столбцов: ");
        int cols = scanner.nextInt();
        int[][] arr = new int[rows][cols];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int sum = 0;
        for (int[] row : arr) {
            for (int num : row) {
                sum += num;
            }
        }

        System.out.println("Сумма всех элементов: " + sum);
    }

    // Задача 7: Максимальный элемент в каждой строке двумерного массива
    public static void maxElementInEachRow() {
        System.out.print("Введите количество строк: ");
        int rows = scanner.nextInt();
        System.out.print("Введите количество столбцов: ");
        int cols = scanner.nextInt();
        int[][] arr = new int[rows][cols];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int[] maxElements = new int[rows];
        for (int i = 0; i < rows; i++) {
            int max = arr[i][0];
            for (int j = 1; j < cols; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
            maxElements[i] = max;
        }

        System.out.println("Максимальные элементы в каждой строке: " + Arrays.toString(maxElements));
    }

    // Задача 8: Повернуть двумерный массив на 90 градусов против часовой стрелки
    public static void rotateArray90DegreesCounterClockwise() {
        System.out.print("Введите размерность массива (n x n): ");
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int[][] rotatedArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedArr[n - 1 - j][i] = arr[i][j];
            }
        }

        System.out.println("Массив после поворота на 90 градусов против часовой стрелки:");
        for (int[] row : rotatedArr) {
            System.out.println(Arrays.toString(row));
        }
    }
}
