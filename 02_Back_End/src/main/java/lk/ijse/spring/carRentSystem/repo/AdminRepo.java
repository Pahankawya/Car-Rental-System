package lk.ijse.spring.carRentSystem.repo;

import lk.ijse.spring.carRentSystem.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, String> {

}
