package com.sga.training;

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

    public Expense(UUID uuid, String name, LocalDateTime creationDate, PaymentMethod paymentMethod, String amount){
        this.uuid = uuid;
        this.name = name;
        this.creationDate = creationDate;
        this.paymentMethod = paymentMethod;
        this.amount = new BigDecimal(amount);
    }

    public Expense(String name, PaymentMethod paymentMethod, String amount){
        this(UUID.randomUUID(), name, LocalDateTime.now(), paymentMethod, amount);
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
