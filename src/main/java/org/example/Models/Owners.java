package org.example.Models;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Table(name = "OWNERS_TABLE")
@Entity
public class Owners {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    private String name;

    @ManyToMany
    private List<Cats> catsList = new ArrayList<>();

    public void addCat(Cats cat) {
        catsList.add(cat);
    }

}
