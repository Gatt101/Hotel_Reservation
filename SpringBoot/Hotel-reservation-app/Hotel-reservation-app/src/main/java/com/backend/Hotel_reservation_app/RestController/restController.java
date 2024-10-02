package com.backend.Hotel_reservation_app.RestController;
import com.backend.Hotel_reservation_app.entity.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.backend.Hotel_reservation_app.service.serviceProvider;
import java.util.List;

@RestController
@RequestMapping("/api")
public class restController {

    private serviceProvider ServiceProvider;
    @Autowired
    public restController(serviceProvider ServiceProvider)
    {
        this.ServiceProvider = ServiceProvider;
    }
    @GetMapping("/hello")
    public String print(){
        return "rest controller works";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/customers")
    public List<customer> findAll(){
        return ServiceProvider.findAll();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/customers/{customerId}")
    public customer findByID(@PathVariable int customerId)
    {
        customer Customer = ServiceProvider.findCustomer(customerId);
        if(Customer == null)
        {
            throw new RuntimeException("Customer id not found"+customerId);
        }
        return  Customer;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/customers")
    public customer addCustomer(@RequestBody customer theCustomer){
        theCustomer.setId(0);
        customer dbCustomer=ServiceProvider.save(theCustomer);
        return dbCustomer;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/customers/{customerId}")
    public void deleteCustomer(@PathVariable int customerId)
    {
        customer thecustomer= ServiceProvider.findCustomer(customerId);
        if(thecustomer == null){
            throw new RuntimeException("Customer id not found"+customerId);
        }
        ServiceProvider.deleteCustomer(customerId);
    }

    @CrossOrigin(origins= "http://localhost:4200")
    @PutMapping("/customers/{customerId}")
    public customer updateEmployee(@PathVariable int customerId,@RequestBody customer theCustomer)
    {
        customer dbCustomer = ServiceProvider.findCustomer(customerId);

        if (dbCustomer == null) {
            throw new RuntimeException("Customer id not found: " + customerId);
        }

        // Update the existing customer with new details
        dbCustomer.setName(theCustomer.getName());
        dbCustomer.setEmail(theCustomer.getEmail());
        dbCustomer.setRoomNumber(theCustomer.getRoomNumber());
        dbCustomer.setCheckInDate(theCustomer.getCheckInDate());
        dbCustomer.setCheckOutDate(theCustomer.getCheckOutDate());

        // Save the updated customer
        ServiceProvider.save(dbCustomer);

        return dbCustomer;  // Return the updated customer
    }
}
