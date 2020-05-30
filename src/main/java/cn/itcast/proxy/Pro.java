package cn.itcast.proxy;

public class Pro implements Product{
    @Override
    public void sale(float money) {
        System.out.println(money);
    }

    @Override
    public void after(float money) {
        System.out.println(money);
    }
}
