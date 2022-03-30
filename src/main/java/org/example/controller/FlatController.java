package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.manager.FlatManager;
import org.example.model.Flat;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class FlatController {
    private FlatManager manager;

    // TODO: CRUD
    //  - create
    //  - read (getPage & getById)
    //  - update
    //  - delete

    // TODO: http://localhost:9999/getPage?page=1
    @RequestMapping("/getPage")
    public List<Flat> getPage(@RequestParam int page) {
        return manager.getPage(page);
    }


    // TODO: http://localhost:9999/add?id=0&name=Flat&price=1000000&rooms=3&streets=Krasnaya&streets=Belaya
    @RequestMapping("/add")
    public Flat add(@ModelAttribute Flat item) {
        return manager.add(item);
    }
}
