package dev.tiagosilva.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressModel extends Model {
    String street;
    int number;
    String comp;
    String neighborhood;
    Long id_user;

    public AddressModel() {
        super("addresses.csv");
    }

    public AddressModel(String street, int number, String comp, String neighborhood, Long id_user) {
        super("addresses.csv");
        this.street = street;
        this.number = number;
        this.comp = comp;
        this.neighborhood = neighborhood;
        this.id_user = id_user;
    }
}
