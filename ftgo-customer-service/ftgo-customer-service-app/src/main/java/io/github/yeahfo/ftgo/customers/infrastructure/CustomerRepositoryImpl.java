package io.github.yeahfo.ftgo.customers.infrastructure;

import io.github.yeahfo.ftgo.customers.domain.Customer;
import io.github.yeahfo.ftgo.customers.domain.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private final CustomerJpaRepository jpaRepository;

    public CustomerRepositoryImpl( CustomerJpaRepository jpaRepository ) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Customer save( Customer customer ) {
        return jpaRepository.save( customer );
    }

    @Override
    public Optional< Customer > findById( long id ) {
        return jpaRepository.findById( id );
    }
}
