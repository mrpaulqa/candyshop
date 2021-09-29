package com.candyshop.customerscrud.entity;

import lombok.Data;

import java.util.List;

@Data
public class MembershipResponse {
    private List<Membership> membership;
}
