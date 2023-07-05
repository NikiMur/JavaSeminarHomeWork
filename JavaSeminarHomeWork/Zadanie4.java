import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Zadanie4 {
    private static Logger logger = Logger.getLogger(Zadanie4.class.getName());

    public static void main(String[] args) {
        // Настройка логгера
        try {
            FileHandler fileHandler = new FileHandler("sort.log");
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Не удалось создать файл лога", e);
        }

        // Исходный массив
        int[] array = {5, 2, 8, 12, 1, 7};

        logger.info("Исходный массив: " + Arrays.toString(array));

        // Сортировка пузырьком
        bubbleSort(array);

        logger.info("Отсортированный массив: " + Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Обмен элементов
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true;
                }
            }

            logger.info("Итерация " + (i + 1) + ": " + Arrays.toString(array));

            // Если во время итерации не было обменов, то массив уже отсортирован
            if (!swapped) {
                break;
            }
        }
    }
}

