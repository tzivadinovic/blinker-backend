package rs.prod.blinker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "city")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class City extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "city_id")
	private Integer id;
	@Column(name = "city")
	private String city;
	@Column(name = "zipcode")
	private String zipcode;
	
}