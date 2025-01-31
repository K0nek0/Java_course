package lab_01;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Задания:\n1. Сиракузская последовательность\n2. Сумма ряда\n3. Ищем клад\n4. Логистический максимин\n5. Дважды чётное число");
        System.out.print("Введите номер задания (1-5): ");

        switch (scanner.nextInt()) {
            case 1:
                syracuseSequence();
                break;
            case 2:
                rowSum();
                break;
            case 3:
                findTreasure();
                break;
            case 4:
                findOptimalPath();
                break;
            case 5:
                twiceEven();
                break;
            default:
                System.out.println("Ошибка: такого задания не было");
        }
        scanner.close();
    }

    // Задание 1
    private static void syracuseSequence() {
        System.out.print("Введите натуральное число: ");
        int n = scanner.nextInt();
        int count = 0;

        while (n != 1) {
            n = (n % 2 == 0) ? n / 2 : 3 * n + 1;
            count++;
        }

        System.out.println("Потребовалось " + count + " шагов");
    }

    // Задание 2
    private static void rowSum() {
        System.out.print("Введите количество чисел в знакочередующемся ряде: ");
        int size = scanner.nextInt();
        int sum = 0;
        boolean isMinus = false;

        System.out.println("Введите " + size + " чисел:");

        for (int i = 0; i < size; i++) {
            int number = scanner.nextInt();
            sum += isMinus ? -number : number;
            isMinus = !isMinus;
        }

        System.out.println("Сумма ряда: " + sum);
    }

    // Задание 3
    private static void findTreasure() {
        System.out.print("Введите координату x клада: ");
        int xGoal = scanner.nextInt();
        System.out.print("Введите координату y клада: ");
        int yGoal = scanner.nextInt();

        int shortestPath = 0, x = 0, y = 0;
        boolean isGoalReached = false;

        System.out.println("Введите указания:");

        String direction = scanner.next();
        int steps = scanner.nextInt();

        while (!direction.equals("стоп")) {
            if (x == xGoal && y == yGoal) {
                isGoalReached = true;
            }

            switch (direction) {
                case "север":
                    y += steps;
                    break;
                case "юг":
                    y -= steps;
                    break;
                case "запад":
                    x -= steps;
                    break;
                case "восток":
                    x += steps;
                    break;
            }

            if (!isGoalReached) {
                shortestPath++;
            }

            direction = scanner.next();
            if (!direction.equals("стоп")) {
                steps = scanner.nextInt();
            }
        }

        System.out.println("Минимальное количество указаний: " + shortestPath);
    }

    // Задание 4
    private static void findOptimalPath() {
        System.out.print("Введите количество дорог: ");
        int roadCount = scanner.nextInt();
        int optimalHeight = Integer.MIN_VALUE;
        int optimalRoad = 0;

        for (int i = 1; i <= roadCount; i++) {
            System.out.print("Введите количество туннелей для " + i + " дороги: ");
            int tunnelCount = scanner.nextInt();
            int minTunnel = Integer.MAX_VALUE;

            System.out.println("Введите высоту каждого туннеля:");

            for (int j = 0; j < tunnelCount; j++) {
                int currentTunnel = scanner.nextInt();
                minTunnel = Math.min(minTunnel, currentTunnel);
            }

            if (minTunnel > optimalHeight) {
                optimalHeight = minTunnel;
                optimalRoad = i;
            }
        }

        System.out.printf("Оптимальные дорога и высота грузовика: %d %d%n", optimalRoad, optimalHeight);
    }

    // Задание 5
    private static void twiceEven() {
        System.out.print("Введите положительное трёхзначное число: ");
        int number = scanner.nextInt();
        int sum = 0, product = 1;

        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            product *= digit;
            number /= 10;
        }

        if (sum % 2 == 0 && product % 2 == 0) {
            System.out.println("Это дважды чётное число");
        } else {
            System.out.println("Это не дважды чётное число");
        }
    }
}
