package io.github.yeahfo.ftgo.customers.domain;

import io.eventuate.tram.events.aggregates.ResultWithDomainEvents;
import io.github.yeahfo.ftgo.common.domain.PersonName;
import io.github.yeahfo.ftgo.customers.common.domain.CustomerDomainEvent;
import io.github.yeahfo.ftgo.customers.common.resource.CustomerRepresentation;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Optional;

@Schema
public class Customer {
    private Long id;
    private PersonName name;

    private Customer( ) {

    }

    public static ResultWithDomainEvents< Customer, CustomerDomainEvent > create( PersonName name ) {
        Optional.ofNullable( name.firstName( ) ).orElseThrow( ( ) -> new IllegalArgumentException( "First name is null" ) );
        Optional.ofNullable( name.lastName( ) ).orElseThrow( ( ) -> new IllegalArgumentException( "Last name is null" ) );
        Customer customer = new Customer( );
        customer.id = null;
        customer.name = name;
        return new ResultWithDomainEvents<>( customer );
    }

    public Long id( ) {
        return id;
    }

    public CustomerRepresentation representation( ) {
        return new CustomerRepresentation( id( ), name );
    }
}
