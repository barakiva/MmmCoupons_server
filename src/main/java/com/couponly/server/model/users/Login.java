package com.couponly.server.model.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor
@Entity
public class Login {
    @Id
    private long id;
    private String password;
    private String username;
    @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;
}
