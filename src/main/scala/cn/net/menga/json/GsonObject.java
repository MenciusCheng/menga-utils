package cn.net.menga.json;

/**
 * Created by Marvel on 18/10/08.
 */
public class GsonObject {

    private int id;
    private String name;
    private Double amount;

    public GsonObject() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GsonObject{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }
}
