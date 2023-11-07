import java.util.Scanner;
import java.math.*;

public class UserInterfaceImpl implements UserInterface {
    private Singleton singleton;

    private DataProvider dataprovider;

    private Format format;

    private Exchange exchange;

    private Ccollection collection;

    public UserInterfaceImpl() {

    }

    @Override
    public void showAll() {
        // Implementacja wyświetlania dostępnych walut
        singleton = Singleton.getInstance();
        format = singleton.getFormat();
        dataprovider = singleton.getDataProvider();
        format.setByte(dataprovider.getData());
        collection = singleton.getFormat().getCollection();
        format.setCcollection();

        Waluta zlotypolski = new Waluta("zloty (Polska)",1.0,"PLN",1.0);
        collection.addItem(zlotypolski);

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
        singleton = Singleton.getInstance();

        exchange = singleton.getExchange();
        format = singleton.getFormat();
        dataprovider = singleton.getDataProvider();
        format.setByte(dataprovider.getData());
        collection = singleton.getFormat().getCollection();
        format.setCcollection();

        Waluta zlotypolski = new Waluta("zloty (Polska)",1.0,"PLN",1.0);
        collection.addItem(zlotypolski);

        System.out.println("Wybierz waluty do przeliczenia.");

        // Znajdź obiekty W1 i W2 na podstawie kodu waluty



        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj kod waluty dla W1: ");
        String kodW1 = scanner.next();

        System.out.print("Podaj kod waluty dla W2: ");
        String kodW2 = scanner.next();

        System.out.print("Podaj ilosc do przeliczenia: ");
        double ilosc = scanner.nextDouble();

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

        System.out.println("Wynik przeliczenia z: "+ exchange.getAmount() + W1.getKodWaluty() + " to " + result + W2.getKodWaluty());
        return 0;
    }
}
