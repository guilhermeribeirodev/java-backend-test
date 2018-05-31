package com.example.ihoover.service;

import com.example.ihoover.HooverResult;
import com.example.ihoover.domain.CleanSchedule;
import com.example.ihoover.repository.HooverResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
