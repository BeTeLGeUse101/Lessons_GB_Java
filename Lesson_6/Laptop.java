public class Laptop {

    private String serialNumber; // Серийный номер
    private String brand; // Марка ноутбука
    private String model; // Модель ноутбука
    private double screenSize; // Размер экрана
    private String processor; // Процессор
    private int RAM; // Объём оперативной памяти
    private int storage; // Объём накопителя
    private String isTouchscreen; // Есть ли сенсорный экран
    private String opSys; // Операционная система
    private double price; // Цена ноутбука

    public Laptop (String serialNumber, String brand, String model, double screenSize, String processor,
            int RAM, int storage, String isTouchscreen, String opSys, double price) {
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.model = model;
        this.screenSize = screenSize;
        this.processor = processor;
        this.RAM = RAM;
        this.storage = storage;
        this.isTouchscreen = isTouchscreen;
        this.opSys = opSys;
        this.price = price;
    }

    public String toString() {
        return String.format("Серийный номер: %s\n" +
                            "Марка: %s\n" +
                            "Модель: %s\n" +
                            "Размер экрана: %.1f\"\n" +
                            "Процессор: %s\n" +
                            "Объём оперативной памяти: %dGB\n" +
                            "Объём накопителя: %dGB\n" +
                            "Сенсорный экран: %s\n" +
                            "Операционная система: %s\n" +
                            "Цена ноутбука: %.2f Руб.",
                            serialNumber, brand, model, screenSize, processor, RAM, storage,
                            isTouchscreen, opSys, price);
    }
    
    // Методы класса
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public String getProcessor() {
        return processor;
    }

    public int getRAM() {
        return RAM;
    }

    public int getStorage() {
        return storage;
    }

    public String getIsTouchscreen() {
        return isTouchscreen;
    }

    public String getOpSys() {
        return opSys;
    }

    public double getPrice() {
        return price;
    }
}