package com.candyshop.invoice.entity;

import lombok.Data;

import java.util.List;

@Data
public class CandyResponse {
    private  List<Candy> candies;

}
