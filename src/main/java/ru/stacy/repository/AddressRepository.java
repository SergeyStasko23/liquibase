package ru.stacy.repository;

import ru.stacy.domain.Address;

public interface AddressRepository extends AbstractRepository<Address> {
    Address findByCompanyId(Long id);
}
