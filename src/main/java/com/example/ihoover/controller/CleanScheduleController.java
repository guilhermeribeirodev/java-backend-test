package com.example.ihoover.controller;

import com.example.ihoover.HooverResult;
import com.example.ihoover.domain.CleanSchedule;
import com.example.ihoover.service.HooverService;
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
