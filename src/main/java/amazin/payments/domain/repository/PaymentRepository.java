package amazin.payments.domain.repository;

import amazin.payments.domain.entity.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment,String> {
}
