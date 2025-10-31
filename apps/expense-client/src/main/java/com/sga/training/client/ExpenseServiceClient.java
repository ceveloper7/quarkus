package com.sga.training.client;

import com.sga.training.model.Expense;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.Set;

@Path("/expenses")
@RegisterRestClient(configKey = "expense-service")
public interface ExpenseServiceClient {
    @GET
    public Set<Expense> getAll();

    @POST
    public Expense create(Expense expense);
}
