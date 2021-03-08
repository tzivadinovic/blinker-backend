package rs.prod.blinker.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "employee")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Employee extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "employee_id")
    private Integer id;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @OneToOne
    private User user;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "position")
    private String position;
    @Column(name = "bank")
    private String bank;
    @Column(name = "bank_account")
    private String bankAccount;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "employment_start_date")
    private LocalDate employmentStartDate;
    @Column(name = "employment_end_date")
    private LocalDate employmentEndDate;

}