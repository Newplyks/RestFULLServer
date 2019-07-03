package model;

public class Category {
    int idCat;
    String Name;


    public Category(int idCat, String name) {
        this.idCat = idCat;
        Name = name;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getNaame() {
        return Name;
    }

    public void setNaame(String naame) {
        Name = naame;
    }
}
