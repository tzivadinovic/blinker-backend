package rs.prod.blinker.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "product_invoice")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ProductInvoice extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "product_invoice_id")
	private Integer id;
	@JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id")
	@ManyToOne
	private Invoice invoiceId;
	@JoinColumn(name = "product_id", referencedColumnName = "product_id")
	@ManyToOne
	private Product productId;
	@Column(name = "quantity")
	private Integer quantity;
	
}