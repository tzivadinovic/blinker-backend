package rs.prod.blinker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "transport_term")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class TransportTerm extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "transport_term_id")
	private Integer id;
	@Column(name = "term")
	private String term;
	
}