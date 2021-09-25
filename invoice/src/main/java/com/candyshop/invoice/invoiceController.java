package com.candyshop.invoice;

import com.candyshop.customerscrud.CustomerController;
import com.candyshop.customerscrud.entity.Customer;
import com.candyshop.invoice.entity.Invoice;
import com.candyshop.invoice.entity.InvoiceResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class invoiceController {
    public final static Logger LOGGER = Logger.getLogger(CustomerController.class.getName());

    @GetMapping("/invoices")
    public InvoiceResponse getAll() {
        Invoice invoice = new Invoice();
        invoice.setCustomer(new Customer());
        invoice.setItems(Arrays.asList("Item 1","Item 2"));
        InvoiceResponse invoiceResponse = new InvoiceResponse();
        invoiceResponse.setInvoiceList(Arrays.asList(invoice));
        return invoiceResponse;
    }
    @PostMapping(path="/invoices/add")
    public @ResponseBody
    String addNewInvoice (@RequestBody Invoice invoice) {
        invoice.setCustomer(new Customer());
        invoice.setItems(Arrays.asList("Item 1","Item 2"));
        return "Saved";
    }

    @PutMapping(value = "/invoices/update/{id}")
    public Invoice updateInvoice(@PathVariable Integer id,@RequestBody Invoice invoice){
        invoice.setCustomer(new Customer());
        invoice.setItems(Arrays.asList("Item 1","Item 2"));
        LOGGER.info(invoice.toString());
        return invoice;
    }

    @DeleteMapping(value = "/invoices/delete/{id}")
    public String deleteInvoice(@PathVariable Integer id){
        getAll().getInvoiceList().remove(id);
        return "Deleted candy with id: "+id;
    }

    @PatchMapping(value = "/invoices/patch/{id}")
    public @ResponseBody String updateInvoicePartially(@PathVariable Integer id, @RequestBody Map<String,Object> changes){

        return "";
    }
}
