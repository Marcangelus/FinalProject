package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**@author Marc */
@Entity
@Table(name = "Users")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;    
    @Column(name = "Nick", unique = false, nullable = false, length = 30)
    String nickUser;
    @Column(name = "Password", unique = false, nullable = false, length = 20)
    String Password;
    @Column(name = "Role", length = 2)
    int Role;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickUser() {
        return nickUser;
    }

    public void setNickUser(String nickUser) {
        this.nickUser = nickUser;
    }    
    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getRole() {
        return Role;
    }

    public void setRole(int Role) {
        this.Role = Role;
    }

}
