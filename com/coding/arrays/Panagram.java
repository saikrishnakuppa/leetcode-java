package com.coding.arrays;

public class Panagram {
    public static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String missingLetters(String input) {
        String result = "";

        for(Character c : ALPHABET.toCharArray()) {
            if(input.toLowerCase().indexOf(c) == -1)
                result += c;
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "hfkvmkeyduluvqggqmbheotikcjpajmdlzfipbqgvkexcdnoxpotimoxakoidzqsscvlcmmfvlgdqttbbrhisgunvlugggfpmubitaorhmllpqcvqxgjsabygebakcpzibhhnpfxnhcxzjtjghettfkhgthopjjuteysqhteudugfqjcobkyanthvrqxyyikvepcelszfsxdlrmctaekdxegjjlioyuqkgdecazplikvimihclammemhbdnxlptzndctemyotcsnysumadhuagxlbeodkqypehsfjxqjreekkdjafemzkifymyityifmvyqojy";
        System.out.println("Missing Letters: " + Panagram.missingLetters(input));
    }
}
