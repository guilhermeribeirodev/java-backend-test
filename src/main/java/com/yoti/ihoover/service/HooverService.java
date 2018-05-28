package com.yoti.ihoover.service;

import com.yoti.ihoover.HooverResult;
import com.yoti.ihoover.domain.CleanSchedule;
import com.yoti.ihoover.repository.HooverResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class HooverService{

    @Autowired
    public HooverService(HooverResultRepository hooverResultRepository){

        this.hooverResultRepository = hooverResultRepository;
    }

    private final HooverResultRepository hooverResultRepository;

    public HooverResult result(CleanSchedule cleanSchedule) {
        hooverResultRepository.save(cleanSchedule.getResult());
        return hooverResultRepository.find();
    }
}
