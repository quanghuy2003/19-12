package formatter;


import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import service.ICustomerService;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class ProvinceFormatter implements Formatter<Customer>{
    private ICustomerService productService;

    @Autowired
    public ProvinceFormatter(ICustomerService productService) {
        this.productService = productService;
    }

    @Override
    public Customer parse(String text, Locale locale) throws ParseException {
        Optional<Customer> provinceOptional = productService.findById(Long.parseLong(text));
        return provinceOptional.orElse(null);
    }

    @Override
    public String print(Customer object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
