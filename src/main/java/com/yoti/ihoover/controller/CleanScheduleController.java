package com.yoti.ihoover.controller;

import com.yoti.ihoover.HooverResult;
import com.yoti.ihoover.domain.CleanSchedule;
import com.yoti.ihoover.repository.HooverResultRepository;
import com.yoti.ihoover.service.HooverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CleanScheduleController {

    @Autowired
    HooverService hooverService;

    @RequestMapping(value= "/clean", method = RequestMethod.POST)
    String home(@RequestBody CleanSchedule cleanSchedule) {
        HooverResult res = hooverService.result(cleanSchedule);
        return res.toString();
    }
}
