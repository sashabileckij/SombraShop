package models;

/**
 * Клас який описує лоти
 */
public class Lot {

    private long id;
    private String jpg;
    private String name;
    private String price;
    private String category;

    public Lot() {
    }

    public Lot(long id, String jpg, String name, String price, String category) {
        this.id = id;
        this.jpg = jpg;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJpg() {
        return jpg;
    }

    public void setJpg(String jpg) {
        this.jpg = jpg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Lot{" +
                "id=" + id +
                ", jpg='" + jpg + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
