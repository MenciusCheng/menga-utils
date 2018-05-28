package cn.net.menga.json;

import java.util.Optional;

/**
 * Created by Marvel on 2018/5/24.
 */
public class GiantItem {

    private Optional<Integer> id;
    private Optional<String> name;
    private Optional<Double> price;
    private Optional<Long> createdAt;

    public GiantItem(Optional<Integer> id, Optional<String> name, Optional<Double> price, Optional<Long> createdAt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createdAt = createdAt;
    }

    public Optional<Integer> getId() {
        return id;
    }

    public void setId(Optional<Integer> id) {
        this.id = id;
    }

    public Optional<String> getName() {
        return name;
    }

    public void setName(Optional<String> name) {
        this.name = name;
    }

    public Optional<Double> getPrice() {
        return price;
    }

    public void setPrice(Optional<Double> price) {
        this.price = price;
    }

    public Optional<Long> getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Optional<Long> createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "GiantItem{" +
                "id=" + id +
                ", name=" + name +
                ", price=" + price +
                ", createdAt=" + createdAt +
                '}';
    }
}
