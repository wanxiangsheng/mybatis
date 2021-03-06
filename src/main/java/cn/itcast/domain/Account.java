package cn.itcast.domain;

public class Account {
    private int id ;
//    private  int uid;
    private double money;
    private User user;

    public Account() {
    }

    public Account(int id, double money, User user) {
        this.id = id;
        this.money = money;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", money=" + money +
                ", user=" + user +
                '}';
    }
}
