package com.sga.training;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.Set;
import java.util.UUID;

/**
 * Clase Controller (Rest Service)
 */

@Path("/expenses")
@Consumes("application/json")
@Produces("application/jason")
public class ExpenseResource {
    @Inject
    public ExpenseService expenseService;

    @GET
    public Set<Expense> list(){
        return expenseService.list();
    }

    @POST
    public Expense create(Expense expense){
        return expenseService.create(expense);
    }

    @DELETE
    @Path("/{uuid}")
    public Set<Expense> delete(@PathParam("uuid") UUID uuid){
        if(!expenseService.delete(uuid)){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return expenseService.list();
    }

    @PUT
    public void update(Expense expense){
        expenseService.update(expense);
    }
}
