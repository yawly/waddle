package au.com.waddle.demo.second;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FavouriteStats {
    @Id
    @GeneratedValue
    private long id;

    private long count = 0;

    public FavouriteStats() {}

    public void increment() {
        count++;
    }

    public long getCount() {
        return count;
    }

    @Override public String toString() {
        return "FavouriteStats{" +
                "id=" + id +
                ", count=" + count +
                '}';
    }
}
