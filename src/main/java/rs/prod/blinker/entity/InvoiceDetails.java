package rs.prod.blinker.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "invoice_details")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class InvoiceDetails extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "invoice_detail_id")
	private Integer id;
	@JoinColumn(name = "transport_term_id", referencedColumnName = "transport_term_id")
	@ManyToOne
	private TransportTerm transportTermId;
	@JoinColumn(name = "currency_id", referencedColumnName = "currency_id")
	@ManyToOne
	private Currency currencyId;
	@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
	@ManyToOne
	private Employee employeeId;
	@JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id")
	@ManyToOne
	private Invoice invoiceId;
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
	@ManyToOne
	private Customer customerId;
	@Column(name = "number")
	private String number;
	@Column(name = "date")
	private LocalDate date;
	@Column(name = "payment_conditions")
	private String paymentConditions;
	@Column(name = "box_number")
	private Integer boxNumber;
	@Column(name = "total_boxes")
	private Integer totalBoxes;
	@Column(name = "remarks")
	private String remarks;
	@Column(name = "gross_weight")
	private Double grossWeight;
	@Column(name = "net_weight")
	private Double netWeight;
	@Column(name = "shipping_fees")
	private Double shippingFees;
	@Column(name = "total_price")
	private Double totalPrice;
	@Column(name = "items_info")
	private String itemsInfo;
	
}