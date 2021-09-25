package com.candyshop.invoice.entity;

import lombok.Data;

import java.util.List;
@Data
public class InvoiceResponse {
    private List<Invoice> invoiceList;
}
