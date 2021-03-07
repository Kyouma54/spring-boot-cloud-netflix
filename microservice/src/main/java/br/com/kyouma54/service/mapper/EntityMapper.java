package br.com.kyouma54.service.mapper;

import java.util.List;

/**
 * Interface para mapeamento entidade e DTO.
 *
 * @param <D> - Tipo parâmetro DTO.
 * @param <E> - Tipo parâmetro Entidade.
 */

public interface EntityMapper <D, E> {

    E toEntity(D dto);

    D toDto(E entity);

    List <E> toEntity(List<D> dtoList);

    List <D> toDto(List<E> entityList);
}
