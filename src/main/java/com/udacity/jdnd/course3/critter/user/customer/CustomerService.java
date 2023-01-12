package com.udacity.jdnd.course3.critter.user.customer;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.pet.PetRepository;
import com.udacity.jdnd.course3.critter.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PetRepository petRepository;

    public CustomerDTO save(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return new CustomerDTO(savedCustomer);
    }

    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        Iterable<Customer> customers = customerRepository.findAll();
        customers.forEach(customer -> {
            List<Pet> pets = petRepository.findAllByOwner_Id(customer.getId());
            customer.setPets(pets);
            customerDTOS.add(new CustomerDTO(customer));
        });
        return customerDTOS;
    }

    public CustomerDTO getOwnerByPet(Long petId) throws UserNotFoundException {
        Customer customer = customerRepository.findByPets_Id(petId).orElseThrow(UserNotFoundException::new);
        List<Pet> pets = petRepository.findAllByOwner_Id(customer.getId());
        customer.setPets(pets);
        return new CustomerDTO(customer);
    }

    public Customer findById(Long id) throws UserNotFoundException {
        return customerRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }
}
