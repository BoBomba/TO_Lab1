public class Waluta {
    private String nazwa;
    private double przelicznik;
    private String kodWaluty;
    private double kurs;

    public Waluta(String nazwa, double przelicznik, String kodWaluty, double kurs) {
        this.nazwa = nazwa;
        this.przelicznik = przelicznik;
        this.kodWaluty = kodWaluty;
        this.kurs = kurs;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getPrzelicznik() {
        return przelicznik;
    }

    public void setPrzelicznik(double przelicznik) {
        this.przelicznik = przelicznik;
    }

    public String getKodWaluty() {
        return kodWaluty;
    }

    public void setKodWaluty(String kodWaluty) {
        this.kodWaluty = kodWaluty;
    }

    public double getKurs() {
        return kurs;
    }

    public void setKurs(double kurs) {
        this.kurs = kurs;
    }

    public boolean equals(Waluta innaWaluta) {
        if (this == innaWaluta) {
            return true;
        }
        if (innaWaluta == null || getClass() != innaWaluta.getClass()) {
            return false;
        }
        return kodWaluty.equals(innaWaluta.kodWaluty);
    }
}

