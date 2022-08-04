package org.example.Models;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Table(name = "CATS_TABLE")
@Entity
public class Cats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    private String name;
    private int age;
    private String breed;

    @ManyToMany(mappedBy = "catsList")
    private List<Owners> ownersList = new ArrayList<>();

    public void addOwner(Owners owner) {
        ownersList.add(owner);
    }
}
