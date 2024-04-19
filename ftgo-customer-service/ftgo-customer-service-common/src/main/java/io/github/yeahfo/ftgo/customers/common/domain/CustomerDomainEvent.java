package io.github.yeahfo.ftgo.customers.common.domain;

import io.eventuate.tram.events.common.DomainEvent;

public interface CustomerDomainEvent extends DomainEvent {
    String aggregateType = " io.github.yeahfo.ftgo.customers.domain.Customer";
}
