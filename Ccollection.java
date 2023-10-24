import java.util.ArrayList;
import java.util.List;

public class Ccollection {
    private List<Waluta> col;

    public Ccollection() {
        this.col = new ArrayList<>();
    }

    public Waluta getItem(Waluta waluta) {
        for (Waluta w : col) {
            if (w.equals(waluta)) {
                return w;
            }
        }
        return null;
    }

    public boolean removeItem(Waluta waluta) {
        return col.remove(waluta);
    }

    public void addItem(Waluta waluta) {
        col.add(waluta);
    }

    public Waluta setItem(Waluta newWaluta) {
        for (int i = 0; i < col.size(); i++) {
            if (col.get(i).equals(newWaluta)) {
                col.set(i, newWaluta);
                return newWaluta;
            }
        }
        return null;
    }
}


