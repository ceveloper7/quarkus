package com.sga.training.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Expense {
    enum PaymentMethod{
        CASH,
        CREDIT_CARD,
        DEBIT_CARD
    }

    private UUID uuid;
    private String name;
    private LocalDateTime creationDate;
    private PaymentMethod paymentMethod;
    private BigDecimal amount;

    public Expense(UUID uuid, String name, LocalDateTime creationDate, PaymentMethod paymentMethod, BigDecimal amount){
        this.uuid = uuid;
        this.name = name;
        this.creationDate = creationDate;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    public Expense(String name, PaymentMethod paymentMethod, BigDecimal amount){
        this(UUID.randomUUID(), name, LocalDateTime.now(), paymentMethod, amount);
    }
}
