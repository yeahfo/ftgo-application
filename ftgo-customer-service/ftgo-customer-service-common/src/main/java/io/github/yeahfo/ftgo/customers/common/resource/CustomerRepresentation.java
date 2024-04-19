package io.github.yeahfo.ftgo.customers.common.resource;

import io.github.yeahfo.ftgo.common.domain.PersonName;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema( description = "Customer information." )
public record CustomerRepresentation( @Schema( description = "Customer identity." ) Long id,
                                      @Schema( description = "Customer name." ) PersonName name ) {
}
