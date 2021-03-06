package rs.prod.blinker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "state")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class State extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "state_id")
	private Integer id;
	@Column(name = "name")
	private String name;
	
}