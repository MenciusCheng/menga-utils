package cn.net.menga.json;

import java.util.List;
import java.util.Optional;

/**
 * Created by Marvel on 2018/5/24.
 */
public class Giant {

    private Optional<Integer> id;
    private Optional<String> name;
    private Optional<Double> height;
    private Optional<Long> createdAt;
    private List<GiantItem> items;

    public Giant() {}

    public Giant(Optional<Integer> id, Optional<String> name, Optional<Double> height, Optional<Long> createdAt, List<GiantItem> items) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.createdAt = createdAt;
        this.items = items;
    }

    public Giant(Optional<Integer> id, Optional<String> name, Optional<Double> height) {
        this.id = id;
        this.name = name;
        this.height = height;
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

    public Optional<Double> getHeight() {
        return height;
    }

    public void setHeight(Optional<Double> height) {
        this.height = height;
    }

    public Optional<Long> getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Optional<Long> createdAt) {
        this.createdAt = createdAt;
    }

    public List<GiantItem> getItems() {
        return items;
    }

    public void setItems(List<GiantItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Giant{" +
                "id=" + id +
                ", name=" + name +
                ", height=" + height +
                ", createdAt=" + createdAt +
                ", items=" + items +
                '}';
    }
}
