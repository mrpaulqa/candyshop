package com.candyshop.membershipcrud;

import com.candyshop.membershipcrud.Membership;
import com.candyshop.membershipcrud.MembershipResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class MembershipController {

    public final static Logger LOGGER = Logger.getLogger(MembershipController.class.getName());

    @GetMapping("/membership")
    public MembershipResponse getAll() {
        Membership membership = new Membership();
        membership.setId(1);
        MembershipResponse membershipResponse = new MembershipResponse();
        membershipResponse.setMembership(Arrays.asList(membership));
        return membershipResponse;
    }

    @PostMapping(path="/membership/add")
    public @ResponseBody
    String addNewMembership() {
        Membership membership = new Membership();
        return "Saved";
    }

    @GetMapping(path="/membership/{id}")
    public Membership get(@PathVariable Integer id){
        Membership membership = new Membership();
        membership.setId(id);
        return membership;
    }

    @PutMapping(value = "/membership/update/{id}")
    public Membership updateMembership(@PathVariable Integer id,@RequestBody Membership membership){
        membership.setDiscount(membership.getDiscount());
        membership.setId(membership.getId());
        membership.setLabel(membership.getLabel());
        LOGGER.info(membership.toString());
        return membership;
    }

    @DeleteMapping(value = "/membership/delete/{id}")
    public String deleteMembership(@PathVariable Integer id){
        getAll().getMembership().remove(id);
        return "Deleted candy with id: "+id;
    }

    @PatchMapping(value = "/membership/patch/{id}")
    public @ResponseBody String updateMembershipPartially(@PathVariable Integer id, @RequestBody Map<String,Object> changes){

        return "";
    }

}
