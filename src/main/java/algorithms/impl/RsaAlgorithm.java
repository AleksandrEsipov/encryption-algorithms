package algorithms.impl;

import algorithms.Algorithm;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class RsaAlgorithm implements Algorithm {

    @Override
    public String encrypt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сообщение:");
        String message = scanner.nextLine();

        SecureRandom secureRandom = new SecureRandom();
        int messageLength = message.length() * 8;
        BigInteger p = BigInteger.probablePrime(messageLength / 2, secureRandom);
        BigInteger q = BigInteger.probablePrime(messageLength / 2, secureRandom);

        BigInteger m = p.multiply(q);
        Random random = new Random();
        BigInteger publicKey = new BigInteger(String.valueOf(random.nextInt(2147483647)));

        System.out.println("p = " + p);
        System.out.println("q = " + q);
        System.out.println("m = " + m);
        System.out.println("public key = " + publicKey);

        BigInteger byteMessage = new BigInteger(message.getBytes());
        return new String(byteMessage.modPow(publicKey, m).toByteArray());
    }

    @Override
    public String decipher() {
        BigInteger one = new BigInteger("1");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сообщение:");
        String encryptedMessage = scanner.nextLine();
        System.out.println("Введите p:");
        BigInteger p = scanner.nextBigInteger();
        System.out.println("Введите q:");
        BigInteger q = scanner.nextBigInteger();
        System.out.println("Введите публичный ключ:");
        BigInteger publicKey = scanner.nextBigInteger();
        BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));
        BigInteger m = p.multiply(q);
        BigInteger privateKey = publicKey.modInverse(phi);
        BigInteger byteMessage = new BigInteger(encryptedMessage.getBytes()).modPow(privateKey, m);
        return new String(byteMessage.toByteArray());
    }
}
