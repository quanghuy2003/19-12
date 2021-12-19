package service;


import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ICustomerRepository;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iProductRepository;

    @Override
    public Iterable<Customer> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void save(Customer product) {
        iProductRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        iProductRepository.deleteById(id);
    }
}
