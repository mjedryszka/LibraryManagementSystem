package system.management.library.item.library;

import javax.persistence.*;

/**
 * Created by Home on 2021-08-03.
 */
@Entity
@Table(schema = "managementlibrarysystemdb", name = "Item")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "item")
public class Item {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "tittle", nullable = false)
    private String tittle;
    @Column(name = "category", nullable = false)
    private String category;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "rating", nullable = false)
    private int rating;

    public Item() {

    }

    public Item(int id, String tittle, String category, String author, int rating) {
        this.id = id;
        this.tittle = tittle;
        this.category = category;
        this.author = author;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
