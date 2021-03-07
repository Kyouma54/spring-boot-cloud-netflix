package br.com.kyouma54.web.rest;

import br.com.kyouma54.service.CustomerService;
import br.com.kyouma54.service.dto.CustomerDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller para gerenciar {@link br.com.kyouma54.domain.Customer}.
 */
@RestController
@RequestMapping("/api")
public class CustomerResource {

    private final Logger log = LoggerFactory.getLogger(CustomerResource.class);

    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * {@code POST  /customers} : Criar um novo customer.
     *
     * @param customerDTO o customerDTO a ser criado.
     * @return a {@link ResponseEntity} com status {@code 201 (Created)} e com o corpo do novo customerDTO, ou status {@code 400 (Bad Request)} se o customer já tiver um identificador.
     * @throws URISyntaxException se a localização da URI estiver errada.
     */
    @PostMapping("/customers")
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) throws URISyntaxException {
        log.debug("REST request to save Customer : {}", customerDTO);
        if (customerDTO.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Entidade já existente em banco de dados!");
        }
        CustomerDTO result = customerService.save(customerDTO);
        return ResponseEntity.created(new URI("/api/customers/" + result.getId())).body(result);
    }

    /**
     * {@code PUT  /customers} : Altera um customer existente.
     *
     * @param customerDTO o customerDTO a ser alterado.
     * @return a {@link ResponseEntity} com status {@code 200 (OK)} e com o corpo alterado customerDTO,
     * ou com status {@code 400 (Bad Request)} se o customerDTO for inválido,
     * ou com status {@code 500 (Internal Server Error)} se o customerDTO não for alterado.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/customers")
    public ResponseEntity<CustomerDTO> updateCustomer(@Valid @RequestBody CustomerDTO customerDTO) throws URISyntaxException {
        log.debug("REST request to update Customer : {}", customerDTO);
        if (customerDTO.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificador inválido");
        }
        CustomerDTO result = customerService.save(customerDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /customers} : Listar todos os customers.
     *
     * @return a {@link ResponseEntity} com status {@code 200 (OK)} e no corpo a lista de customers.
     */
    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        log.debug("REST request to get Customers by criteria: {}");
        return ResponseEntity.ok().body(customerService.findAllWithoutCriteria());
    }

    /**
     * {@code GET  /customers/count} : quantifica todos os customers.
     *
     * @return a {@link ResponseEntity} com status {@code 200 (OK)} e quantidade no body.
     */
    @GetMapping("/customers/count")
    public ResponseEntity<Long> countCustomers() {
        log.debug("REST request to count Customers");
        return ResponseEntity.ok().body(customerService.count());
    }

    /**
     * {@code GET  /customers/:id} : listar um customer por identificador.
     *
     * @param id o identificador do customer a ser retornado.
     * @return a {@link ResponseEntity} com o status {@code 200 (OK)} e com o corpo o customerDTO, ou o status {@code 404 (Not Found)}.
     */
    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Long id) {
        log.debug("REST request to get Customer : {}", id);
        Optional<CustomerDTO> customerDTO = customerService.findOne(id);
        return customerDTO.map(response -> ResponseEntity.ok(response)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * {@code DELETE  /customers/:id} : deletar customer por identificador.
     *
     * @param id o identificador do customer a ser deletado.
     * @return a {@link ResponseEntity} com status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        log.debug("REST request to delete Customer : {}", id);
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
