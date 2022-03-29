package org.example.manager;

import org.example.model.Flat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlatManager {
    private long nextId = 1;
    private List<Flat> items = new ArrayList<>();

    public Flat add(Flat item) {
        item.setId(nextId++);
        items.add(item);
        return item;
    }
}
