package pds.stardust.scaccount.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pds.stardust.scaccount.entity.CustomerEntity;
import pds.stardust.scaccount.service.CustomerService;

@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @RequestMapping(value = {"/"})
    String index() { return "API account"; }

    @PostMapping(value = "/connect", consumes = "application/json", produces = "application/json")
    public CustomerEntity connect (@RequestBody CustomerEntity customer) {
        CustomerEntity customerEntity = customerService.findByUsername(customer.getUsername());
        if (customerEntity.getPassword().equals(customer.getPassword())) {
            return customerEntity;
        } else {
            return null;
        }
    }

}
