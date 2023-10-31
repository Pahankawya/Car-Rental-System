package lk.ijse.spring.carRentSystem.repo;

import lk.ijse.spring.carRentSystem.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, String> {
}
