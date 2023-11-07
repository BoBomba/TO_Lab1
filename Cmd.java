import java.util.Scanner;

public class Cmd {
    private UserInterface userInterface;
    private Singleton singleton;

    public Cmd() {
        singleton = Singleton.getInstance();
        userInterface = singleton.getUserInterface();
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        int choice;

        while (!exit) {
            choice = 0;
            System.out.println("Wybierz opcję:");
            System.out.println("1. Wyświetl dostępne waluty");
            System.out.println("2. Wykonaj przeliczenie walut");
            System.out.println("3. Wyjście");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Wpisz cyfre int opcji!!!");
                break;
            }

            switch (choice) {
                case 1:
                    userInterface.showAll();
                    break;
                case 2:
                    userInterface.exchange();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Nieprawidłowa opcja. Wybierz ponownie.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Cmd cmd = new Cmd();
        cmd.start();
    }
}
