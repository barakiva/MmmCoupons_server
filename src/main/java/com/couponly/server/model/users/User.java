package com.couponly.server.model.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter @Setter @NoArgsConstructor
@Entity @Table(name = "users")
public class User {
    @Id
    private long id;
    private String firstName;
}
