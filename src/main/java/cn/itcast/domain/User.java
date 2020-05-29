package cn.itcast.domain;

import java.util.Date;
import java.util.List;

public class User {
    private Integer id;
    private Date birthday;
    private String username;
    private String sex;
    private String address;

    private List<Account> accounts;

    private List<Role> roles;

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public User() {
    }

    public User(Integer id, Date birthday, String username, String sex, String address) {
        this.id = id;
        this.birthday = birthday;
        this.username = username;
        this.sex = sex;
        this.address = address;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", birthday=" + birthday +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
