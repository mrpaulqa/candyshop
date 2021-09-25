package com.candyshop.membershipcrud;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Discount {
    Float amount;
    LocalDate begin, end;
    Object asset;
}
