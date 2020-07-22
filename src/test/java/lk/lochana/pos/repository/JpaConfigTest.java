package lk.lochana.pos.repository;

import lk.lochana.pos.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class JpaConfigTest {

    @Autowired
    CustomerRepository repository;

    @Test
    public void testGetAllCustomer(){
        List<Customer> all = repository.findAll();
        for (Customer c: all) {
            System.out.println(c.getId());
        }
    }
}
