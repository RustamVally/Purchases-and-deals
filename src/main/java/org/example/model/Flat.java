package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
public class Flat {
    private long id;
    private String name;
    private long price;
    private int rooms;
    private String[] streets;
}
