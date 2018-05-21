package com.joelenpastva.Assignment5;

import com.joelenpastva.Assignment5.models.Visit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VisitController {
    @RequestMapping("/visits")
    public List<Visit> visits()
    {
        return DataStore.listVisits();
    }

    /*@PostMapping("/visit")
    public Visit updateVisit*/

}
