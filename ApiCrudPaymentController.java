package com.Tugastopikkhusus2.Tugastopikkhusus2.controller;

import com.Tugastopikkhusus2.Tugastopikkhusus2.model.TbTransactions;
import com.Tugastopikkhusus2.Tugastopikkhusus2.model.TbTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api-crud-payment")

public class ApiCrudPaymentController {

    @Autowired
    TbTransactionsRepository tbTransactionsRepository;
    // create
    @RequestMapping(value="/create", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody TbTransactions create(@RequestBody TbTransactions request) {
        // logic untuk insert data ke table transactions
        TbTransactions tbTransactions = new TbTransactions();
        tbTransactions.setAmount(request.getAmount());
        tbTransactions.setCreatedBy(1);
        tbTransactions.setDescription(request.getDescription());
        tbTransactions.setTransactionId(request.getTransactionId());
        tbTransactions.setCreatedDt(new Date());
        tbTransactionsRepository.save(tbTransactions);
        return tbTransactions;
    }

    // read all
    @RequestMapping(value="/read-all", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<TbTransactions> readAll() {
        return tbTransactionsRepository.findAll();
    }

    // read all - by amount
    @RequestMapping(value="/read-all-by-amount/{amount}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<TbTransactions> readAllByAmount(@PathVariable("amount") BigDecimal amount) {
        return tbTransactionsRepository.findAllByAmount(amount);
    }

    // read one - by id
    @RequestMapping(value="/read-one-by-id/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    TbTransactions readOneById(@PathVariable("id") Integer id) {
        return tbTransactionsRepository.findById(id).get();
    }

    // update one - by id
    @RequestMapping(value="/update-one-by-id/{id}", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody TbTransactions updateOneById(@PathVariable("id") Integer id, @RequestBody TbTransactions request) {
        TbTransactions tbTransactions = tbTransactionsRepository.findById(id).get();

        if(request.getAmount() != null) tbTransactions.setAmount(request.getAmount());

        if(request.getDescription() != null) tbTransactions.setDescription(request.getDescription());

        tbTransactions.setUpdatedDt(new Date());
        tbTransactions.setUpdatedBy(1);
        tbTransactionsRepository.save(tbTransactions);
        return tbTransactions;
    }

    // delete one - by id
    @RequestMapping(value="/delete-one-by-id/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody
    Map<String, String> deleteOneById(@PathVariable("id") Integer id) {
        TbTransactions tbTransactions = tbTransactionsRepository.findById(id).get();
        tbTransactionsRepository.delete(tbTransactions);
        return Map.of("message", "success");
    }

}
