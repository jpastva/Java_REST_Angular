package com.joelenpastva.Assignment5;

import com.joelenpastva.Assignment5.models.Starship;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StarshipController {
    @RequestMapping("/starships")
    public List<Starship> starships()
    {
        return DataStore.listStarships();
    }

    @GetMapping("/starships/{id}")
    public Starship getStarshipById(@PathVariable(value = "id") int starshipId) {
        return DataStore.findStarshipById(starshipId);
    }

    @PostMapping("/starships/")
    public void createStarship(@RequestBody Starship starshipToAdd) {
        DataStore.saveStarship(starshipToAdd);
    }

    @PutMapping("/starships/{id}")
    public Starship updateExistingStarship(@PathVariable(value = "id") int starshipId,@RequestBody Starship starshipToUpdate) {
        return DataStore.updateStarship(starshipId, starshipToUpdate);
    }

    @DeleteMapping("/starships/{id}")
    public void delete(@PathVariable(value = "id") int starshipId) {
        DataStore.deleteStarship(starshipId);
    }
}
