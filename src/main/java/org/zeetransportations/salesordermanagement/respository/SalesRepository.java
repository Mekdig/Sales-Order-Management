package org.zeetransportations.salesordermanagement.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zeetransportations.salesordermanagement.entity.Sales;

public interface SalesRepository extends JpaRepository<Sales, Integer> {
}
