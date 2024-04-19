package io.github.yeahfo.ftgo.customers.infrastructure;

import io.github.yeahfo.ftgo.customers.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository< Customer, Long> {
}
