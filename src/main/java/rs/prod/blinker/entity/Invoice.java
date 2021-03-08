package rs.prod.blinker.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

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
	@OneToOne(cascade = ALL)
	private InvoiceDetails invoiceDetail;
	
}