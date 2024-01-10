import java.util.Scanner;

public class UserInterfaceImpl implements UserInterface {
    private Singleton singleton;
    private DataProvider dataprovider;
    private Format format;
    private Exchange exchange;
    private Ccollection collection;

    void init() {
        singleton = Singleton.getInstance();
        format = singleton.getFormat();
        dataprovider = singleton.getDataProvider();
        format.setByte(dataprovider.getData());
        collection = singleton.getFormat().getCollection();
        collection.addItem(new Waluta("zloty (Polska)", 1.0, "PLN", 1.0)); //dodanie zlotego polskiego
        format.setCcollection();

    }

    public UserInterfaceImpl() {

    }

    @Override
    public void showAll() {
        // Implementacja wyświetlania dostępnych walut
        init();

        System.out.println("Dostępne waluty:");
        for (Waluta waluta : collection.getCollection()) {
            System.out.println("Nazwa: " + waluta.getNazwa());
            System.out.println("Przelicznik: " + waluta.getPrzelicznik());
            System.out.println("Kod waluty: " + waluta.getKodWaluty());
            System.out.println("Kurs: " + waluta.getKurs());
            System.out.println("---------------------");
        }
    }

    @Override
    public int exchange() {
        init();

        exchange = singleton.getExchange();

        System.out.println("Wybierz waluty do przeliczenia.");

        String kodW1 = "", kodW2 = "";
        double ilosc = 0.0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj kod waluty dla W1: ");
        if (scanner.hasNext()) {
            kodW1 = scanner.next();
        } else {
            System.out.println("To nie jest string");
            return 1;
        }

        System.out.print("Podaj kod waluty dla W2: ");
        if (scanner.hasNext()) {
            kodW2 = scanner.next();
        } else {
            System.out.println("To nie jest string");
            return 1;
        }

        System.out.print("Podaj ilosc do przeliczenia: ");
        if (scanner.hasNextDouble()) {
            ilosc = scanner.nextDouble();
        } else {
            System.out.println("To nie jest double");
            return 1;
        }
        Waluta W1 = null;
        Waluta W2 = null;

// Teraz możesz przypisać wczytane kody do odpowiednich obiektów W1 i W2
        exchange.setAmount(ilosc);

        for (Waluta waluta : collection.getCollection()) {
            if (waluta.getKodWaluty().equals(kodW1)) {
                W1 = waluta;
            }
            if (waluta.getKodWaluty().equals(kodW2)) {
                W2 = waluta;
            }
        }

        if (W1 == null || W2 == null) {
            System.out.println("Nie można znaleźć wybranych walut w kolekcji.");
            return 1;
        }

        if (W1.getKurs() == 0 || W2.getKurs() == 0) {
            System.out.println("Kursy walut nieustawione.");
            return 1;
        }

        exchange.setW1(W1);
        exchange.setW2(W2);

        double kursW1 = W1.getKurs();
        double kursW2 = W2.getKurs();

        System.out.println("Kurs " + kodW1 + " " + kursW1 + " Kurs " + kodW2 + " " + kursW2);

        double result = exchange.result();

        System.out.println("Wynik przeliczenia z: " + exchange.getAmount() + " " + W1.getKodWaluty() + " to " + result + " " + W2.getKodWaluty());
        return 0;
    }
}
