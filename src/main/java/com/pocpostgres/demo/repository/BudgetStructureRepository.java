package com.pocpostgres.demo.repository;

import com.pocpostgres.demo.model.BudgetStructure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetStructureRepository extends JpaRepository<BudgetStructure, Integer> {

}
