package rs.prod.blinker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

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
	private State stateId;
	@JoinColumn(name = "city_id", referencedColumnName = "city_id")
	@ManyToOne
	private City cityId;
	@Column(name = "name")
	private String name;
	
}