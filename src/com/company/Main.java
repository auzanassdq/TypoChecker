package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Kata> wordList = new ArrayList();
        ArrayList<String> kamusList = new ArrayList();

        Scanner in = new Scanner(System.in);

        System.out.print("Nama file input : ");
        String namaFileInput = in.next();

        System.out.print("Nama file output: ");
        String namaFileOutput = in.next();

        try {
            // Buat object file dgn nama yg sudah di input
            File fileIn = new File(namaFileInput);
//            InputStream fileIn = new FileInputStream(namaFileInput);
            InputStream kamus = new FileInputStream("IndoWordList.txt");

            Scanner readFileIn = new Scanner(fileIn);
            Scanner readKamus = new Scanner(kamus);

            PrintWriter writer = new PrintWriter(namaFileOutput);

            // Scann File Input
            readFileIn.useDelimiter("(\\p{javaWhitespace}|\\.|,)+");
            while (readFileIn.hasNext()){
                String perKata = readFileIn.next();

                Kata kata = new Kata(perKata);
                wordList.add(kata);
            }

            // Scann Kamus
            readKamus.useDelimiter("");
            while (readKamus.hasNext()){
                String kataKamus = readKamus.nextLine();

                kamusList.add(kataKamus);
            }

            // Pengecekan pada file
            for(Kata kata : wordList) {
                for (String db : kamusList ) {
                    if (kata.getKata().equals(db)) {
                        kata.setHasNoPair(false);
                    }
                }

                if (kata.isHasNoPair()) {
                    writer.printf("*%s* ", kata.getKata());
                } else {
                    writer.printf("%s ", kata.getKata());
                }
            }

            readFileIn.close();
            readKamus.close();
            writer.close();

        } catch (Exception e) {
            System.out.print("File tidak ditemukan..");
        }
    }

}
