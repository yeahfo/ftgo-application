package io.github.yeahfo.ftgo.customers.resource;

import io.github.yeahfo.ftgo.customers.application.CustomerApplicationService;
import io.github.yeahfo.ftgo.customers.common.application.CreateCustomerCommand;
import io.github.yeahfo.ftgo.customers.common.resource.CustomerRepresentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.springframework.http.HttpStatus.CREATED;


@RestController
@RequestMapping( "/customers" )
@Tag( name = "Customer", description = "The customer management APIs." )
public class CustomerResource {
    private final CustomerApplicationService applicationService;

    public CustomerResource( CustomerApplicationService applicationService ) {
        this.applicationService = applicationService;
    }

    @ResponseStatus( CREATED )
    @PostMapping( consumes = APPLICATION_JSON, produces = APPLICATION_JSON )
    @Operation( summary = "Create a customer.", description = "Provide a name to create a customer." )
    public ResponseEntity< CustomerRepresentation > createCustomer( @RequestBody CreateCustomerCommand command ) {
        CustomerRepresentation created = applicationService.createCustomer( command );
        return ResponseEntity.created( ServletUriComponentsBuilder.fromCurrentRequestUri( ).path( "/{0}" ).build( created.id( ) ) )
                .body( created );
    }

    @GetMapping( value = "/{id}", produces = APPLICATION_JSON )
    @Operation( summary = "Get a customer.", description = "get a customer information." )
    public ResponseEntity< CustomerRepresentation > getCustomer( @Parameter( description = "Customer identity." ) @PathVariable long id ) {
        return this.applicationService.getCustomer( id ).map( ResponseEntity::ok )
                .orElseGet( ( ) -> ResponseEntity.notFound( ).build( ) );
    }
}
