package com.devland.walletapi.wallet;

import java.time.LocalDateTime;
// import java.util.List;

import javax.persistence.Entity;
// import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
// import javax.persistence.OneToMany;

import com.devland.walletapi.customer.Customer;
import com.devland.walletapi.utils.Convertable;
// import com.devland.walletapi.transactionHistory.TransactionHistory;
import com.fasterxml.jackson.annotation.JsonBackReference;
// import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Wallet implements Convertable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String walletName;
    private Integer balance;
    private LocalDateTime createdAt;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // @JsonManagedReference
    // @OneToMany(mappedBy = "wallet", fetch = FetchType.LAZY)
    // private List<TransactionHistory> transactionHistories;
}
