package org.example.manager;

import org.example.model.Flat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlatManager {
    private final int itemsPerPage = 5;
    private long nextId = 1;
    private List<Flat> items = new ArrayList<>();

    public List<Flat> getPage(int page) {
        final int fromIndex = (page - 1) * itemsPerPage;
        final int toIndex = fromIndex + itemsPerPage;
        return items.subList(fromIndex, toIndex);
    }

    public Flat add(Flat item) {
        item.setId(nextId++);
        items.add(item);
        return item;
    }
}
