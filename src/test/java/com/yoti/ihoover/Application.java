package com.yoti.ihoover;

import com.yoti.ihoover.repository.HooverResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @Autowired
    HooverResultRepository hooverResultRepository;

    @RequestMapping(value= "/", method = RequestMethod.POST)
    String home(@RequestBody CleanSchedule cleanSchedule) {
        hooverResultRepository.save(cleanSchedule.getResult());
        return cleanSchedule.getResult().toString();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
