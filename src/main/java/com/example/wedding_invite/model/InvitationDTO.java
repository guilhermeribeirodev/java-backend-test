package com.example.wedding_invite.model;

import java.util.List;

public class InvitationDTO{

    private List<Invitation> invitations;

    String toName;
    String fromName;
    Relation relation;

    public Relation getRelation() {
        return relation;
    }

    public InvitationDTO(String toName, String fromName, Relation relation) {
        this.toName = toName;
        this.fromName = fromName;
        this.relation = relation;
    }

    public List<Invitation> getInvitations() {
        return invitations;
    }

}

