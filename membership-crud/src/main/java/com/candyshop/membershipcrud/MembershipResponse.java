package com.candyshop.membershipcrud;

import lombok.Data;

import java.util.List;
@Data
public class MembershipResponse {
    private List<Membership> membershipList;
}
