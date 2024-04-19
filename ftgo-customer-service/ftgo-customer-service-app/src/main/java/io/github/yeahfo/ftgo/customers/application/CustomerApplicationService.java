package io.github.yeahfo.ftgo.customers.application;

import io.eventuate.tram.events.aggregates.ResultWithDomainEvents;
import io.github.yeahfo.ftgo.customers.common.application.CreateCustomerCommand;
import io.github.yeahfo.ftgo.customers.common.domain.CustomerDomainEvent;
import io.github.yeahfo.ftgo.customers.common.resource.CustomerRepresentation;
import io.github.yeahfo.ftgo.customers.domain.Customer;
import io.github.yeahfo.ftgo.customers.domain.CustomerDomainEventPublisher;
import io.github.yeahfo.ftgo.customers.domain.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomerApplicationService {
    private final CustomerRepository repository;
    private final CustomerDomainEventPublisher domainEventPublisher;

    public CustomerApplicationService( CustomerRepository repository, CustomerDomainEventPublisher domainEventPublisher ) {
        this.repository = repository;
        this.domainEventPublisher = domainEventPublisher;
    }

    @Transactional
    public CustomerRepresentation createCustomer( CreateCustomerCommand command ) {
        ResultWithDomainEvents< Customer, CustomerDomainEvent > resultWithDomainEvents = Customer.create( command.name( ) );
        return Optional.of( this.repository.save( resultWithDomainEvents.result ) ).map( then -> {
            this.domainEventPublisher.publish( then, resultWithDomainEvents.events );
            return then.representation( );
        } ).orElseThrow( RuntimeException::new );
    }

    public Optional< CustomerRepresentation > getCustomer( long id ) {
        return this.repository.findById( id ).map( Customer::representation );
    }
}
