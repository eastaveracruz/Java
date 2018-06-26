package lessons.Файлы_и_директории;

import java.io.*;

public class Запись_и_чтение_из_файла {

    private static String filePath = "c:/temp.txt";

    public static void main(String[] args) throws IOException {

//        абстракция для работы с директориями и файлами
        File file = new File(filePath);

//        если файла нет, то создаем его
        if (!file.exists())
            file.createNewFile();

//          СПОСОБ 1

//        пишем в файл
        FileWriter writer = new FileWriter(file);
        writer.write("str1\n");
        writer.write("str2\n");
//        закрываем
//        writer.close();

//        читаем из файла
//        читает массив байт
        FileReader reader = new FileReader(file);
        char[] chars = new char[20];
        reader.read(chars);
        System.out.printf(String.valueOf(chars));


//          СПОСОБ 2

//        пишем в файл
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("str3");
        bufferedWriter.newLine();
        bufferedWriter.write("str4");
        bufferedWriter.newLine();
        bufferedWriter.close();

//        читаем из файла
//        читает построчно
        BufferedReader bufferedReader = new BufferedReader(reader);
        while (bufferedReader.ready())
            System.out.println(bufferedReader.readLine());

        bufferedReader.close();
        file.delete();
    }

}
