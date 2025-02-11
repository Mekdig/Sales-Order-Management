package org.zeetransportations.salesordermanagement.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zeetransportations.salesordermanagement.entity.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
}
