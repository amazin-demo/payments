package amazin.payments.domain.mapping;

import amazin.kernel.payment.command.ProcessPayment;
import amazin.kernel.payment.dto.PaymentDto;
import amazin.payments.domain.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapping {
    PaymentMapping INSTANCE = Mappers.getMapper(PaymentMapping.class);

    PaymentDto paymentToPaymentDto(Payment payment);

    Payment paymentDtoToPayment(PaymentDto dto);

    Payment processPaymentToPayment(ProcessPayment command);
}
