package com.yoti.wedding_invite.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "invitee_person")
public class InviteePerson {

    @Id
    @SequenceGenerator(name = "invitee_person_seq",
            sequenceName = "invitee_person_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "invitee_person_seq")
    @Column(name = "id", updatable = false, unique = true)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "from", cascade = CascadeType.ALL)
    private Set<Invitation> invitation = new HashSet<>();
    private String name;

    @Enumerated(EnumType.STRING)
    private Relation relation = Relation.FRIEND;

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InviteePerson that = (InviteePerson) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Set<Invitation> getInvitation() {
        return invitation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Relation getRelation() {
        return relation;
    }

    public enum Relation{
        FRIEND,PARTNER,SIBLINGS
    }
}
