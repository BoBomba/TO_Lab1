public class Exchange {
    private Waluta W1;
    private Waluta W2;
    private double amount;

    public Exchange(Waluta W1, Waluta W2, double amount) {
        this.W1 = W1;
        this.W2 = W2;
        this.amount = amount;
    }

    public void setW1(Waluta W1) {
        this.W1 = W1;
    }

    public Waluta getW1() {
        return W1;
    }

    public void setW2(Waluta W2) {
        this.W2 = W2;
    }

    public Waluta getW2() {
        return W2;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public double result() {
        // Tutaj możesz zaimplementować logikę przeliczania walut na podstawie kursów i ilości.
        // W przykładzie poniżej zakładamy, że kurs przelicznika W1 na W2 wynosi 2.
        return amount * W1.getKurs() / W2.getKurs();
    }
}
