package io.github.yeahfo.ftgo.customers.domain;

import io.eventuate.tram.events.aggregates.AbstractAggregateDomainEventPublisher;
import io.eventuate.tram.events.publisher.DomainEventPublisher;
import io.github.yeahfo.ftgo.customers.common.domain.CustomerDomainEvent;
import org.springframework.stereotype.Component;

@Component
public class CustomerDomainEventPublisher extends AbstractAggregateDomainEventPublisher< Customer, CustomerDomainEvent > {
    public CustomerDomainEventPublisher( DomainEventPublisher eventPublisher ) {
        super( eventPublisher, Customer.class, Customer::id );
    }
}
