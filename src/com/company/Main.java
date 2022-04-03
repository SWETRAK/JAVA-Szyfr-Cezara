package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        //odczyt z pliku niezaszyfrowanej wiadomości, szyfrowanie i zapis do pliku zaszyfrowaniej wiadomości
        String niezaszyfrowany = prostyOdczyt("do zaszyfrowania.txt");
        String zaszyfrowany = cezar(niezaszyfrowany, 2);
        prostyZapis("zaszyfrowany.txt", zaszyfrowany);


        // odszyfrowanie i wyświetlenie odszyfrowanie wiadowmości
        String doOdszyfrowania = prostyOdczyt("zaszyfrowany.txt");
        String odszyfrowany = cezarwroc(doOdszyfrowania, 2);
        System.out.println("odszyfrowany = " + odszyfrowany);

    }

    public static void prostyZapis(String nazwaPliku, String dane) {
        File file = new File(nazwaPliku);
        try {
            FileWriter fileWriter = new FileWriter(file,false);
            fileWriter.append(dane);
            fileWriter.append('\n');
            fileWriter.close();
        } catch (IOException ex) {
            System.err.println(ex.getCause());
        }
    }

    public static String prostyOdczyt( String nazwaPliku) {

        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(nazwaPliku)))) {
            String linia = null;
            String result = "";
            while ((linia = bufferedReader.readLine()) != null) {
                result += linia + "\n";
            }
            bufferedReader.close();
            return result;
        }
        catch (FileNotFoundException ex) {
            System.out.println("Pliku nie odnaleziono!");
            System.err.println(ex.getCause());
        }
        catch (IOException ex) {
            System.out.println("Błąd odczytu pliku spowodowany:");
            System.err.println(ex.getCause());
        }
        return "";
    }

    public static String cezar(String str, int przesuniecie){        //metoda szyfrujaca;
        char x[] = str.toCharArray();

        for(int i=0; i != x.length; i++){
            int n = x[i];
            n += przesuniecie;
            x[i] = (char)n;
        }
        return new String(x);
    }

    public static String cezarwroc(String str, int przesuniecie){     //metoda deszyfrujaca;
        char x[] = str.toCharArray();

        for(int i=0; i != x.length; i++) {
            int n = x[i];
            n -= przesuniecie;
            x[i] = (char)n;
        }
        return new String(x);
    }

}
