package rs.prod.blinker.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "customer")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Customer extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "customer_id")
    private Integer id;
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    @ManyToOne
    private State state;
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    @ManyToOne
    private City city;
    @Column(name = "name")
    private String name;

}