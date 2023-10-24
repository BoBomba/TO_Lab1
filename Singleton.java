public class Singleton {
    private static Singleton singleton = null;

    private DataProvider dataProvider;
    private Exchange exchange;
    private UserInterface userInterface;
    private Format format;

    private Singleton() {
        // Tutaj inicjalizujesz zależności, np. tworzysz obiekty dataProvider, exchange, userInterface i format.
        this.dataProvider = new DataProvider();
        this.exchange = new Exchange(new Waluta("USD", 1.0, "USD", 1.0), new Waluta("EUR", 0.85, "EUR", 0.85), 0.0);
        this.userInterface = new UserInterfaceImpl();
        this.format = new Format(new Ccollection());
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
