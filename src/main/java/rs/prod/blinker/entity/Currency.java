package rs.prod.blinker.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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