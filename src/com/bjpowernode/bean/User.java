package com.bjpowernode.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;

    private String name;

    //状态
    private String status;

    //余额
    private BigDecimal money;

    // 标识当前用户是否手里有借书
    private Boolean isLend;

    public User() {
    }

    public User(int id, String name, String status, BigDecimal money, Boolean isLend) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.money = money;
        this.isLend = isLend;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Boolean getLend() {
        return isLend;
    }

    public void setLend(Boolean lend) {
        isLend = lend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(status, user.status) && Objects.equals(money, user.money) && Objects.equals(isLend, user.isLend);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, money, isLend);
    }

    @Override
    public String toString() {
        return "User{" +
          "id=" + id +
          ", name='" + name + '\'' +
          ", status='" + status + '\'' +
          ", money=" + money +
          ", isLend=" + isLend +
          '}';
    }
}
