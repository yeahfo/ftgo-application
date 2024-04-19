package io.github.yeahfo.ftgo.customers.domain;

import java.util.Optional;

public interface CustomerRepository {

    Customer save( Customer customer );

    Optional< Customer > findById( long id );
}
