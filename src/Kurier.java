public class Kurier {
    private int id;
    private String meno;
    private String priezvisko;
    private double plat;

    public Kurier(int id, String meno, String priezvisko, double plat) {
        this.id = id;
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.plat = plat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    public double getPlat() {
        return plat;
    }

    public void setPlat(double plat) {
        this.plat = plat;
    }

    @Override
    public String toString() {
        return "Kurier{" +
                "id=" + id +
                ", meno='" + meno + '\'' +
                ", priezvisko='" + priezvisko + '\'' +
                ", plat=" + plat +
                '}';
    }
}
