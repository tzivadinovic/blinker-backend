package rs.prod.blinker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "currency")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Currency extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "currency_id")
	private Integer id;
	@Column(name = "currency")
	private String currency;
	
}