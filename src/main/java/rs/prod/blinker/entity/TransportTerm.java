package rs.prod.blinker.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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