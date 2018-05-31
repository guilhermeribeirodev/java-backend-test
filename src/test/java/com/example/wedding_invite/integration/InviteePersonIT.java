package com.example.wedding_invite.integration;

import com.example.wedding_invite.Application;
import com.example.wedding_invite.model.Invitation;
import com.example.wedding_invite.model.InviteePerson;
import com.example.wedding_invite.model.Relation;
import com.example.wedding_invite.repository.InviteePersonRepo;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles(profiles = { "test" })
public class InviteePersonIT {

    @Autowired
    private InviteePersonRepo inviteePersonRepo;

    @Test
    public void shouldBringInviteesNamesByPerson(){

        generateDataForTest();

        InviteePerson user = inviteePersonRepo.find("gui");
        assertThat(user.getInvitations().iterator().next().getTo().getName(), Is.is("gui"));
    }

    @Test
    public void shouldBringInviteesNamesByRelation(){

        generateDataForTest();

        InviteePerson user = inviteePersonRepo.find("gui");
        List<InviteePerson> invited = inviteePersonRepo.find(user,Relation.FRIEND);
        assertThat(invited.iterator().next().getInvitations().iterator().next().getRelation(),
                Is.is(Relation.FRIEND));
    }

    @Test
    public void shouldBringInviteesRelationByPerson(){

    }

    private void generateDataForTest() {

        InviteePerson user = new InviteePerson();
        user.setName("gui");
        user = (InviteePerson) inviteePersonRepo.save(user);

        //user = inviteePersonRepo.find(1L);

        InviteePerson p;
        for(long i = 0 ; i < 4; i++){
            p = new InviteePerson();
            p.setName("gui "+i);
            user.getInvitations().add(new Invitation(user, (InviteePerson) inviteePersonRepo.save(p)));
        }

         inviteePersonRepo.save(user);

//        for(InviteePerson person : (List<InviteePerson>)inviteePersonRepo.findAll()){
//            user.getInvitation().add(new Invitation(user, person));
//        }
//        inviteePersonRepo.save(user);

    }
}
