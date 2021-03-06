package rs.prod.blinker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "invoice")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Invoice extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "invoice_id")
	private Integer id;
	@JoinColumn(name = "invoice_detail_id", referencedColumnName = "invoice_detail_id")
	@ManyToOne
	private InvoiceDetails invoiceDetailId;
	
}