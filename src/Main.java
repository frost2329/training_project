import entity.*;
import print.ConsolePrinter;
import print.FilePrinter;
import print.IPrinter;
import save.FileSaver;
import save.ISaver;
import save.RuntimeSaver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ISaver saver = null;
    private static IPrinter printer = null;
    private static final Scanner scanner = new Scanner(System.in);

    private static void print(String text) {
        System.out.println(text);
    }

    public static void main(String[] args) {
        initSaver();
        initPrinter();
        boolean exit = false;
        while (!exit) {
            print("Выберете действие");
            print("1 - Показать коллекцию");
            print("2 - Вывести коллекцию");
            print("3 - Добавить объект в коллекцию");
            print("4 - Удалить объект из коллекции");
            print("5 - Изменить способ сохранения");
            print("6 - Изменить способ вывода");
            print("0 - Выход");
            switch (scanner.nextInt()) {
                case 0:
                    exit = true;
                case 1:
                    showDevices(saver.getAll());
                    break;
                case 2:
                    printer.print(saver.getAll());
                    break;
                case 3:
                    addObjectToCollection();
                    break;
                case 4:
                    removeObjectFromCollection();
                    break;
                case 5:
                    initSaver();
                    break;
                case 6:
                    initPrinter();
                    break;
                default:
                    break;
            }
        }

    }
    private static void addObjectToCollection() {
        print("Выберете тип объекта");
        print("1 - Phone");
        print("2 - Laptop");
        print("3 - Mouse");
        print("0 - Выход");
        switch (scanner.nextInt()) {
            case 0:
                break;
            case 1:
                saver.save(new Phone(Brand.NOKIA, 3000, 5));
                print("Phone успешно добавлен");
                break;
            case 2:
                saver.save(new Laptop(Brand.HP, 50000, 10, MatrixType.IPS));
                print("Laptop успешно добавлен");
                break;
            case 3:
                saver.save(new Mouse(Brand.HP, 500, Color.BlACK));
                print("Mouse успешно добавлен");
                break;
            default:
                break;
        }
    }

    private static void removeObjectFromCollection() {
        print("1 - Удалить один объект");
        print("2 - Удалить все");
        switch (scanner.nextInt()) {
            case 1:
                print("Введите индекс объекта для удаления");
                showDevices(saver.getAll());
                int index = scanner.nextInt();
                saver.dropByPosition(index);
                break;
            case 2:
                saver.dropAll();
                break;
            default:
                break;
        }
    }

    private static void initSaver() {
        print("Введите способ хранения");
        print("1 - Runtime");
        print("2 - File");
        switch (scanner.nextInt()) {
            case 1:
                saver = new RuntimeSaver();
                break;
            case 2:
                saver = new FileSaver();
                break;
            default:
                saver = new RuntimeSaver();
        }
    }

    private static void initPrinter() {
        print("Введите способ вывода");
        print("1 - Console");
        print("2 - File");
        switch (scanner.nextInt()) {
            case 1:
                printer = new ConsolePrinter();
                break;
            case 2:
                printer = new FilePrinter();
                break;
            default:
                printer = new FilePrinter();
        }
    }

    public static void showDevices(List<Device> devices) {
        for (int i = 0; i < devices.size(); i++) {
            System.out.println(i + " - " + devices.get(i));
        }
        System.out.println("_____________________");
    }
}
