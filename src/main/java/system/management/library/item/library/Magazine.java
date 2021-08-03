package system.management.library.item.library;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Home on 2021-08-03.
 */
@Entity
@DiscriminatorValue("magazine")
public class Magazine extends Item {

    public Magazine() {
    }

    public Magazine(int id, String tittle, String category, String author, int rating) {
        super(id, tittle, category, author, rating);
    }

    @Override
    public String toString() {
        return "magazine";
    }
}
