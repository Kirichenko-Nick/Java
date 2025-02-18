package Yandex.Sprint2.Ratgeber;

import java.util.Scanner;

class Practicum {
    public static void main(String[] args) {
        // double[] expenses = new double[7]; // должно стать полем нового класса

        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько денег у вас осталось до зарплаты?");
        double moneyBeforeSalary = scanner.nextDouble();
        System.out.println("Сколько дней до зарплаты?");
        int daysBeforeSalary = scanner.nextInt();


        Converter converter = new Converter(94.8, 103.8, 13.1);
        DinnerAdvisor dinnerAdvisor = new DinnerAdvisor();
        ExpenesManager expenesManager = new ExpenesManager(); // здесь создайте объект класса ExpensesManager

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                System.out.println("Ваши сбережения: " + moneyBeforeSalary + " RUB");
                System.out.println("В какую валюту хотите конвертировать? Доступные варианты: 1 - USD, 2 - EUR,"
                        + " 3 - CNY.");
                int currency = scanner.nextInt();
                converter.convert(moneyBeforeSalary, currency);
            } else if (command == 2) {
                dinnerAdvisor.getAdvice(moneyBeforeSalary, daysBeforeSalary);
            } else if (command == 3) {
                System.out.println("За какой день вы хотите ввести трату: 1-ПН, 2-ВТ, 3-СР, 4-ЧТ, 5-ПТ, 6-СБ, 7-ВС?");
                int day = scanner.nextInt();
                System.out.println("Введите размер траты:");
                double expense = scanner.nextDouble();
                moneyBeforeSalary = expenesManager.saveExpense(moneyBeforeSalary, day, expense);
            } else if (command == 4) {
                expenesManager.printAllExpenses();
            } else if (command == 5) {
                System.out.println("Самая большая сумма расходов на этой неделе составила "
                        + expenesManager.findMaxExpense() + " руб.");
            } else if (command == 0) {
                scanner.close();
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    // перенесите в ExpensesManager код методов saveExpense, findMaxExpense и printAllExpenses

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Конвертировать валюту");
        System.out.println("2 - Получить совет");
        System.out.println("3 - Ввести трату");
        System.out.println("4 - Показать траты за неделю");
        System.out.println("5 - Показать самую большую сумму расходов за неделю");
        System.out.println("0 - Выход");
    }
}


/*
Успех!
        Решение прошло все проверки!  (＾ｖ＾)
*/


