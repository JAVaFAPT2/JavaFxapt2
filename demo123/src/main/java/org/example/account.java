package entity;

import java.util.Objects;

public class account {
    private int id;
    private String name;
    private String password;
    private String accountType;
    private int userId;

    public account() {
    }

    public account(int id, String name, String password, String accountType, int userId) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.accountType = accountType;
        this.userId = userId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof account account)) return false;
        return userId == account.userId && Objects.equals(name, account.name) && Objects.equals(password, account.password) && Objects.equals(accountType, account.accountType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, accountType, userId);
    }

    @Override
    public String toString() {
        return "account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", accountType='" + accountType + '\'' +
                ", userId=" + userId +
                '}';
    }
}
