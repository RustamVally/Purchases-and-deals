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

    public Flat getById(long id) {
        for (Flat item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Flat add(Flat item) {
        item.setId(nextId++);
        items.add(item);
        return item;
    }

    public Flat update(Flat item) {
        final int index = findIndexById(item.getId());
        if (index == -1) {
            // TODO: Exception (элемент не найден)
            return null;
        }
        items.set(index, item);
        return item;
    }

    public Flat deleteById(long id) {
        final int index = findIndexById(id);
        if (index == -1) {
            return null;
        }
        return items.remove(index);
    }


    private int findIndexById(long id) {
        int index = 0;
        for (Flat item : items) {
            if (item.getId() == id) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
