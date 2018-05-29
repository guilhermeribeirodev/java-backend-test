package com.yoti.wedding_invite.integration;

import com.yoti.wedding_invite.Application;
import com.yoti.wedding_invite.model.Invitation;
import com.yoti.wedding_invite.model.InviteePerson;
import com.yoti.wedding_invite.repository.InviteePersonRepo;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles(profiles = { "test" })
public class InviteePersonIT {

    @Autowired
    private InviteePersonRepo inviteePersonRepo;

    @Test
    public void testCrit(){
        inviteePersonRepo.save(new InviteePerson());
        InviteePerson i = new InviteePerson();
        i.setId(1L);
        assertThat(inviteePersonRepo.find(), Is.is(i));
    }

    @Test
    public void shouldBringInviteesNamesByPerson(){

        generateDataForTest();

        InviteePerson user = inviteePersonRepo.find();
        assertThat(user.getInvitation().iterator().next().getFrom().getName(), Is.is("gui"));
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
        for(long i = 0 ; i < 100; i++){
            p = new InviteePerson();
            p.setName("gui "+i);
            p = (InviteePerson) inviteePersonRepo.save(p);
            user.getInvitation().add(new Invitation(user, p));
        }

        inviteePersonRepo.save(user);

        for(InviteePerson person : (List<InviteePerson>)inviteePersonRepo.findAll()){
            user.getInvitation().add(new Invitation(user, person));
        }
        inviteePersonRepo.save(user);

    }
}
