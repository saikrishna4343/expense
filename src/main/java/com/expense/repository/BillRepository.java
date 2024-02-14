package com.expense.repository;

import com.expense.entity.Bill;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>, JpaSpecificationExecutor<Bill> {

    Optional<Bill> findByBillNumber(UUID uuid);

    List<Bill> findAll(Specification<Bill> specification);

    default Specification<Bill> billTypeSpecification(String billType){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("billType"), billType);
    }
}
