package model;

public class Account {
    private String name;
    private String email;
    private String password;

    public Account(String name, String email, String password){// добавляем конструкторы — со всеми параметрами и без параметров
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Account(){
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
