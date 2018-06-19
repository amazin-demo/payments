package amazin.payments.domain.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    private final String id = UUID.randomUUID().toString();

    private String accountId;

    private int amount;
}
