package ru.yalta.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    private String id;
    private String userName;
    private String firstName;
    private String mobilePhone;
    private LocalDateTime birthDate;

    public User(String id) {
        this.id = id;
    }
}
