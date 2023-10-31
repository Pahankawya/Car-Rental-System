package lk.ijse.spring.carRentSystem.repo;

import lk.ijse.spring.carRentSystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {

}
