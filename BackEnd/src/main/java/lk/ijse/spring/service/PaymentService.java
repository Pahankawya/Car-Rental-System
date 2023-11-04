package lk.ijse.spring.service;

import lk.ijse.spring.dto.PaymentDTO;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentService {
    public void savePayment(PaymentDTO paymentDTO) throws RuntimeException;

    public List<PaymentDTO> loadAllPayments() throws RuntimeException;

    public List<PaymentDTO> getPaymentsByNic(String nic) throws RuntimeException;

    public List getDailyIncome() throws RuntimeException;

    public List getMonthlyIncome() throws RuntimeException;

    public List getYearlyIncome() throws RuntimeException;

    public BigDecimal getCurrentDayIncome() throws RuntimeException;

    public BigDecimal getCurrentMonthIncome() throws RuntimeException;

    public BigDecimal getCurrentYearIncome() throws RuntimeException;
}
