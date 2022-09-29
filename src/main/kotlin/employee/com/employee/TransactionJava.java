package employee.com.employee;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionJava {
    public Long id;
    public BigDecimal amount;
    public LocalDateTime transactionTime;
    public String reference;


    public TransactionJava(
            Long newId,
            BigDecimal newAmount,
            LocalDateTime newTransactionTime,
            String newReference
    ) {
        this.id = newId;
        this.amount = newAmount;
        this.transactionTime = newTransactionTime;
        this.reference = newReference;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}

