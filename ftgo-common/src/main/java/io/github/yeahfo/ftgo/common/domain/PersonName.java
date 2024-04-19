package io.github.yeahfo.ftgo.common.domain;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema( description = "The name of a person" )
public record PersonName(
        @Schema( requiredMode = Schema.RequiredMode.REQUIRED,
                description = "The name given to you at birth, before your last name." )
        String firstName,
        @Schema( requiredMode = Schema.RequiredMode.REQUIRED,
                description = "Your family name used in formal Settings or with people you don't know well." )
        String lastName ) {
}
