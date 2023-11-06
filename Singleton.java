public class Singleton {
    private static Singleton singleton = new Singleton();

    private DataProvider dataProvider;
    private Exchange exchange;
    private UserInterface userInterface;
    private Format format;


    private Singleton() {
        dataProvider = new DataProvider();
        userInterface = new UserInterfaceImpl();
        exchange = new Exchange();
        format = new Format(new Ccollection());
    }

    public static Singleton getInstance() {
        return singleton;
    }

    public DataProvider getDataProvider() {
        return dataProvider;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public UserInterface getUserInterface() {
        return userInterface;
    }

    public Format getFormat() {
        return format;
    }
}
