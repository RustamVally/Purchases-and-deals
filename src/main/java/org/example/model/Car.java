package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car extends Transport {
    private List<String> model;
    private List<String> manufacturer;

    public Car(long id, String name, int price, List<String> model, List<String> manufacturer) {
        super(id, name, price);
        this.model = model;
        this.manufacturer = manufacturer;
    }
}
