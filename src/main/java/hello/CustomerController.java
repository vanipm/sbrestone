package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class CustomerController {

    private static final String template = "Customer found with findByFirstName('Alice'): %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private CustomerRepository repository;


    @RequestMapping("/customer")
    //public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    public Greeting greeting() {

      // save a couple of customers
        this.repository.save(new Customer("Alice", "Smith"));
        this.repository.save(new Customer("Bob", "Smith"));

        return new Greeting(counter.incrementAndGet(),
                            String.format(template,this.repository.findByFirstName("Alice")));

    }
}
