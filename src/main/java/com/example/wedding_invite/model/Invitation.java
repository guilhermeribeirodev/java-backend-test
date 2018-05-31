package com.example.wedding_invite.model;

import javax.persistence.*;

@Entity
@Table(name = "invitation")
public class Invitation {

    @Id
    @SequenceGenerator(name = "invitation_seq",
            sequenceName = "invitation_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "invitation_seq")
    @Column(name = "id", updatable = false, unique = true)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Relation relation = Relation.FRIEND;

    public Invitation(InviteePerson user, InviteePerson person) {
        this.from = user;
        to = person;
    }

    public Invitation() { }

    public Long getId() {
        return id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private InviteePerson to;

    @ManyToOne(fetch = FetchType.LAZY)
    private InviteePerson from;

    public void setId(Long id) {
        this.id = id;
    }

    public InviteePerson getTo() {
        return to;
    }

    public void setTo(InviteePerson to) {
        this.to = to;
    }

    public InviteePerson getFrom() {
        return from;
    }

    public void setFrom(InviteePerson from) {
        this.from = from;
    }

    public Relation getRelation() {
        return relation;
    }


}
