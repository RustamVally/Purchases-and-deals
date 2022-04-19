package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car extends Transport {
    private String model;
    private String manufacturer;

    public Car(long id, String name, int price, String model, String manufacturer) {
        super(id, name, price);
    }
}
