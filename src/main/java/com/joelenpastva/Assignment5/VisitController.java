package com.joelenpastva.Assignment5;

import com.joelenpastva.Assignment5.models.Visit;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VisitController {
    @RequestMapping("/visits")
    public List<Visit> visits()
    {
        return DataStore.listVisits();
    }

    @PostMapping("/visits/")
    public Visit createVisit(@RequestBody Visit visitToAdd) {
        return DataStore.saveVisit(visitToAdd);
    }

}
