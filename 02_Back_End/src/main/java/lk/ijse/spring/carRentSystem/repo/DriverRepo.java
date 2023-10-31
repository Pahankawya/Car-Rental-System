package lk.ijse.spring.carRentSystem.repo;

import lk.ijse.spring.carRentSystem.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver, String> {
}
