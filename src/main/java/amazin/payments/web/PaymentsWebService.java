package amazin.payments.web;

import amazin.kernel.payment.command.ProcessPayment;
import amazin.kernel.payment.dto.PaymentDto;
import amazin.payments.domain.entity.Payment;
import amazin.payments.domain.mapping.PaymentMapping;
import amazin.payments.domain.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/payments")
public class PaymentsWebService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentsWebService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @PostMapping("")
    public PaymentDto processPayment(@RequestBody ProcessPayment command) {
        final Payment payment = PaymentMapping.INSTANCE.processPaymentToPayment(command);
        paymentRepository.save(payment);
        return PaymentMapping.INSTANCE.paymentToPaymentDto(payment);
    }
}
