package com.isd.ideas.roles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity

@Table(name = "role",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "id"),
            @UniqueConstraint(columnNames = "type")}
)
public class Role {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "type", unique = true, nullable = false)
    private String type;

    public Role(long id, String type) {
        this.id = id;
        this.type = type;
    }
    public Role() {
       
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("TYPE: %s ID: %d", type, id);
    }
}
