package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Motorcycle extends Transport {
    private String model;

    public Motorcycle(long id, String name, int price) {
        super(id, name, price);
    }

}
