import java.util.*;

public class Notebook {
    private String brand;
    private int ram;
    private int storage;
    private String os;
    private String color;
    private double price;

    public Notebook(String brand, int ram, int storage, String os, String color, double price) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("HP", 8, 256, "Windows 10", "Silver", 799.99));
        notebooks.add(new Notebook("Dell", 16, 512, "Windows 10", "Black", 1299.99));
        notebooks.add(new Notebook("Lenovo", 8, 512, "Windows 10", "Silver", 899.99));
        notebooks.add(new Notebook("Apple", 16, 256, "macOS", "Space Gray", 1499.99));
        notebooks.add(new Notebook("Asus", 12, 1, "Windows 10", "Gold", 1199.99));

        Map<Integer, String> filters = new HashMap<>();
        filters.put(1, "RAM");
        filters.put(2, "Storage");
        filters.put(3, "OS");
        filters.put(4, "Color");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер критерия фильтрации: ");
        System.out.println("1 RAM ");
        System.out.println("2 Storage ");
        System.out.println("3 OS ");
        System.out.println("4 Color ");
        int criterion = scanner.nextInt();

        if (filters.containsKey(criterion)) {
            String filter = filters.get(criterion);
            System.out.println("Введите минимальное значение для критерия \"" + filter + "\": ");
            int minValue = scanner.nextInt();

            Set<Notebook> filteredNotebooks = filterNotebooks(notebooks, filter, minValue);
            System.out.println("Результаты фильтрации:");
            for (Notebook notebook : filteredNotebooks) {
                System.out.println(notebook.getBrand() + ", " + notebook.getRam() + "GB RAM, " + notebook.getStorage() + "GB Storage, " +
                        notebook.getOs() + ", " + notebook.getColor() + ", $" + notebook.getPrice());
            }
        } else {
            System.out.println("Неверный номер критерия фильтрации!");
        }
    }

    public static Set<Notebook> filterNotebooks(Set<Notebook> notebooks, String filter, int minValue) {
        Set<Notebook> filteredNotebooks = new HashSet<>();
        for (Notebook notebook : notebooks) {
            if (filter.equals("RAM") && notebook.getRam() >= minValue) {
                filteredNotebooks.add(notebook);
            } else if (filter.equals("Storage") && notebook.getStorage() >= minValue) {
                filteredNotebooks.add(notebook);
            } else if (filter.equals("OS") && notebook.getOs().equalsIgnoreCase(String.valueOf(minValue))) {
                filteredNotebooks.add(notebook);
            } else if (filter.equals("Color") && notebook.getColor().equalsIgnoreCase(String.valueOf(minValue))) {
                filteredNotebooks.add(notebook);
            }
        }
        return filteredNotebooks;
    }
}
