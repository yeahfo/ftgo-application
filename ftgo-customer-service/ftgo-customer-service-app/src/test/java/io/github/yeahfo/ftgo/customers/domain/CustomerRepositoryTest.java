package io.github.yeahfo.ftgo.customers.domain;

import io.eventuate.tram.spring.inmemory.TramInMemoryConfiguration;
import io.github.yeahfo.ftgo.common.domain.PersonName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;


import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Import( TramInMemoryConfiguration.class )
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;

    @Test
    void save( ) {
        Customer customer = customerRepository.save( Customer.create( new PersonName( "Jack", "Son" ) ).result );
        assertNotNull( customer.id( ) );
    }

    @Test
    void findById( ) {
        save( );
        assertTrue( customerRepository.findById( 1 ).isPresent( ) );
        assertTrue( customerRepository.findById( 2 ).isEmpty( ) );
    }
}