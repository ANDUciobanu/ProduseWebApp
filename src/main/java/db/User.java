package db;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "produs_generator")
    private int id;

    @Column(name = "user", unique = true, length = 10)
    private String user;



    @Column(name="password")
    private String password;

    @Override
    public String toString() {
        return "db.User{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
