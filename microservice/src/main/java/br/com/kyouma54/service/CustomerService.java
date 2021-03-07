package br.com.kyouma54.service;

import br.com.kyouma54.service.dto.CustomerDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Interface de serviço para gerenciar {@link br.com.kyouma54.domain.Customer}.
 */
public interface CustomerService {

    /**
     * Salvar um customer.
     *
     * @param customerDTO entidade para salvar.
     * @return entidade persistida.
     */
    CustomerDTO save(CustomerDTO customerDTO);

    /**
     * Listar todos customers.
     *
     * @param pageable informação de paginação.
     * @return a lita de entidades.
     */
    Page<CustomerDTO> findAll(Pageable pageable);


    /**
     * Listar customer por identificador.
     *
     * @param id id da entidade.
     * @return a entidade.
     */
    Optional<CustomerDTO> findOne(Long id);

    /**
     * Deletar customer por identificador.
     *
     * @param id indentificador da entidade.
     */
    void delete(Long id);

    /**
     * Listar todos customers.
     *
     * @return a lita de entidades.
     */
    List<CustomerDTO> findAllWithoutCriteria();

    /**
     * Quantidade de customers.
     *
     * @return a quantidade de customers.
     */
    Long count();

}
