import algorithms.Algorithm;
import algorithms.impl.RsaAlgorithm;
import algorithms.impl.VigenereAlgorithm;
import exceptions.InternalApplicationException;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Algorithm> algorithms = Map.of(
                1, new VigenereAlgorithm(),
                2, new RsaAlgorithm()
        );
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите алгоритм:\n1. Vegenere\n2. RSA");
        int algorithmId = scanner.nextInt();
        System.out.println("Выберите действие:\n1. Зашифровать\n2. Расшифровать");
        int actionId = scanner.nextInt();
        Algorithm algorithm = algorithms.get(algorithmId);
        String result;
        switch (actionId) {
            case 1: {
                result = algorithm.encrypt();
                break;
            }
            case 2: {
                result = algorithm.decipher();
                break;
            }
            default:
                throw new InternalApplicationException("Unknown action id");
        }
        System.out.println(result);
    }
}
