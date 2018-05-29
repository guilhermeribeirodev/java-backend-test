package com.yoti.wedding_invite.integration;

import com.yoti.ihoover.domain.Hoover;
import com.yoti.wedding_invite.Application;
import com.yoti.wedding_invite.model.InviteePerson;
import com.yoti.wedding_invite.repository.InviteePersonRepo;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

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
}
