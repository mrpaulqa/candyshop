package com.pavlo.candyshop.entity;

import lombok.Data;

import java.util.List;

@Data
public class CandiesResponse {
    private List<Candy> candies;
}
