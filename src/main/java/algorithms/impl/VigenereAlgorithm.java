package algorithms.impl;

import algorithms.Algorithm;
import exceptions.InternalApplicationException;

import java.util.Scanner;

public class VigenereAlgorithm implements Algorithm {
    private static String alphabet = "abcdefghijklmnopqrstubwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ,.!?-";

    @Override
    public String encrypt() {
        String message = getMessage();
        String key = getKey();
        String result = "";
        for (int i = 0; i < message.length(); i++) {
            result+=alphabet.charAt((charPosition(message.charAt(i)) + charPosition(key.charAt(i % key.length()))) % alphabet.length());
        }
        return result;
    }

    @Override
    public String decipher() {
        String message = getMessage();
        String key = getKey();
        String result = "";
        for (int i = 0; i < message.length(); i++) {
            result+=alphabet.charAt((charPosition(message.charAt(i)) + alphabet.length() - charPosition(key.charAt(i % key.length()))) % alphabet.length());
        }
        return result;
    }

    private int charPosition(char c) {
        int position = alphabet.indexOf(c);
        if (position < 0) {
            throw new InternalApplicationException("Symbol " + c + " not found");
        }
        return position;
    }

    private String getMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сообщение: ");
        return scanner.nextLine();
    }

    private String getKey() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ключ: ");
        return scanner.nextLine();
    }
}
