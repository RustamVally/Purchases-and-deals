package org.example.manager;

import org.example.model.Transport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransportManager {
    private long nextId = 1;
    private List<Transport> items = new ArrayList<>();

    public Transport add(Transport item) {
        item.setId(nextId++);
        items.add(item);
        return item;
    }
}
