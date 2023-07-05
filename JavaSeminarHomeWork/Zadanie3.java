import java.util.Scanner;
import java.util.logging.*;

public class Zadanie3 {
    private static final Logger logger = Logger.getLogger(Zadanie3.class.getName());

    public static void main(String[] args) {
        // Настройка логгера
        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);

        try {
            FileHandler fileHandler = new FileHandler("calculator.log");
            fileHandler.setLevel(Level.ALL);
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Не удалось создать файл лога", e);
        }

        // Запуск калькулятора
        Scanner scanner = new Scanner(System.in);
        logger.info("Калькулятор запущен.");

        System.out.print("Введите первое число: ");
        double num1 = scanner.nextDouble();

        System.out.print("Введите второе число: ");
        double num2 = scanner.nextDouble();

        System.out.print("Выберите операцию (+, -, *, /): ");
        String operator = scanner.next();

        double result = calculate(num1, num2, operator);
        logger.info("Результат: " + result);

        System.out.println("Результат: " + result);

        // Закрытие сканнера и логгера
        scanner.close();
        LogManager.getLogManager().reset();
    }

    public static double calculate(double num1, double num2, String operator) {
        double result = 0.0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                logger.info(num1 + " + " + num2 + " = " + result);
                break;
            case "-":
                result = num1 - num2;
                logger.info(num1 + " - " + num2 + " = " + result);
                break;
            case "*":
                result = num1 * num2;
                logger.info(num1 + " * " + num2 + " = " + result);
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                    logger.info(num1 + " / " + num2 + " = " + result);
                } else {
                    logger.warning("Ошибка: деление на ноль.");
                }
                break;
            default:
                logger.warning("Ошибка: некорректный оператор.");
        }

        return result;
    }
}
