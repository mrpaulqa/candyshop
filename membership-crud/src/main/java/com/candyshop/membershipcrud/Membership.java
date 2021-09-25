package com.candyshop.membershipcrud;

import lombok.Data;

@Data
public class Membership {
    Integer id;
    String label;
    Discount discount;
}
