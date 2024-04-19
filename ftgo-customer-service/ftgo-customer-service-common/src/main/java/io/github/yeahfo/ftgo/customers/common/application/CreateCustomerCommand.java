package io.github.yeahfo.ftgo.customers.common.application;

import io.github.yeahfo.ftgo.common.domain.PersonName;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request body of create a customer command.")
public record CreateCustomerCommand( PersonName name ) {
}
