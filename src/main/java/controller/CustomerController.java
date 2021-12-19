package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.ICustomerService;

import java.util.Optional;


@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/create")
    public String showFormCreate() {
        return "/create";
    }

    @PostMapping("/create")
    public String create(Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("")
    public String showList(Model model) {
        Iterable<Customer> customerIterable = customerService.findAll();
        model.addAttribute("customers", customerIterable);
        return "/list";
    }



    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        customerService.remove(id);
        return "redirect:/customers";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id,Model model){
        Optional<Customer> customer = customerService.findById(id);
        Customer customer1 = customer.get();
        model.addAttribute("customer",customer1);
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit1(@ModelAttribute Customer customer){
        customerService.save(customer);
        return "redirect:/customers";
    }
}
