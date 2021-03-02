import algorithms.Algorithm;
import exceptions.InternalApplicationException;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Algorithm> algorithms = Map.of(
                1, null,
                2, null,
                3, null
        );
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите алгоритм: ");
        int algorithmId = scanner.nextInt();
        System.out.println("Выберите действие:\n1. Зашифровать\n2. Расшифровать");
        int actionId = scanner.nextInt();
        Algorithm algorithm = algorithms.get(algorithmId);
        switch (actionId) {
            case 1: {
                algorithm.encrypt();
                break;
            }
            case 2: {
                algorithm.decipher();
                break;
            }
            default:
                throw new InternalApplicationException("Unknown action id");
        }


    }
}
