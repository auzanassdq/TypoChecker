package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] Database = {"dunia", "ini", "indah", "yang", "bebas", "luas"};
        ArrayList<Kata> wordList = new ArrayList();

        Scanner in = new Scanner(System.in);

        System.out.print("Nama file input : ");
        String namaFileInput = in.next();

        System.out.print("Nama file output: ");
        String namaFileOutput = in.next();

        try {
            // Buat object file dgn nama yg sudah di input
            File fileIn = new File(namaFileInput);
            Scanner reader = new Scanner(fileIn);
            PrintWriter writer = new PrintWriter(namaFileOutput);

            reader.useDelimiter(" ");
            while (reader.hasNext()){
                String perKata = reader.next();

                Kata kata = new Kata(perKata);
                wordList.add(kata);
            }

            for(Kata kata : wordList) {
                for (String db : Database ) {
                    if (kata.getKata().equals(db)) {
                        kata.setHasNoPair(false);
                    }
                }

                if (kata.isHasNoPair()) {
                    writer.printf("/%s/ ", kata.getKata());
                } else {
                    writer.printf("%s ", kata.getKata());
                }
            }

            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.print("File tidak ditemukan..");
        }
    }
}
