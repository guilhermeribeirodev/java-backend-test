package com.example.ihoover.integration;

import com.example.ihoover.domain.Hoover;
import com.example.ihoover.repository.HooverResultRepository;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ActiveProfiles(profiles = { "test" })
public class HooverResultIntTest {

    @Autowired
    private HooverResultRepository hooverResultRepository;

    final int[] patches = new int[]{5,6};
    final List<Integer> integerList = new ArrayList<>(Arrays.asList(2,3));
    final List<List<Integer>> arrayLists =
            new ArrayList<>(
                    Arrays.asList(
                            new ArrayList<>(Arrays.asList(3,4)),
                            new ArrayList<>(Arrays.asList(3,4))
                    )
            );

    @Test
    public void testCrit(){
        hooverResultRepository.save(new Hoover());
        Hoover hoover = new Hoover();
        hoover.setId(1L);
        assertThat(hooverResultRepository.findAllByBuilder().next(), Is.is(hoover));
    }



//    @Test
//    public void list(){
//        hooverResultRepository.result(new CleanSchedule(patches,
//                integerList,
//                arrayLists,
//                ""
//
//        ));
//    }
}
