package projet1.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String login;

    @OneToMany(mappedBy = "user")
    private List<Character> characters = new ArrayList<Character>();

    public User(String email, String login) {
        this.email = email;
        this.login = login;
    }

    public User(){
    }
}
