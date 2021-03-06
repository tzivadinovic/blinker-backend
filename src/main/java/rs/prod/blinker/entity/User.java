package rs.prod.blinker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "user")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class User extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "user_id")
	private Integer id;
	@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
	@ManyToOne
	private Employee employeeId;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	
}