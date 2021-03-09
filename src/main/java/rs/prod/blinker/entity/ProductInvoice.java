package rs.prod.blinker.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference
    @ToString.Exclude
    private Invoice invoice;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne
    private Product product;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "item_number")
    private Integer itemNumber;
    @Column(name = "box_number")
    private Integer boxNumber;

}