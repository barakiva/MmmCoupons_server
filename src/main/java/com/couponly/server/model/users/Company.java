package com.couponly.server.model.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor
@Entity @Table(name = "companies")
public class Company {
    @Id
    private long id;
    private double revenue;
    @OneToOne(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn
    private User userId;
}
