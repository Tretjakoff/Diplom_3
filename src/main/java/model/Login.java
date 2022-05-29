package model;

public class Login {
    private String email;
    private String password;

    public Login(String email, String password){// добавляем конструкторы — со всеми параметрами и без параметров
        this.email = email;
        this.password = password;
    }

    public Login(){
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
