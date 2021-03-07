package br.com.kyouma54.service.mapper;


import br.com.kyouma54.domain.*;
import br.com.kyouma54.service.dto.CustomerDTO;

import org.mapstruct.*;

/**
 * Mapeador para entidade {@link Customer} e seu DTO {@link CustomerDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CustomerMapper extends EntityMapper<CustomerDTO, Customer> {



    default Customer fromId(Long id) {
        if (id == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setId(id);
        return customer;
    }
}
