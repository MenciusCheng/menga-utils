package cn.net.menga.utils;

/**
 * Created by Marvel on 18/09/28.
 */
public class Rabbit {

    private int id;
    private String name;
    private String remark;

    public Rabbit() {
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Rabbit{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", remark='").append(remark).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
