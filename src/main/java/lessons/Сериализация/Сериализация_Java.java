package lessons.Сериализация;

import bin.Pers;

import java.io.*;

public class Сериализация_Java {
    private static String filePath = "e:/temp.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        статические поля не сериализуются!!!
//        поля помеченные transient не сериализуются!!!
//        поля обьектов классов имплементят Serializable или помечаются tranzient!!!
//        поля помеченные tranzient не должны учавствовать в hascod!!!
//        при сериализации потомка родительские поля помечены как tranzient (если родитель не имплементит Serializable)!!!

//        создаем сериализуемый обьект
        Pers pers = new Pers(20, 100, 100, 1);

//        пишем объект в файл
        FileOutputStream outputStream = new FileOutputStream(filePath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(pers);
        objectOutputStream.close();

//        читаем из файла
        FileInputStream inputStream = new FileInputStream(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Pers outPers = (Pers) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(outPers);
        new File(filePath).delete();

    }
}
