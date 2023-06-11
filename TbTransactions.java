package com.Tugastopikkhusus2.Tugastopikkhusus2.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_transactions")

public class TbTransactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "transaction_id", nullable = false, unique = true)
    private String transactionId;
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;
    @Column(name = "created_dt")
    private Date createdDt;
    @Column(name = "updated_dt")
    private Date updatedDt;
    @Column(name = "updated_by")
    private Integer updatedBy;
    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "description")
    private String description;

}
