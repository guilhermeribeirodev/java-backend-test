package com.yoti.ihoover.controller;

import com.yoti.ihoover.CleanSchedule;
import com.yoti.ihoover.repository.HooverResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CleanScheduleController {

    @Autowired
    HooverResultRepository hooverResultRepository;

    @RequestMapping(value= "/", method = RequestMethod.POST)
    String home(@RequestBody CleanSchedule cleanSchedule) {
        hooverResultRepository.save(cleanSchedule.getResult());
        return cleanSchedule.getResult().toString();
    }
}
