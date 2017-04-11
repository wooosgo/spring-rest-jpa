package hello;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Column
    private LocalDateTime dt;

    protected Customer() {}

    public Customer(String firstName, String lastName, LocalDateTime dt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dt = dt;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s', dateTime='%s']",
                id, firstName, lastName, dt);
    }

}