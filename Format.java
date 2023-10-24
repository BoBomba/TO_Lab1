public class Format {
    private byte[] byteData;
    private Ccollection ccollection;

    public Format(Ccollection collection) {
        this.ccollection = collection;
    }

    public void setByte(byte[] byteData) {
        this.byteData = byteData;
    }

    public Ccollection getCollection() {
        return ccollection;
    }
}
