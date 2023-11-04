package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.PaymentDTO;
import lk.ijse.spring.entity.Payment;
import lk.ijse.spring.entity.Rent;
import lk.ijse.spring.repo.PaymentRepo;
import lk.ijse.spring.repo.RentRepo;
import lk.ijse.spring.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    RentRepo rentRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void savePayment(PaymentDTO paymentDTO) throws RuntimeException {

        Payment payment = mapper.map(paymentDTO, Payment.class);
        Rent rent = rentRepo.findById(paymentDTO.getRentId().getRentId()).get();
        payment.setRentId(rent);
        payment.setDate(LocalDate.now());
        payment.setTime(LocalTime.now());
        paymentRepo.save(payment);

    }

    @Override
    public List<PaymentDTO> loadAllPayments() throws RuntimeException {
        return mapper.map(paymentRepo.findAll(), new TypeToken<ArrayList<PaymentDTO>>() {
        }.getType());
    }

    @Override
    public List<PaymentDTO> getPaymentsByNic(String nic) throws RuntimeException {
        return mapper.map(paymentRepo.findAllByRentId_Nic_Nic(nic), new TypeToken<ArrayList<PaymentDTO>>() {
        }.getType());
    }

    @Override
    public List getDailyIncome() throws RuntimeException {
        return paymentRepo.getDailyIncome();
    }

    @Override
    public List getMonthlyIncome() throws RuntimeException {
        return paymentRepo.getMonthlyIncome();
    }

    @Override
    public List getYearlyIncome() throws RuntimeException {
        return paymentRepo.getYearlyIncome();
    }

    @Override
    public BigDecimal getCurrentDayIncome() throws RuntimeException {
        return paymentRepo.getCurrentDayIncome();
    }

    @Override
    public BigDecimal getCurrentMonthIncome() throws RuntimeException {
        return paymentRepo.getCurrentMonthIncome();
    }

    @Override
    public BigDecimal getCurrentYearIncome() throws RuntimeException {
        return paymentRepo.getCurrentYearIncome();
    }
}
