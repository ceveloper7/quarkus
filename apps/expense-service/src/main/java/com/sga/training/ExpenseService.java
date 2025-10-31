package com.sga.training;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.POST;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

/**
 * CDI Bean ExpensiveService
 * @ApplicationScope -> Se creara para toda la aplicacion una instancia del bean ExpenseService
 *                      se podra inyectar donde se necesite.
 */
@ApplicationScoped
public class ExpenseService {
    private Set<Expense> expenses = Collections.newSetFromMap(Collections.synchronizedMap(new HashMap<>()));

    // metodo init() se ejecuta luego que el objeto se construya
    @PostConstruct
    void init(){
        expenses.add(new Expense("Laptop", Expense.PaymentMethod.CREDIT_CARD, "1000"));
        expenses.add(new Expense("Coffe", Expense.PaymentMethod.CASH, "15"));
    }

    public Set<Expense> list(){
        return expenses;
    }

    public Expense create(Expense expense){
        expenses.add(expense);
        return expense;
    }

    public boolean delete(UUID uuid){
        return expenses.removeIf(expense -> expense.getUuid().equals(uuid));
    }

    public void update(Expense expense){
        delete(expense.getUuid());
        create(expense);
    }
}
